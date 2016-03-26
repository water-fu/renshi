package com.group.renshi.bean.system;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	system_account_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AccountInfoBean.java,v 0.1 2015-05-22 下午10:22:19 Exp $
 */
public class AccountInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	private int accountId;

	/**
	 * 注册方式
	        1.手机
	        2.邮箱
	        3.其他
	 */
	private int registerType;

	/**
	 * 登录账号
	 */
	private java.lang.String loginAccount;

	/**
	 * 登录密码
	 */
	private java.lang.String loginPassword;

	/**
	 * 头像地址
	 */
	private java.lang.String headUrl;

	/**
	 * 账号类型
	        1.医生
	        2.代理商
	 */
	private int accountType;

	/**
	 * 账号状态
	        0.未认证
			1.第一步
			2.第二步
			3.第三步
	 */
	private int accountStatus;

	/**
	 * 激活状态
	        0.未激活
	        1.已激活
	 */
	private int activeType;

	/**
	 * 激活时间
	 */
	private java.util.Date activeTime;

	/**
	 * 账号等级
	 */
	private int accountLevel;

	/**
	 * 账号积分
	 */
	private int accountScore;

	/**
	 * 构造方法
	 */
	public AccountInfoBean() {
		super();

		this.accountId = -1;
		this.registerType = -1;
		this.loginAccount = null;
		this.loginPassword = null;
		this.headUrl = null;
		this.accountType = -1;
		this.accountStatus = -1;
		this.activeType = -1;
		this.activeTime = null;
		this.accountLevel = -1;
		this.accountScore = -1;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setRegisterType(int registerType) {
		this.registerType = registerType;
	}

	public int getRegisterType() {
		return this.registerType;
	}

	public void setLoginAccount(java.lang.String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public java.lang.String getLoginAccount() {
		return this.loginAccount;
	}

	public void setLoginPassword(java.lang.String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public java.lang.String getLoginPassword() {
		return this.loginPassword;
	}

	public void setHeadUrl(java.lang.String headUrl) {
		this.headUrl = headUrl;
	}

	public java.lang.String getHeadUrl() {
		return this.headUrl;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getAccountType() {
		return this.accountType;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getAccountStatus() {
		return this.accountStatus;
	}

	public void setActiveType(int activeType) {
		this.activeType = activeType;
	}

	public int getActiveType() {
		return this.activeType;
	}

	public void setActiveTime(java.util.Date activeTime) {
		this.activeTime = activeTime;
	}

	public java.util.Date getActiveTime() {
		return this.activeTime;
	}

	public void setAccountLevel(int accountLevel) {
		this.accountLevel = accountLevel;
	}

	public int getAccountLevel() {
		return this.accountLevel;
	}

	public void setAccountScore(int accountScore) {
		this.accountScore = accountScore;
	}

	public int getAccountScore() {
		return this.accountScore;
	}
}