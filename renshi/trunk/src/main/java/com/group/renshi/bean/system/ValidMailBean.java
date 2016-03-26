package com.group.renshi.bean.system;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	system_valid_mail
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ValidMailBean.java,v 0.1 2015-05-27 下午02:01:41 Exp $
 */
public class ValidMailBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 校验编号
	 */
	private int validId;

	/**
	 * 用户编号
	 */
	private int accountId;

	/**
	 * 校验类型
	        1.注册邮件
	        2.忘记密码
	 */
	private int validType;

	/**
	 * 加密编码
	 */
	private java.lang.String validKey;

	/**
	 * 过期时间
	 */
	private java.util.Date expireDate;

	/**
	 * 是否校验
	        0.未使用
	        1.已使用
	 */
	private int validBool;

	/**
	 * 构造方法
	 */
	public ValidMailBean() {
		validId = -1;
		accountId = -1;
		validType = -1;
		validKey = null;
		expireDate = null;
		validBool = -1;
	}

	public void setValidId(int validId) {
		this.validId = validId;
	}

	public int getValidId() {
		return this.validId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setValidType(int validType) {
		this.validType = validType;
	}

	public int getValidType() {
		return this.validType;
	}

	public void setValidKey(java.lang.String validKey) {
		this.validKey = validKey;
	}

	public java.lang.String getValidKey() {
		return this.validKey;
	}

	public void setExpireDate(java.util.Date expireDate) {
		this.expireDate = expireDate;
	}

	public java.util.Date getExpireDate() {
		return this.expireDate;
	}

	public void setValidBool(int validBool) {
		this.validBool = validBool;
	}

	public int getValidBool() {
		return this.validBool;
	}
}