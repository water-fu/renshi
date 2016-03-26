package com.group.renshi.bean.qa;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	qa_reply
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ReplyBean.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
public class ReplyBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 回帖编号
	 */
	private int id;

	/**
	 * 回帖者用户编号
	 */
	private int accountId;

	/**
	 * 回帖内容
	 */
	private String content;

//	/**
//	 * 回帖创建时间
//	 */
//	private java.util.Date gmtCreate;

//	/**
//	 * 回帖修改时间
//	 */
//	private java.util.Date gmtModify;

	/**
	 * 1:主动回帖；2:发帖者邀请回答
	 */
	private String flag;

	/**
	 * 点赞次数
	 */
	private int voteNum;

	/**
	 * 构造方法
	 */
	public ReplyBean() {
		id = -1;
		accountId = -1;
		content = null;
//		gmtCreate = null;
//		gmtModify = null;
		flag = null;
		voteNum = -1;
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

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
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

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setVoteNum(int voteNum) {
		this.voteNum = voteNum;
	}

	public int getVoteNum() {
		return this.voteNum;
	}
}