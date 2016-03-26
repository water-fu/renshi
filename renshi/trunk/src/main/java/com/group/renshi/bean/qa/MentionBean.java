package com.group.renshi.bean.qa;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	qa_mention
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MentionBean.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
public class MentionBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 艾特编号
	 */
	private int id;

	/**
	 * 发艾特的用户编号
	 */
	private int accountId;

	/**
	 * 艾特信息
	 */
	private String msg;

	/**
	 * 这条艾特信息是否已读
	 */
	private String isRead;

	/**
	 * 艾特信息所在的评论的ID
	 */
	private long commonId;

//	/**
//	 * 艾特的创建时间
//	 */
//	private java.util.Date gmtCreate;

//	/**
//	 * 艾特的修改时间
//	 */
//	private java.util.Date gmtModify;

	/**
	 * 构造方法
	 */
	public MentionBean() {
		id = -1;
		accountId = -1;
		msg = null;
		isRead = null;
		commonId = -1;
//		gmtCreate = null;
//		gmtModify = null;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setAccountId(int userId) {
		this.accountId = userId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getIsRead() {
		return this.isRead;
	}

	public void setCommonId(long commonId) {
		this.commonId = commonId;
	}

	public long getCommonId() {
		return this.commonId;
	}

//	public void setGmtCreate(java.util.Date gmtCreate) {
//		this.gmtCreate = gmtCreate;
//	}

//	public java.util.Date getGmtCreate() {
//		return this.gmtCreate;
//	}

//	public void setGmtModify(java.util.Date gmtModify) {
//		this.gmtModify = gmtModify;
//	}

//	public java.util.Date getGmtModify() {
//		return this.gmtModify;
//	}
}