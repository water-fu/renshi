package com.group.webFramework.entity;

import com.group.renshi.bean.admin.UserBean;

/**
 * 总体说明
 * 	用户Session存储类
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 */
public class AdminDetails {

	/**
	 *  后台用户信息
	 */
	private UserBean userBean;


	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
}