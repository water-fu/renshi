package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	share_tag_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: TagInfoBean.java,v 0.1 2015-07-03 下午08:32:29 Exp $
 */
public class TagInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * 标签编号
     */
    private int tagId;
   	
   	/**
     * 标签名称
     */
    private java.lang.String tagName;
   	
   	/**
     * 分享类型
     */
    private int shareType;
   	
   	/**
     * 分享数量
     */
    private int tagNum;
    
    /**
     * 构造方法
     */
    public TagInfoBean() {
		tagId = -1;
		tagName = null;
		shareType = -1;
		tagNum = -1;
	}

    
    public void setTagId(int tagId){
        this.tagId = tagId ;
    }

    public int getTagId(){
        return this.tagId ;
    }
    
    public void setTagName(java.lang.String tagName){
        this.tagName = tagName ;
    }

    public java.lang.String getTagName(){
        return this.tagName ;
    }
    
    public void setShareType(int shareType){
        this.shareType = shareType ;
    }

    public int getShareType(){
        return this.shareType ;
    }
    
    public void setTagNum(int tagNum){
        this.tagNum = tagNum ;
    }

    public int getTagNum(){
        return this.tagNum ;
    }
}