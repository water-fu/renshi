package com.group.renshi.bean.admin;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	admin_role_permission
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: RolePermissionBean.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
public class RolePermissionBean extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 编号
     */
    private int id;

    /**
     * 角色编号
     */
    private int roleId;

    /**
     * 权限编号
     */
    private int permId;

    /**
     * 构造方法
     */
    public RolePermissionBean() {
        id = -1;
        roleId = -1;
        permId = -1;
    }


    public void setId(int id){
        this.id = id ;
    }

    public int getId(){
        return this.id ;
    }

    public void setRoleId(int roleId){
        this.roleId = roleId ;
    }

    public int getRoleId(){
        return this.roleId ;
    }

    public void setPermId(int permId){
        this.permId = permId ;
    }

    public int getPermId(){
        return this.permId ;
    }
}