package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	share_attach_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AttachInfoBean.java,v 0.1 2015-06-11 下午10:49:30 Exp $
 */
public class AttachInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 附件编号
	 */
	private int attachId;

	/**
	 * 分享编号
	 */
	private int shareId;

	/**
	 * 附件类型
	        1.图片
	        2.文件
	        3.视频
	 */
	private int attachType;

	/**
	 * 附件名称
	 */
	private java.lang.String attachName;

	/**
	 * 附件地址
	 */
	private java.lang.String attachUrl;

	/**
	 * 附件后缀
	 */
	private java.lang.String attachSuffix;

	/**
	 * 构造方法
	 */
	public AttachInfoBean() {
		attachId = -1;
		shareId = -1;
		attachType = -1;
		attachName = null;
		attachUrl = null;
		attachSuffix = null;
	}

	public void setAttachId(int attachId) {
		this.attachId = attachId;
	}

	public int getAttachId() {
		return this.attachId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public int getShareId() {
		return this.shareId;
	}

	public void setAttachType(int attachType) {
		this.attachType = attachType;
	}

	public int getAttachType() {
		return this.attachType;
	}

	public void setAttachName(java.lang.String attachName) {
		this.attachName = attachName;
	}

	public java.lang.String getAttachName() {
		return this.attachName;
	}

	public void setAttachUrl(java.lang.String attachUrl) {
		this.attachUrl = attachUrl;
	}

	public java.lang.String getAttachUrl() {
		return this.attachUrl;
	}

	public void setAttachSuffix(java.lang.String attachSuffix) {
		this.attachSuffix = attachSuffix;
	}

	public java.lang.String getAttachSuffix() {
		return this.attachSuffix;
	}
}