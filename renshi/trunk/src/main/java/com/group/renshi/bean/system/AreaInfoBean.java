package com.group.renshi.bean.system;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	system_area_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AreaInfoBean.java,v 0.1 2015-07-14 ����02:29:28 Exp $
 */
public class AreaInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * ҽԺ���
     */
    private int areaId;
   	
   	/**
     * ��������
     */
    private int parentId;
   	
   	/**
     * ��������ĸ
     */
    private java.lang.String firstChar;
   	
   	/**
     * ҽԺ����
     */
    private java.lang.String areaName;
    
    /**
     * 构�?方法
     */
    public AreaInfoBean() {
		areaId = -1;
		parentId = -1;
		firstChar = null;
		areaName = null;
	}

    
    public void setAreaId(int areaId){
        this.areaId = areaId ;
    }

    public int getAreaId(){
        return this.areaId ;
    }
    
    public void setParentId(int parentId){
        this.parentId = parentId ;
    }

    public int getParentId(){
        return this.parentId ;
    }
    
    public void setFirstChar(java.lang.String firstChar){
        this.firstChar = firstChar ;
    }

    public java.lang.String getFirstChar(){
        return this.firstChar ;
    }
    
    public void setAreaName(java.lang.String areaName){
        this.areaName = areaName ;
    }

    public java.lang.String getAreaName(){
        return this.areaName ;
    }
}