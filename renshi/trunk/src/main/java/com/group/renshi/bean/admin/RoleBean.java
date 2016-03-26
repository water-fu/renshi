package com.group.renshi.bean.admin;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	admin_role
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: RoleBean.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
public class RoleBean extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 角色编号
     */
    private int roleId;

    /**
     * 角色名称
     */
    private java.lang.String roleName;

    /**
     * 角色描述
     */
    private java.lang.String roleDesc;

    /**
     * 构造方法
     */
    public RoleBean() {
        roleId = -1;
        roleName = null;
        roleDesc = null;
    }


    public void setRoleId(int roleId){
        this.roleId = roleId ;
    }

    public int getRoleId(){
        return this.roleId ;
    }

    public void setRoleName(java.lang.String roleName){
        this.roleName = roleName ;
    }

    public java.lang.String getRoleName(){
        return this.roleName ;
    }

    public void setRoleDesc(java.lang.String roleDesc){
        this.roleDesc = roleDesc ;
    }

    public java.lang.String getRoleDesc(){
        return this.roleDesc ;
    }
}