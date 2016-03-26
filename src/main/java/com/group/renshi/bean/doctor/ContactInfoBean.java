package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	doctor_contact_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ContactInfoBean.java,v 0.1 2015-06-05 下午10:02:27 Exp $
 */
public class ContactInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 手机号码
	 */
	private java.lang.String phoneNo;

	/**
	 * 邮箱地址
	 */
	private java.lang.String mailAddress;

	/**
	 * QQ号码
	 */
	private java.lang.String qqNo;

	/**
	 * 微信号
	 */
	private java.lang.String wechatNo;

	/**
	 * 微博地址
	 */
	private java.lang.String weiboAddress;

	/**
	 * 构造方法
	 */
	public ContactInfoBean() {
		accountId = -1;
		phoneNo = null;
		mailAddress = null;
		qqNo = null;
		wechatNo = null;
		weiboAddress = null;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setPhoneNo(java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public java.lang.String getPhoneNo() {
		return this.phoneNo;
	}

	public void setMailAddress(java.lang.String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public java.lang.String getMailAddress() {
		return this.mailAddress;
	}

	public void setQqNo(java.lang.String qqNo) {
		this.qqNo = qqNo;
	}

	public java.lang.String getQqNo() {
		return this.qqNo;
	}

	public void setWechatNo(java.lang.String wechatNo) {
		this.wechatNo = wechatNo;
	}

	public java.lang.String getWechatNo() {
		return this.wechatNo;
	}

	public void setWeiboAddress(java.lang.String weiboAddress) {
		this.weiboAddress = weiboAddress;
	}

	public java.lang.String getWeiboAddress() {
		return this.weiboAddress;
	}
}