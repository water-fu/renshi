package com.group.renshi.service.system.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.bean.system.ValidMailBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.system.ValidMailService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.entity.UserDetails;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.SessionControl;
import com.group.webFramework.uitl.encrypt.AESEncrypt;
import com.group.webFramework.uitl.encrypt.EncryptFactory;
import com.group.webFramework.uitl.encrypt.IEncrypt;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: ValidMailServiceImpl.java,v 0.1 2015-05-24 下午03:56:53 Exp $
 */
@Service("validMailService")
@Transactional
public class ValidMailServiceImpl extends ServiceSupport implements
		ValidMailService {

	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.system.ValidMailService#insertValidMail(com.group.renshi.bean.system.ValidMailBean)
	 */
	@Override
	public ValidMailBean insertValidMail(ValidMailBean validMailBean) {
		validMailDao.insert(validMailBean);
		return validMailBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.system.ValidMailService#deleteValidMail(int)
	 */
	@Override
	public void deleteValidMail(int id) {
		validMailDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.system.ValidMailService#updateValidMail(com.group.renshi.bean.system.ValidMailBean)
	 */
	@Override
	public void updateValidMail(ValidMailBean validMailBean) {
		ValidMailBean validMailBeanData = validMailDao.load(validMailBean
				.getValidId());

		validMailDao.update(validMailBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.system.ValidMailService#findById(int)
	 */
	@Override
	public ValidMailBean findById(int id) {
		return validMailDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.system.ValidMailService#listValidMail(com.group.renshi.bean.system.ValidMailBean)
	 */
	@Override
	public List<ValidMailBean> listValidMail(ValidMailBean validMailBean) {
		List<ValidMailBean> validMailList = validMailDao
				.listData(validMailBean);
		return validMailList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.system.ValidMailService#pageValidMail(com.group.renshi.bean.system.ValidMailBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<ValidMailBean> pageValidMail(
			ValidMailBean validMailBean,
			PageQueryResult<ValidMailBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(validMailDao, validMailBean,
				pageQueryResult);

		return pageQueryResult;
	}

	/**
	 * 邮件激活
	 * 
	 * @see com.group.renshi.service.system.ValidMailService#check(java.lang.String)
	 */
	@Override
	public AccountInfoBean check(String keyAes, HttpServletRequest request) {

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

		if (!CollectionUtils.isEmpty(validList)) {
			// 查找到相应的校验信息
			ValidMailBean validMailBean = validList.get(0);

			// 加载登陆账号信息
			AccountInfoBean accountInfoBean = accountInfoDao.load(validMailBean
					.getAccountId());

			// 用户不存在
			if (accountInfoBean == null) {
				throw new ApplicationException("注册的用户不存在，请重新注册");
			}

			// 检查是否已经校验,未使用
			if (validMailBean.getValidBool() == SystemConstantType.VALID_BOOL_UNUSE) {

				// 检查是否过期
				if (new Date().getTime() > validMailBean.getExpireDate()
						.getTime()) {
					// 已经过期
					throw new ApplicationException("该邮件激活链接已经过期，请重新发送激活邮件");
				}

				// 校验通过 激活成功

				// 校验标志设置为1
				validMailBean.setValidBool(SystemConstantType.VALID_BOOL_USED);
				// 更新原来的邮件校验记录
				validMailDao.update(validMailBean);

				// 激活状态设置为 1
				accountInfoBean
						.setActiveType(SystemConstantType.ACTIVE_TYPE_YES);
				// 设置激活时间为当前时间
				accountInfoBean.setActiveTime(new Date());

				accountInfoDao.update(accountInfoBean);

			} else {
				// 如果是激活的，则返回true
				if (accountInfoBean.getActiveType() != SystemConstantType.ACTIVE_TYPE_YES) {
					throw new ApplicationException("激活链接已使用，请重新发送激活邮件");
				}
			}

			// 设置登录session
			UserDetails userDetails = new UserDetails();
			userDetails.setAccountInfoBean(accountInfoBean);
			setLoginSession(request, userDetails);
			return accountInfoBean;

		} else {
			throw new ApplicationException("激活链接无效,请重新注册或重新发送激活邮件");
		}
	}

	/**
	 * 激活成功后，把账户信息放到session中
	 * 
	 * @param request
	 * @param accountInfoBean
	 */
	private void setLoginSession(HttpServletRequest request,
			UserDetails userDetails) {
		SessionControl.setAttribute(request, SystemConstantType.USER_DETAILS,
				userDetails);
	}

	/**
	 * 忘记密码
	 * 
	 * @see com.group.renshi.service.system.ValidMailService#forgetMail(java.lang.String)
	 */
	@Override
	public AccountInfoBean forgetMail(String keyAes) {
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

		if (!CollectionUtils.isEmpty(validList)) {
			// 查找到相应的校验信息
			ValidMailBean validMailBean = validList.get(0);

			// 加载登陆账号信息
			AccountInfoBean accountInfoBean = accountInfoDao.load(validMailBean
					.getAccountId());

			// 检查是否已经校验,未使用
			if (validMailBean.getValidBool() == SystemConstantType.VALID_BOOL_UNUSE) {

				// 检查是否过期
				if (new Date().getTime() > validMailBean.getExpireDate()
						.getTime()) {
					// 已经过期
					throw new ApplicationException("该确认激活链接已经过期，请重新发送确认邮件");
				}

			} else {
				// 如果是激活的，则返回true
				if (accountInfoBean.getActiveType() != SystemConstantType.ACTIVE_TYPE_YES) {
					throw new ApplicationException("确认链接已使用，请重新发送确认邮件");
				}
			}

			return accountInfoBean;
		} else {
			throw new ApplicationException("确认链接无效,请重新发送确认邮件");
		}
	}

	/**
	 * @see com.group.renshi.service.system.ValidMailService#resetMail(java.lang.String)
	 */
	@Override
	public AccountInfoBean resetMail(String keyAes, String newMail) {
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

		if (!CollectionUtils.isEmpty(validList)) {
			// 查找到相应的校验信息
			ValidMailBean validMailBean = validList.get(0);

			// 加载登陆账号信息
			AccountInfoBean accountInfoBean = accountInfoDao.load(validMailBean
					.getAccountId());

			// 检查是否已经校验,未使用
			if (validMailBean.getValidBool() == SystemConstantType.VALID_BOOL_UNUSE) {

				// 检查是否过期
				if (new Date().getTime() > validMailBean.getExpireDate()
						.getTime()) {
					// 已经过期
					throw new ApplicationException("该确认激活链接已经过期，请重新发送确认邮件");
				}

			} else {
				// 如果是激活的，则返回true
				if (accountInfoBean.getActiveType() != SystemConstantType.ACTIVE_TYPE_YES) {
					throw new ApplicationException("确认链接已使用，请重新发送确认邮件");
				}
			}
			accountInfoBean.setLoginAccount(newMail);
			int num = accountInfoDao.update(accountInfoBean);
			if (num <= 0) {
				throw new ApplicationException("邮箱重置失败！");
			}
			return accountInfoBean;
		} else {
			throw new ApplicationException("确认链接无效,请重新发送确认邮件");
		}
	}
}