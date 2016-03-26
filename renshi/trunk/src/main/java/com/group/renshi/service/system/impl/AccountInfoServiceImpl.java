package com.group.renshi.service.system.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.share.FollowActiveBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.bean.system.ValidMailBean;
import com.group.renshi.cache.MailTemplateCache;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.system.AccountInfoService;
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
 * @version $Id: AccountInfoServiceImpl.java,v 0.1 2015-05-22 下午03:36:39 Exp $
 */
@Service("accountInfoService")
@Transactional
public class AccountInfoServiceImpl extends ServiceSupport implements
		AccountInfoService {

	@Resource
	private MailSend mailSend;

	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#insertAccountInfo(com.group.renshi.bean.system.AccountInfoBean)
	 */
	@Override
	public AccountInfoBean insertAccountInfo(HttpServletRequest request,
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
		accountInfoBean.setAccountType(SystemConstantType.ACCOUNT_TYPE_DOCTOR);
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
		validUrl.append(request.getContextPath()).append("/system/validMail?")
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
				"【认仕医生】欢迎您注册成为认仕医生会员", mailContent);

		return accountInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#deleteAccountInfo(int)
	 */
	@Override
	public void deleteAccountInfo(int id) {
		accountInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#updateAccountInfo(com.group.renshi.bean.system.AccountInfoBean)
	 */
	@Override
	public void updateAccountInfo(AccountInfoBean accountInfoBean) {
		AccountInfoBean accountInfoBeanData = accountInfoDao
				.load(accountInfoBean.getAccountId());

		accountInfoDao.update(accountInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#findById(int)
	 */
	@Override
	public AccountInfoBean findById(int id) {
		return accountInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#listAccountInfo(com.group.renshi.bean.system.AccountInfoBean)
	 */
	@Override
	public List<AccountInfoBean> listAccountInfo(AccountInfoBean accountInfoBean) {
		List<AccountInfoBean> accountInfoList = accountInfoDao
				.listData(accountInfoBean);
		return accountInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#pageAccountInfo(com.group.renshi.bean.system.AccountInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<AccountInfoBean> pageAccountInfo(
			AccountInfoBean accountInfoBean,
			PageQueryResult<AccountInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(accountInfoDao, accountInfoBean,
				pageQueryResult);

		return pageQueryResult;
	}

	/**
	 * 根据用户名校验用户名是否重复
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#validateAccountName(java.lang.String)
	 */
	@Override
	public boolean validateAccountName(String loginAccount) {
		AccountInfoBean accountInfoBean = new AccountInfoBean();
		accountInfoBean.setLoginAccount(loginAccount);

		List<AccountInfoBean> list = accountInfoDao.listData(accountInfoBean);

		// 如果为空,则返回true
		if (CollectionUtils.isEmpty(list)) {
			return true;
		}

		return false;
	}

	/**
	 * 登录
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#login(com.group.renshi.bean.system.AccountInfoBean)
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
		UserDetails userDetails = new UserDetails();
		userDetails.setAccountInfoBean(accountInfoBeanData);

		// 个人信息
		UserInfoBean userInfoBean = userInfoDao.load(accountInfoBeanData
				.getAccountId());
		if (null != userInfoBean) {
			userDetails.setUserInfoBean(userInfoBean);
		}

		// 认证信息
		AuthenticInfoBean authenticInfoBean = authenticInfoDao
				.load(accountInfoBeanData.getAccountId());
		if (null != authenticInfoBean) {
			userDetails.setAuthenticInfoBean(authenticInfoBean);
		}

		SessionControl.setAttribute(request, SystemConstantType.USER_DETAILS,
				userDetails);

		return accountInfoBeanData;
	}

	/**
	 * 确认账号
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#confirmAccount(java.lang.String)
	 */
	@Override
	public AccountInfoBean confirmAccount(String accountName) {
		AccountInfoBean accountInfoBean = new AccountInfoBean();
		accountInfoBean.setLoginAccount(accountName);

		List<AccountInfoBean> list = accountInfoDao.listData(accountInfoBean);
		if (CollectionUtils.isEmpty(list)) {
			throw new ApplicationException("邮箱或手机号不存在");
		}

		return list.get(0);
	}

	/**
	 * 忘记密码邮件发送
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#sendValidateMail(javax.servlet.http.HttpServletRequest,
	 *      int)
	 */
	@Override
	public void sendValidateMail(HttpServletRequest request, int accountId) {
		AccountInfoBean accountInfoBean = accountInfoDao.load(accountId);

		// 忘记密码插入邮件
		// 插入邮件数据校验表
		ValidMailBean validMailBean = new ValidMailBean();
		validMailBean.setAccountId(accountInfoBean.getAccountId());
		validMailBean.setValidType(SystemConstantType.VALID_TYPE_FORGETPASS);
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

		validUrl.append(request.getContextPath()).append("/system/forgetMail?")
				.append("key=").append(validKey);

		// 忘记密码邮件模版内容
		String mailContent = MailTemplateCache.getInstance()
				.get(SystemConstantType.FORGET_MAIL).toString();

		// 激活链接
		// 对账号地址加密
		String loginAccount = accountInfoBean.getLoginAccount();
		String first = loginAccount.substring(0, loginAccount.indexOf("@"));
		StringBuffer account = new StringBuffer();
		account.append(first.substring(0, 2)).append("...")
				.append(first.substring(first.length() - 2))
				.append(loginAccount.substring(loginAccount.indexOf("@")));
		mailContent = mailContent.replace("${loginAccount}", account);
		// 激活链接
		mailContent = mailContent.replace("${activeUrl}", validUrl);
		// 发送日期 2015年06月03日
		mailContent = mailContent.replace("${date}",
				DateUtil.formatDate(new Date(), "yyyy年MM月dd日"));

		// 发送发送邮件
		mailSend.sendMail(accountInfoBean.getLoginAccount(), "【认仕网】请重置您的登录密码",
				mailContent);
	}

	/**
	 * 重置密码
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#resetPwd(com.group.renshi.bean.system.AccountInfoBean)
	 */
	@Override
	public AccountInfoBean resetPwd(HttpServletRequest request,
			AccountInfoBean accountInfoBean, String keyAes) {
		// 判断KEY是否使用，如果已使用，则提示错误

		// 解密字符串
		IEncrypt aesEncrypt = EncryptFactory.getInstance(AESEncrypt.class
				.getSimpleName());
		String key = aesEncrypt.decodePassword(keyAes,
				SystemConstantType.PASS_SALT);

		// 根据key查找 ValidMailBean
		ValidMailBean validMailBeanCond = new ValidMailBean();
		validMailBeanCond.setValidKey(key);
		List<ValidMailBean> validList = validMailDao
				.listData(validMailBeanCond);

		// 查找到相应的校验信息
		ValidMailBean validMailBean = validList.get(0);

		if (validMailBean.getValidBool() == SystemConstantType.VALID_BOOL_USED) {
			throw new ApplicationException("链接已经重置过密码，不能重复使用");
		} else {
			// 设置为已使用
			validMailBean.setValidBool(SystemConstantType.VALID_BOOL_USED);
			validMailDao.update(validMailBean);
		}

		AccountInfoBean accountInfoBeanData = accountInfoDao
				.load(accountInfoBean.getAccountId());

		// 密码用MD5加密
		IEncrypt iEncrypt = EncryptFactory.getInstance(MD5Encrypt.class
				.getSimpleName());
		accountInfoBeanData.setLoginPassword(iEncrypt.encodePassword(
				accountInfoBean.getLoginPassword(),
				SystemConstantType.PASS_SALT));

		accountInfoDao.update(accountInfoBeanData);

		// 更新SESSION TODO
		UserDetails userDetails = SessionControl.getCurUserDetail(request);
		userDetails.setAccountInfoBean(accountInfoBeanData);
		SessionControl.setAttribute(request, SystemConstantType.USER_DETAILS,
				userDetails);

		return accountInfoBeanData;
	}

	/**
	 * 管理员审批
	 * 
	 * @see com.group.renshi.service.system.AccountInfoService#approve(int)
	 */
	@Override
	public AccountInfoBean approve(HttpServletRequest request, int accountId) {
		// 账号状态修改为第三步
		AccountInfoBean accountInfoBean = accountInfoDao.load(accountId);

		accountInfoBean
				.setAccountStatus(SystemConstantType.ACCOUNT_STATUS_THIRD);
		accountInfoDao.update(accountInfoBean);

		// 更新session
		UserDetails userDetails = SessionControl.getCurUserDetail(request);
		userDetails.setAccountInfoBean(accountInfoBean);

		SessionControl.setAttribute(request, SystemConstantType.USER_DETAILS,
				userDetails);

		// 插入个人空间记录
		PersonInfoBean personInfoBean = new PersonInfoBean();
		personInfoBean.setAccountId(accountId);
		personInfoBean.setFansNum(0);
		personInfoBean.setFollowNum(0);
		personInfoBean.setBrowerNum(0);
		personInfoBean.setVideoNum(0);
		personInfoBean.setArticleNum(0);
		personInfoBean.setCaseNum(0);
		personInfoBean.setCourseNum(0);
		personInfoBean.setPersonStatus(SystemConstantType.PERSON_STATUS_OPEN);
		personInfoBean.setPersonLevel(0);
		personInfoBean.setPersonActive(0);
		personInfoBean.setPersonSpecial(0);
		personInfoBean.setQaNum(0);
		personInfoBean.setCollectionNum(0);

		personInfoDao.insert(personInfoBean);

		// 插入我关注的人插入一条数据
		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setAccountId(accountId);
		followActiveBean.setFollowAccount(accountId);
		followActiveBean.setFollowName(userDetails.getUserInfoBean()
				.getRealName());

		followActiveBean.setFollowType(SystemConstantType.FOLLOW_TYPE_ONE);

		followActiveDao.insert(followActiveBean);

		return accountInfoBean;
	}

	@Override
	public AccountInfoBean approve(int accountId) {
		// 账号状态修改为第三步
		AccountInfoBean accountInfoBean = accountInfoDao.load(accountId);
		UserInfoBean userInfoBean = userInfoDao.load(accountId);

		accountInfoBean
				.setAccountStatus(SystemConstantType.ACCOUNT_STATUS_THIRD);
		accountInfoDao.update(accountInfoBean);

		// 插入个人空间记录
		PersonInfoBean personInfoBean = new PersonInfoBean();
		personInfoBean.setAccountId(accountId);
		personInfoBean.setFansNum(0);
		personInfoBean.setFollowNum(0);
		personInfoBean.setBrowerNum(0);
		personInfoBean.setVideoNum(0);
		personInfoBean.setArticleNum(0);
		personInfoBean.setCaseNum(0);
		personInfoBean.setCourseNum(0);
		personInfoBean.setPersonStatus(SystemConstantType.PERSON_STATUS_OPEN);
		personInfoBean.setPersonLevel(0);
		personInfoBean.setPersonActive(0);
		personInfoBean.setPersonSpecial(0);
		personInfoBean.setQaNum(0);
		personInfoBean.setCollectionNum(0);

		personInfoDao.insert(personInfoBean);

		// 插入我关注的人插入一条数据
		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setAccountId(accountId);
		followActiveBean.setFollowAccount(accountId);
		followActiveBean.setFollowName(userInfoBean.getRealName());// FIXME
																	// 确认这个字段有没有被使用

		followActiveBean.setFollowType(SystemConstantType.FOLLOW_TYPE_ONE);

		followActiveDao.insert(followActiveBean);

		return accountInfoBean;
	}

	/**
	 * @see com.group.renshi.service.system.AccountInfoService#changePassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void changePassword(int accountId, String oldPassword,
			String password) {
		// TODO Auto-generated method stub
		// 密码用MD5加密
		IEncrypt iEncrypt = EncryptFactory.getInstance(MD5Encrypt.class
				.getSimpleName());
		oldPassword = iEncrypt.encodePassword(oldPassword,
				SystemConstantType.PASS_SALT);

		AccountInfoBean accountInfoBean = accountInfoDao.load(accountId);
		if (!accountInfoBean.getLoginPassword().equals(oldPassword)) {
			throw new ApplicationException("旧密码填写错误");
		}

		password = iEncrypt.encodePassword(password,
				SystemConstantType.PASS_SALT);
		accountInfoBean.setLoginPassword(password);

		accountInfoDao.update(accountInfoBean);
	}

	/**
	 * @see com.group.renshi.service.system.AccountInfoService#sendRegisterMail(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void sendRegisterMail(HttpServletRequest request) {
		// TODO Auto-generated method stub
		AccountInfoBean accountInfoBean = accountInfoDao.load(SessionControl
				.getOpId(request));

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
		validUrl.append(request.getContextPath()).append("/system/validMail?")
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
				"【认仕医生】欢迎您注册成为认仕医生会员", mailContent);
	}

	/**
	 * @see com.group.renshi.service.system.AccountInfoService#sendResetMailMail(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void sendResetMailMail(String newMail, HttpServletRequest request) {
		AccountInfoBean accountInfoBean = accountInfoDao.load(SessionControl
				.getOpId(request));

		// 插入邮件数据校验表
		ValidMailBean validMailBean = new ValidMailBean();
		validMailBean.setAccountId(accountInfoBean.getAccountId());
		validMailBean.setValidType(SystemConstantType.VALID_TYPE_RESTMAIL);
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
		validUrl.append(request.getContextPath()).append("/system/resetMail?")
				.append("key=").append(validKey).append("&newMail=")
				.append(newMail);

		// 注册邮件发送模版
		String mailContent = MailTemplateCache.getInstance()
				.get(SystemConstantType.RESET_MAIL).toString();

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

		// 替换新邮箱
		mailContent = mailContent.replace("${newloginAccount}", newMail);
		// 发送发送邮件
		mailSend.sendMail(newMail, "【认仕医生】绑定邮箱修改", mailContent);

	}
}