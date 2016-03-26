package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	doctor_patient_judge
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PatientJudgeBean.java,v 0.1 2015-06-17 下午11:08:21 Exp $
 */
public class PatientJudgeBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * PATIENT_ID
	 */
	private int patientId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 患者姓名
	 */
	private java.lang.String patientName;

	/**
	 * 患者性别
	 */
	private int patientSex;

	/**
	 * 患者年龄
	 */
	private int patientAge;

	/**
	 * 病情描述
	 */
	private java.lang.String patientDesc;

	/**
	 * 评价时间
	 */
	private java.util.Date judgeDate;

	/**
	 * 评价描述
	 */
	private java.lang.String judgeDesc;

	/**
	 * 构造方法
	 */
	public PatientJudgeBean() {
		patientId = -1;
		accountId = -1;
		patientName = null;
		patientSex = -1;
		patientAge = -1;
		patientDesc = null;
		judgeDate = null;
		judgeDesc = null;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setPatientName(java.lang.String patientName) {
		this.patientName = patientName;
	}

	public java.lang.String getPatientName() {
		return this.patientName;
	}

	public void setPatientSex(int patientSex) {
		this.patientSex = patientSex;
	}

	public int getPatientSex() {
		return this.patientSex;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public int getPatientAge() {
		return this.patientAge;
	}

	public void setPatientDesc(java.lang.String patientDesc) {
		this.patientDesc = patientDesc;
	}

	public java.lang.String getPatientDesc() {
		return this.patientDesc;
	}

	public void setJudgeDate(java.util.Date judgeDate) {
		this.judgeDate = judgeDate;
	}

	public java.util.Date getJudgeDate() {
		return this.judgeDate;
	}

	public void setJudgeDesc(java.lang.String judgeDesc) {
		this.judgeDesc = judgeDesc;
	}

	public java.lang.String getJudgeDesc() {
		return this.judgeDesc;
	}
}