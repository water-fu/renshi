package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 doctor_work_info
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: WorkInfoBean.java,v 0.1 2015-06-17 下午10:45:58 Exp $
 */
public class WorkInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 工作编号
	 */
	private int workId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 单位名称
	 */
	private java.lang.String companyName;

	/**
	 * 起始时间
	 */
	private String startDate;

	/**
	 * 截至时间
	 */
	private String endDate;

	/**
	 * 所在城市
	 */
	private java.lang.String inCity;

	/**
	 * 所在科室
	 */
	private java.lang.String belongDept;

	/**
	 * 工作职称
	 */
	private java.lang.String prefessName;

	/**
	 * 构造方法
	 */
	public WorkInfoBean() {
		workId = -1;
		accountId = -1;
		companyName = null;
		startDate = null;
		endDate = null;
		inCity = null;
		belongDept = null;
		prefessName = null;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getWorkId() {
		return this.workId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	public java.lang.String getCompanyName() {
		return this.companyName;
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

	public void setBelongDept(java.lang.String belongDept) {
		this.belongDept = belongDept;
	}

	public java.lang.String getBelongDept() {
		return this.belongDept;
	}

	public void setPrefessName(java.lang.String prefessName) {
		this.prefessName = prefessName;
	}

	public java.lang.String getPrefessName() {
		return this.prefessName;
	}
}