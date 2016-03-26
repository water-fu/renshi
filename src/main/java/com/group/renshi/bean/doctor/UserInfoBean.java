package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	doctor_user_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: UserInfoBean.java,v 0.1 2015-06-05 下午10:02:27 Exp $
 */
public class UserInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 真实姓名
	 */
	private java.lang.String realName;

	/**
	 * 性别
	        1.男
	        2.女
	 */
	private int accountSex;

	/**
	 * 出生日期
	        存储格式yyyy-MM-dd
	 */
	private java.lang.String birthDate;

	/**
	 * 故乡
	 */
	private java.lang.String homeTown;

	/**
	 * 现居住地
	        中国,浙江,杭州
	 */
	private java.lang.String liveTown;

	/**
	 * 所在医院
	 */
	private java.lang.String belongHospital;

	/**
	 * 所在科室
	 */
	private java.lang.String belongDept;

	/**
	 * 所属医学会
	 */
	private java.lang.String belongMedical;

	/**
	 * 擅长领域
	 */
	private java.lang.String specilArea;

	/**
	 * 个人简介
	 */
	private java.lang.String personInfro;

	//工作职称  在查询医友中需要用到该属性
	private java.lang.String workProfess;

	/**
	 * 查询用户时使用,用户头像
	 */
	private String headUrl;

	/**
	 * 构造方法
	 */
	public UserInfoBean() {
		accountId = -1;
		realName = null;
		accountSex = -1;
		birthDate = null;
		homeTown = null;
		liveTown = null;
		belongHospital = null;
		belongDept = null;
		belongMedical = null;
		specilArea = null;
		personInfro = null;

		workProfess = null;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}

	public java.lang.String getRealName() {
		return this.realName;
	}

	public void setAccountSex(int accountSex) {
		this.accountSex = accountSex;
	}

	public int getAccountSex() {
		return this.accountSex;
	}

	public void setBirthDate(java.lang.String birthDate) {
		this.birthDate = birthDate;
	}

	public java.lang.String getBirthDate() {
		return this.birthDate;
	}

	public void setHomeTown(java.lang.String homeTown) {
		this.homeTown = homeTown;
	}

	public java.lang.String getHomeTown() {
		return this.homeTown;
	}

	public void setLiveTown(java.lang.String liveTown) {
		this.liveTown = liveTown;
	}

	public java.lang.String getLiveTown() {
		return this.liveTown;
	}

	public void setBelongHospital(java.lang.String belongHospital) {
		this.belongHospital = belongHospital;
	}

	public java.lang.String getBelongHospital() {
		return this.belongHospital;
	}

	public void setBelongDept(java.lang.String belongDept) {
		this.belongDept = belongDept;
	}

	public java.lang.String getBelongDept() {
		return this.belongDept;
	}

	public void setBelongMedical(java.lang.String belongMedical) {
		this.belongMedical = belongMedical;
	}

	public java.lang.String getBelongMedical() {
		return this.belongMedical;
	}

	public void setSpecilArea(java.lang.String specilArea) {
		this.specilArea = specilArea;
	}

	public java.lang.String getSpecilArea() {
		return this.specilArea;
	}

	public void setPersonInfro(java.lang.String personInfro) {
		this.personInfro = personInfro;
	}

	public java.lang.String getPersonInfro() {
		return this.personInfro;
	}

	public String getWorkProfess() {
		return workProfess;
	}

	public void setWorkProfess(String workProfess) {
		this.workProfess = workProfess;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
}