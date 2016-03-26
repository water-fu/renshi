package com.group.renshi.bean.qa;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	qa_post
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PostBean.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
public class PostBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * ID自增
	 */
	private int id;

	/**
	 * 帖子的用户编号
	 */
	private int accountId;

	/**
	 * 帖子标题
	 */
	private String title;

	/**
	 * 帖子内容
	 */
	private String content;

	/**
	 * 帖子所属的种类(具体的科室)
	 */
	private String category;

//	/**
//	 * 帖子创建时间
//	 */
//	private java.util.Date gmtCreate;

//	/**
//	 * 帖子修改时间
//	 */
//	private java.util.Date gmtModify;


	/**
	 * 帖子被浏览次数
	 */
	private int viewNum;

	/**
	 * 点赞次数
	 */
	private int voteNum;

	/**
	 * 帖子的回帖个数
	 */
	private int replyNum;

	/**
	 * 帖子被收藏次数
	 */
	private int favoriteNum;

	/**
	 * 帖子的标签
	 */
	private String tag;

	/**
	 * 帖子状态(1:正常开放;2:关闭;3:禁贴)
	 */
	private String status;

	/**
	 * 构造方法
	 */
	public PostBean() {
		id = -1;
		accountId = -1;
		title = null;
		content = null;
		category = null;
//		gmtCreate = null;
//		gmtModify = null;
		viewNum = -1;
		voteNum = -1;
		replyNum = -1;
		favoriteNum = -1;
		tag = null;
		status = null;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return this.category;
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

	public void setVoteNum(int voteNum) {
		this.voteNum = voteNum;
	}

	public int getVoteNum() {
		return this.voteNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public int getReplyNum() {
		return this.replyNum;
	}

	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}

	public int getViewNum() {
		return this.viewNum;
	}

	public void setFavoriteNum(int favoriteNum) {
		this.favoriteNum = favoriteNum;
	}

	public int getFavoriteNum() {
		return this.favoriteNum;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return this.tag;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
}