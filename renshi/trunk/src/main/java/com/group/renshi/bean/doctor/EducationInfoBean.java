package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 doctor_education_info
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: EducationInfoBean.java,v 0.1 2015-06-17 下午10:32:37 Exp $
 */
public class EducationInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 教育编号
	 */
	private int educationId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 学校名称
	 */
	private java.lang.String schoolName;

	/**
	 * 入学时间
	 */
	private String startDate;

	/**
	 * 毕业时间
	 */
	private String endDate;

	/**
	 * 就读城市
	 */
	private java.lang.String inCity;

	/**
	 * 就读专业
	 */
	private java.lang.String majorName;

	/**
	 * 学位名称
	 */
	private java.lang.String degreeName;

	/**
	 * 构造方法
	 */
	public EducationInfoBean() {
		educationId = -1;
		accountId = -1;
		schoolName = null;
		startDate = null;
		endDate = null;
		inCity = null;
		majorName = null;
		degreeName = null;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public int getEducationId() {
		return this.educationId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setSchoolName(java.lang.String schoolName) {
		this.schoolName = schoolName;
	}

	public java.lang.String getSchoolName() {
		return this.schoolName;
	}

	/**
	 * Getter method for property <tt>startDate</tt>.
	 * 
	 * @return property value of startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Setter method for property <tt>startDate</tt>.
	 * 
	 * @param startDate
	 *            value to be assigned to property startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Getter method for property <tt>endDate</tt>.
	 * 
	 * @return property value of endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Setter method for property <tt>endDate</tt>.
	 * 
	 * @param endDate
	 *            value to be assigned to property endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setInCity(java.lang.String inCity) {
		this.inCity = inCity;
	}

	public java.lang.String getInCity() {
		return this.inCity;
	}

	public void setMajorName(java.lang.String majorName) {
		this.majorName = majorName;
	}

	public java.lang.String getMajorName() {
		return this.majorName;
	}

	public void setDegreeName(java.lang.String degreeName) {
		this.degreeName = degreeName;
	}

	public java.lang.String getDegreeName() {
		return this.degreeName;
	}
}