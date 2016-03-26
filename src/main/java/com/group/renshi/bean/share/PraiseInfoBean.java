package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	share_praise_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PraiseInfoBean.java,v 0.1 2015-06-23 下午08:20:07 Exp $
 */
public class PraiseInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 点赞编号
	 */
	private int praiseId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 分享编号
	 */
	private int shareId;

	/**
	 * 是否阅读
	 */
	private int isRead;

	/**
	 * 构造方法
	 */
	public PraiseInfoBean() {
		praiseId = -1;
		accountId = -1;
		shareId = -1;
		isRead = -1;
	}

	public void setPraiseId(int praiseId) {
		this.praiseId = praiseId;
	}

	public int getPraiseId() {
		return this.praiseId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public int getShareId() {
		return this.shareId;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public int getIsRead() {
		return this.isRead;
	}
}