package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	share_msg_content
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MsgContentBean.java,v 0.1 2015-07-27 ����09:31:12 Exp $
 */
public class MsgContentBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * ��Ϣ���
     */
    private int contentId;
   	
   	/**
     * ˽�ű��
     */
    private int msgId;
   	
   	/**
     * �˻����
     */
    private int accountId;
   	
   	/**
     * ���ݱ��
     */
    private java.lang.String msgContent;
   	
   	/**
     * ����ʱ��
     */
    private java.util.Date sendDate;
    
    /**
     * 构�?方法
     */
    public MsgContentBean() {
		contentId = -1;
		msgId = -1;
		accountId = -1;
		msgContent = null;
		sendDate = null;
	}

    
    public void setContentId(int contentId){
        this.contentId = contentId ;
    }

    public int getContentId(){
        return this.contentId ;
    }
    
    public void setMsgId(int msgId){
        this.msgId = msgId ;
    }

    public int getMsgId(){
        return this.msgId ;
    }
    
    public void setAccountId(int accountId){
        this.accountId = accountId ;
    }

    public int getAccountId(){
        return this.accountId ;
    }
    
    public void setMsgContent(java.lang.String msgContent){
        this.msgContent = msgContent ;
    }

    public java.lang.String getMsgContent(){
        return this.msgContent ;
    }
    
    public void setSendDate(java.util.Date sendDate){
        this.sendDate = sendDate ;
    }

    public java.util.Date getSendDate(){
        return this.sendDate ;
    }
}