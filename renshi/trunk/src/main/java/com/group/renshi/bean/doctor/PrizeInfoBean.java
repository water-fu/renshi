package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 doctor_prize_info
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: PrizeInfoBean.java,v 0.1 2015-06-17 下午11:03:59 Exp $
 */
public class PrizeInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 奖项编号
	 */
	private int prizeId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 奖项名称
	 */
	private java.lang.String prizeName;

	/**
	 * 获奖时间
	 */
	private String prizeDate;

	/**
	 * 颁奖机构
	 */
	private java.lang.String awardDept;

	/**
	 * 构造方法
	 */
	public PrizeInfoBean() {
		prizeId = -1;
		accountId = -1;
		prizeName = null;
		prizeDate = null;
		awardDept = null;
	}

	public void setPrizeId(int prizeId) {
		this.prizeId = prizeId;
	}

	public int getPrizeId() {
		return this.prizeId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setPrizeName(java.lang.String prizeName) {
		this.prizeName = prizeName;
	}

	public java.lang.String getPrizeName() {
		return this.prizeName;
	}

	/**
	 * Getter method for property <tt>prizeDate</tt>.
	 * 
	 * @return property value of prizeDate
	 */
	public String getPrizeDate() {
		return prizeDate;
	}

	/**
	 * Setter method for property <tt>prizeDate</tt>.
	 * 
	 * @param prizeDate
	 *            value to be assigned to property prizeDate
	 */
	public void setPrizeDate(String prizeDate) {
		this.prizeDate = prizeDate;
	}

	public void setAwardDept(java.lang.String awardDept) {
		this.awardDept = awardDept;
	}

	public java.lang.String getAwardDept() {
		return this.awardDept;
	}
}