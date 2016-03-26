package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	share_discuss_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: DiscussInfoBean.java,v 0.1 2015-06-26 下午02:49:35 Exp $
 */
public class DiscussInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 评论编号
	 */
	private int discussId;

	/**
	 * 分享编号
	 */
	private int shareId;

	/**
	 * 上级评论
	 */
	private int parentId;

	/**
	 * 评论类型
	        1.微博
	        2.评论
	        3.赞
	 */
	private int discussType;

	/**
	 * 评论内容
	 */
	private java.lang.String discussContent;

	/**
	 * 评论层级
	 */
	private java.lang.String discussPath;

	/**
	 * 被评论用户编号
	 */
	private int accountId;

	/**
	 * 被评论用户姓名
	 */
	private java.lang.String accountName;

	// 查询的字段

	/**
	 * 评论人的名字
	 */
	private String realName;

	/**
	 * 评论人的头像地址
	 */
	private String headUrl;

	/**
	 * 分享标题
	 */
	private String shareTitle;

	/**
	 * 上级评论内容
	 */
	private String parentContent;

	/**
	 * 构造方法
	 */
	public DiscussInfoBean() {
		discussId = -1;
		shareId = -1;
		parentId = -1;
		discussType = -1;
		discussContent = null;
		discussPath = null;
		accountId = -1;
		accountName = null;
	}

	public void setDiscussId(int discussId) {
		this.discussId = discussId;
	}

	public int getDiscussId() {
		return this.discussId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public int getShareId() {
		return this.shareId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setDiscussType(int discussType) {
		this.discussType = discussType;
	}

	public int getDiscussType() {
		return this.discussType;
	}

	public void setDiscussContent(java.lang.String discussContent) {
		this.discussContent = discussContent;
	}

	public java.lang.String getDiscussContent() {
		return this.discussContent;
	}

	public void setDiscussPath(java.lang.String discussPath) {
		this.discussPath = discussPath;
	}

	public java.lang.String getDiscussPath() {
		return this.discussPath;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountName(java.lang.String accountName) {
		this.accountName = accountName;
	}

	public java.lang.String getAccountName() {
		return this.accountName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getParentContent() {
		return parentContent;
	}

	public void setParentContent(String parentContent) {
		this.parentContent = parentContent;
	}

	public String getDiscussTypeName() {
		switch (this.discussType) {
		case 1:
			return "微博";
		case 2:
			return "评论";
		case 3:
			return "赞";
		default:
			return "";
		}
	}
}