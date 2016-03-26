package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 share_msg_info
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: MsgInfoBean.java,v 0.1 2015-07-27 ����09:31:12 Exp $
 */
public class MsgInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * ˽�ű��
	 */
	private int msgId;

	/**
	 * �˻����
	 */
	private int accountId;

	/**
	 * ��������
	 */
	private int accountedId;

	/**
	 * ���·���ʱ��
	 */
	private java.util.Date sendDate;

	/**
	 * δ������
	 */
	private int msgCount;

	/**
	 * ��δ������
	 */
	private int msgdedCount;

	private String msgContent;

	private String headUrl;

	private String realName;

	/**
	 * 构�?方法
	 */
	public MsgInfoBean() {
		msgId = -1;
		accountId = -1;
		accountedId = -1;
		sendDate = null;
		msgCount = -1;
		msgdedCount = -1;
		msgContent = null;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public int getMsgId() {
		return this.msgId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountedId(int accountedId) {
		this.accountedId = accountedId;
	}

	public int getAccountedId() {
		return this.accountedId;
	}

	public void setSendDate(java.util.Date sendDate) {
		this.sendDate = sendDate;
	}

	public java.util.Date getSendDate() {
		return this.sendDate;
	}

	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}

	public int getMsgCount() {
		return this.msgCount;
	}

	public void setMsgdedCount(int msgdedCount) {
		this.msgdedCount = msgdedCount;
	}

	public int getMsgdedCount() {
		return this.msgdedCount;
	}

	/**
	 * Getter method for property <tt>headUrl</tt>.
	 * 
	 * @return property value of headUrl
	 */
	public String getHeadUrl() {
		return headUrl;
	}

	/**
	 * Setter method for property <tt>headUrl</tt>.
	 * 
	 * @param headUrl
	 *            value to be assigned to property headUrl
	 */
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	/**
	 * Getter method for property <tt>realName</tt>.
	 * 
	 * @return property value of realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * Setter method for property <tt>realName</tt>.
	 * 
	 * @param realName
	 *            value to be assigned to property realName
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * Getter method for property <tt>msgContent</tt>.
	 * 
	 * @return property value of msgContent
	 */
	public String getMsgContent() {
		return msgContent;
	}

	/**
	 * Setter method for property <tt>msgContent</tt>.
	 * 
	 * @param msgContent
	 *            value to be assigned to property msgContent
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
}