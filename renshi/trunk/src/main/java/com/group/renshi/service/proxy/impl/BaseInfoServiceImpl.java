package com.group.renshi.service.proxy.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.group.renshi.bean.proxy.BaseInfoBean;
import com.group.renshi.bean.proxy.LicenseInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.bean.system.ValidMailBean;
import com.group.renshi.cache.MailTemplateCache;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.proxy.BaseInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.entity.UserDetails;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.DateUtil;
import com.group.webFramework.uitl.MailSend;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.SessionControl;
import com.group.webFramework.uitl.encrypt.AESEncrypt;
import com.group.webFramework.uitl.encrypt.EncryptFactory;
import com.group.webFramework.uitl.encrypt.IEncrypt;
import com.group.webFramework.uitl.encrypt.MD5Encrypt;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: BaseInfoServiceImpl.java,v 0.1 2015-06-27 下午11:11:39 Exp $
 */
@Service("baseInfoService")
@Transactional
public class BaseInfoServiceImpl extends ServiceSupport implements
		BaseInfoService {

	@Resource
	private MailSend mailSend;

	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.proxy.BaseInfoService#insertBaseInfo(com.group.renshi.bean.proxy.BaseInfoBean)
	 */
	@Override
	public BaseInfoBean insertBaseInfo(BaseInfoBean baseInfoBean,
			LicenseInfoBean licenseInfoBean) {
		int accountId = baseInfoBean.getAccountId();

		// 设置用户状态
		AccountInfoBean accountInfoBean = accountInfoDao.load(accountId);
		accountInfoBean
				.setAccountStatus(SystemConstantType.ACCOUNT_STATUS_FIRST);
		accountInfoDao.update(accountInfoBean);

		baseInfoDao.insert(baseInfoBean);

		licenseInfoDao.insert(licenseInfoBean);

		return baseInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.proxy.BaseInfoService#deleteBaseInfo(int)
	 */
	@Override
	public void deleteBaseInfo(int id) {
		baseInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.proxy.BaseInfoService#updateBaseInfo(com.group.renshi.bean.proxy.BaseInfoBean)
	 */
	@Override
	public void updateBaseInfo(BaseInfoBean baseInfoBean) {
		BaseInfoBean baseInfoBeanData = baseInfoDao.load(baseInfoBean
				.getAccountId());

		baseInfoDao.update(baseInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.proxy.BaseInfoService#findById(int)
	 */
	@Override
	public BaseInfoBean findById(int id) {
		return baseInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.proxy.BaseInfoService#listBaseInfo(com.group.renshi.bean.proxy.BaseInfoBean)
	 */
	@Override
	public List<BaseInfoBean> listBaseInfo(BaseInfoBean baseInfoBean) {
		List<BaseInfoBean> baseInfoList = baseInfoDao.listData(baseInfoBean);
		return baseInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.proxy.BaseInfoService#pageBaseInfo(com.group.renshi.bean.proxy.BaseInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<BaseInfoBean> pageBaseInfo(
			BaseInfoBean baseInfoBean,
			PageQueryResult<BaseInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(baseInfoDao, baseInfoBean,
				pageQueryResult);

		return pageQueryResult;
	}

	/**
	 * 代理商登录
	 * 
	 * @see com.group.renshi.service.proxy.BaseInfoService#login(javax.servlet.http.HttpServletRequest,
	 *      com.group.renshi.bean.system.AccountInfoBean)
	 */
	@Override
	public AccountInfoBean login(HttpServletRequest request,
			AccountInfoBean accountInfoBean) {
		// 判断账号是否注册
		AccountInfoBean accountInfoBeanCond = new AccountInfoBean();
		accountInfoBeanCond.setLoginAccount(accountInfoBean.getLoginAccount());

		List<AccountInfoBean> list = accountInfoDao
				.listData(accountInfoBeanCond);
		if (CollectionUtils.isEmpty(list)) {
			throw new ApplicationException("您输入的账号未注册");
		}

		// 账号或密码错误
		AccountInfoBean accountInfoBeanData = list.get(0);
		IEncrypt encrypt = EncryptFactory.getInstance(MD5Encrypt.class
				.getSimpleName());
		String password = encrypt.encodePassword(
				accountInfoBean.getLoginPassword(),
				SystemConstantType.PASS_SALT);

		if (!password.equals(accountInfoBeanData.getLoginPassword())) {
			throw new ApplicationException("您输入的账号或密码错误");
		}

		// 保存session
		// 保存session
		UserDetails userDetails = new UserDetails();
		userDetails.setAccountInfoBean(accountInfoBeanData);
		SessionControl.setAttribute(request, SystemConstantType.USER_DETAILS,
				userDetails);

		return accountInfoBeanData;
	}

	@Override
	public void insertAccountInfo(HttpServletRequest request,
			AccountInfoBean accountInfoBean) {
		// 校验登录账号和登录密码
		if (null == accountInfoBean.getLoginAccount()
				|| "".equals(accountInfoBean.getLoginAccount())) {
			throw new ApplicationException("请填写登录账号");
		}

		if (null == accountInfoBean.getLoginPassword()
				|| "".equals(accountInfoBean.getLoginPassword())) {
			throw new ApplicationException("请填写登录密码");
		}

		// 验证登录用户名是否重复
		AccountInfoBean accountInfoBeanCond = new AccountInfoBean();
		accountInfoBeanCond.setLoginAccount(accountInfoBean.getLoginAccount());

		List<AccountInfoBean> validList = accountInfoDao
				.listData(accountInfoBeanCond);
		if (!CollectionUtils.isEmpty(validList)) {
			throw new ApplicationException("用户名["
					+ accountInfoBean.getLoginAccount() + "]已经存在");
		}

		// 设置注册方式、账号类型、账号状态、激活状态
		accountInfoBean.setRegisterType(SystemConstantType.REGISTER_TYPE_MAIL);
		accountInfoBean.setAccountType(SystemConstantType.ACCOUNT_TYPE_AGENT);
		accountInfoBean
				.setAccountStatus(SystemConstantType.ACCOUNT_STATUS_ZERO);
		accountInfoBean.setActiveType(SystemConstantType.ACTIVE_TYPE_NO);

		// 等级和积分设置为0
		accountInfoBean.setAccountLevel(0);
		accountInfoBean.setAccountScore(0);

		// 密码用MD5加密
		IEncrypt iEncrypt = EncryptFactory.getInstance(MD5Encrypt.class
				.getSimpleName());
		accountInfoBean.setLoginPassword(iEncrypt.encodePassword(
				accountInfoBean.getLoginPassword(),
				SystemConstantType.PASS_SALT));

		accountInfoDao.insert(accountInfoBean);

		// 插入邮件数据校验表
		ValidMailBean validMailBean = new ValidMailBean();
		validMailBean.setAccountId(accountInfoBean.getAccountId());
		validMailBean.setValidType(SystemConstantType.VALID_TYPE_REGISTER);
		validMailBean.setValidBool(SystemConstantType.VALID_BOOL_UNUSE);

		// 有效期为48小时
		validMailBean.setExpireDate(DateUtil.addHours(new Date(), 48));

		// 生成校验key
		UUID uuid = UUID.randomUUID();
		validMailBean.setValidKey(uuid.toString());

		// 插入数据校验表数据
		validMailDao.insert(validMailBean);

		// 把key经过对称加密后，放于激活链接后面
		IEncrypt aesEncrypt = EncryptFactory.getInstance(AESEncrypt.class
				.getSimpleName());
		String validKey = aesEncrypt.encodePassword(uuid.toString(),
				SystemConstantType.PASS_SALT);

		// 生成激活链接 带参数keyAes
		StringBuffer validUrl = new StringBuffer();
		validUrl.append("http://").append(request.getServerName());
		if (request.getServerPort() != 80) {
			validUrl.append(":").append(request.getServerPort());
		}

		validUrl.append(request.getContextPath()).append("/proxy/validMail?")
				.append("key=").append(validKey);

		// 注册邮件发送模版
		String mailContent = MailTemplateCache.getInstance()
				.get(SystemConstantType.REGISTER_MAIL).toString();

		// 替换账号名
		mailContent = mailContent.replace("${loginAccount}",
				accountInfoBean.getLoginAccount());
		// 激活链接
		mailContent = mailContent.replace("${activeUrl}", validUrl);
		// 当前时间 2015年 06月03日 14:30
		mailContent = mailContent.replace("${dateTime}",
				DateUtil.formatDate(new Date(), "yyyy年MM月dd日 HH:mm"));
		// 失效时间 2015年 06月05日 14:30
		mailContent = mailContent.replace("${expireTime}", DateUtil.formatDate(
				validMailBean.getExpireDate(), "yyyy年MM月dd日 HH:mm"));
		// 发送日期 2015年06月03日
		mailContent = mailContent.replace("${date}",
				DateUtil.formatDate(new Date(), "yyyy年MM月dd日"));

		// 发送发送邮件
		mailSend.sendMail(accountInfoBean.getLoginAccount(),
				"【认仕网】欢迎您注册成为认仕网会员", mailContent);
	}
}