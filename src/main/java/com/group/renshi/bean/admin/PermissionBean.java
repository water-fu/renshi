package com.group.renshi.bean.admin;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	admin_permission
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PermissionBean.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
public class PermissionBean extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 权限编号
     */
    private int permId;

    /**
     * 权限名称
     */
    private java.lang.String permName;

    /**
     * 权限描述
     */
    private java.lang.String permDesc;

    /**
     * 构造方法
     */
    public PermissionBean() {
        permId = -1;
        permName = null;
        permDesc = null;
    }


    public void setPermId(int permId){
        this.permId = permId ;
    }

    public int getPermId(){
        return this.permId ;
    }

    public void setPermName(java.lang.String permName){
        this.permName = permName ;
    }

    public java.lang.String getPermName(){
        return this.permName ;
    }

    public void setPermDesc(java.lang.String permDesc){
        this.permDesc = permDesc ;
    }

    public java.lang.String getPermDesc(){
        return this.permDesc ;
    }
}