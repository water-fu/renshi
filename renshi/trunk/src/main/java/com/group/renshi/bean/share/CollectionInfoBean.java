package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	share_collection_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: CollectionInfoBean.java,v 0.1 2015-06-23 下午09:56:44 Exp $
 */
public class CollectionInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 收藏编号
	 */
	private int collectionId;

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
	public CollectionInfoBean() {
		collectionId = -1;
		accountId = -1;
		shareId = -1;
		isRead = -1;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public int getCollectionId() {
		return this.collectionId;
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