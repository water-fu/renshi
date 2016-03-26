package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 doctor_patent_info
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: PatentInfoBean.java,v 0.1 2015-06-17 下午11:14:34 Exp $
 */
public class PatentInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 专利编号
	 */
	private int patentId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 专利名称
	 */
	private java.lang.String patentName;

	/**
	 * 专利编码
	 */
	private java.lang.String patentCode;

	/**
	 * 注册国家
	 */
	private java.lang.String patentCountry;

	/**
	 * 获批时间
	 */
	private String patentDate;

	/**
	 * 构造方法
	 */
	public PatentInfoBean() {
		patentId = -1;
		accountId = -1;
		patentName = null;
		patentCode = null;
		patentCountry = null;
		patentDate = null;
	}

	public void setPatentId(int patentId) {
		this.patentId = patentId;
	}

	public int getPatentId() {
		return this.patentId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setPatentName(java.lang.String patentName) {
		this.patentName = patentName;
	}

	public java.lang.String getPatentName() {
		return this.patentName;
	}

	public void setPatentCode(java.lang.String patentCode) {
		this.patentCode = patentCode;
	}

	public java.lang.String getPatentCode() {
		return this.patentCode;
	}

	public void setPatentCountry(java.lang.String patentCountry) {
		this.patentCountry = patentCountry;
	}

	public java.lang.String getPatentCountry() {
		return this.patentCountry;
	}

	/**
	 * Getter method for property <tt>patentDate</tt>.
	 * 
	 * @return property value of patentDate
	 */
	public String getPatentDate() {
		return patentDate;
	}

	/**
	 * Setter method for property <tt>patentDate</tt>.
	 * 
	 * @param patentDate
	 *            value to be assigned to property patentDate
	 */
	public void setPatentDate(String patentDate) {
		this.patentDate = patentDate;
	}

}