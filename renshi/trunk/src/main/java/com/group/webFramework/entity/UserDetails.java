package com.group.webFramework.entity;

import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;

/**
 * 总体说明
 * 	用户Session存储类
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: UserDetails.java,v 0.1 2015-5-19 上午9:36:44 Exp $
 */
public class UserDetails {

	/**
	 * 账号信息
	 */
	private AccountInfoBean accountInfoBean;

	/**
	 * 医生个人信息
	 */
	private UserInfoBean userInfoBean;

	/**
	 * 医生认证信息
	 */
	private AuthenticInfoBean authenticInfoBean;

	public AccountInfoBean getAccountInfoBean() {
		return accountInfoBean;
	}

	public void setAccountInfoBean(AccountInfoBean accountInfoBean) {
		this.accountInfoBean = accountInfoBean;
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}

	public AuthenticInfoBean getAuthenticInfoBean() {
		return authenticInfoBean;
	}

	public void setAuthenticInfoBean(AuthenticInfoBean authenticInfoBean) {
		this.authenticInfoBean = authenticInfoBean;
	}
}
