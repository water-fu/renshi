package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 doctor_meeting_info
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: MeetingInfoBean.java,v 0.1 2015-06-17 下午11:18:04 Exp $
 */
public class MeetingInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 会议编号
	 */
	private int meetingId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 会议名称
	 */
	private java.lang.String meetingName;

	/**
	 * 参加类型 1.嘉宾 2.主持
	 */
	private String meetingType;

	/**
	 * 会议地点
	 */
	private java.lang.String meetingAddress;

	/**
	 * 会议时间
	 */
	private String meetingDate;

	/**
	 * 构造方法
	 */
	public MeetingInfoBean() {
		meetingId = -1;
		accountId = -1;
		meetingName = null;
		meetingType = null;
		meetingAddress = null;
		meetingDate = null;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public int getMeetingId() {
		return this.meetingId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setMeetingName(java.lang.String meetingName) {
		this.meetingName = meetingName;
	}

	public java.lang.String getMeetingName() {
		return this.meetingName;
	}

	/**
	 * Getter method for property <tt>meetingType</tt>.
	 * 
	 * @return property value of meetingType
	 */
	public String getMeetingType() {
		return meetingType;
	}

	/**
	 * Setter method for property <tt>meetingType</tt>.
	 * 
	 * @param meetingType
	 *            value to be assigned to property meetingType
	 */
	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public void setMeetingAddress(java.lang.String meetingAddress) {
		this.meetingAddress = meetingAddress;
	}

	public java.lang.String getMeetingAddress() {
		return this.meetingAddress;
	}

	/**
	 * Getter method for property <tt>meetingDate</tt>.
	 * 
	 * @return property value of meetingDate
	 */
	public String getMeetingDate() {
		return meetingDate;
	}

	/**
	 * Setter method for property <tt>meetingDate</tt>.
	 * 
	 * @param meetingDate
	 *            value to be assigned to property meetingDate
	 */
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}

}