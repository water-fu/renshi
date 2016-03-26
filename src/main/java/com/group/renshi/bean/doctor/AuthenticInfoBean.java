package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	doctor_authentic_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AuthenticInfoBean.java,v 0.1 2015-06-24 下午01:37:21 Exp $
 */
public class AuthenticInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 工作职称
	 */
	private java.lang.String workProfess;

	/**
	 * 学术职称
	 */
	private java.lang.String academicProfess;

	/**
	 * 教育职称
	 */
	private java.lang.String educationProfess;

	/**
	 * 职称级别
	 */
	private int professLevel;

	/**
	 * 身份证编码
	 */
	private java.lang.String idCard;

	/**
	 * 正面地址
	 */
	private java.lang.String frontUrl;

	/**
	 * 反面地址
	 */
	private java.lang.String backUrl;

	/**
	 * 证书类型
	        1.医师学历证
	        2.医师资格证
	        3.医师学位证
	 */
	private int certificateType;

	/**
	 * 证书编号
	 */
	private java.lang.String certificateNo;

	/**
	 * 照片地址
	 */
	private java.lang.String certificateUrl;

	/**
	 * 构造方法
	 */
	public AuthenticInfoBean() {
		accountId = -1;
		workProfess = null;
		academicProfess = null;
		educationProfess = null;
		professLevel = -1;
		idCard = null;
		frontUrl = null;
		backUrl = null;
		certificateType = -1;
		certificateNo = null;
		certificateUrl = null;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setWorkProfess(java.lang.String workProfess) {
		this.workProfess = workProfess;
	}

	public java.lang.String getWorkProfess() {
		return this.workProfess;
	}

	public void setAcademicProfess(java.lang.String academicProfess) {
		this.academicProfess = academicProfess;
	}

	public java.lang.String getAcademicProfess() {
		return this.academicProfess;
	}

	public void setEducationProfess(java.lang.String educationProfess) {
		this.educationProfess = educationProfess;
	}

	public java.lang.String getEducationProfess() {
		return this.educationProfess;
	}

	public void setProfessLevel(int professLevel) {
		this.professLevel = professLevel;
	}

	public int getProfessLevel() {
		return this.professLevel;
	}

	public void setIdCard(java.lang.String idCard) {
		this.idCard = idCard;
	}

	public java.lang.String getIdCard() {
		return this.idCard;
	}

	public void setFrontUrl(java.lang.String frontUrl) {
		this.frontUrl = frontUrl;
	}

	public java.lang.String getFrontUrl() {
		return this.frontUrl;
	}

	public void setBackUrl(java.lang.String backUrl) {
		this.backUrl = backUrl;
	}

	public java.lang.String getBackUrl() {
		return this.backUrl;
	}

	public void setCertificateType(int certificateType) {
		this.certificateType = certificateType;
	}

	public int getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateNo(java.lang.String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public java.lang.String getCertificateNo() {
		return this.certificateNo;
	}

	public void setCertificateUrl(java.lang.String certificateUrl) {
		this.certificateUrl = certificateUrl;
	}

	public java.lang.String getCertificateUrl() {
		return this.certificateUrl;
	}
}