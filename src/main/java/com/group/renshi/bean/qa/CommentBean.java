package com.group.renshi.bean.qa;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	qa_comment
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: CommentBean.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
public class CommentBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 评论的编号
	 */
	private int id;

	/**
	 * 评论者的用户编号
	 */
	private int accountId;

	/**
	 * 评论的内容
	 */
	private String content;

//	/**
//	 * 评论的创建时间
//	 */
//	private java.util.Date createDate;

//	/**
//	 * 评论的修改时间
//	 */
//	private java.util.Date updateDate;

	/**
	 * 构造方法
	 */
	public CommentBean() {
		id = -1;
		accountId = -1;
		content = null;
//		createDate = null;
//		updateDate = null;
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

	public long getAccountId() {
		return this.accountId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

//	public void setGmtCreate(java.util.Date gmtCreate) {
//		this.createDate = createDate;
//	}

//	public java.util.Date getGmtCreate() {
//		return this.createDate;
//	}

//	public void setGmtModify(java.util.Date gmtModify) {
//		this.updateDate = updateDate;
//	}

//	public java.util.Date getGmtModify() {
//		return this.updateDate;
//	}
}