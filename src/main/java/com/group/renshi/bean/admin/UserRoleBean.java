package com.group.renshi.bean.admin;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	admin_user_role
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: UserRoleBean.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
public class UserRoleBean extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 编号
     */
    private int id;

    /**
     * 用户编号
     */
    private int userId;

    /**
     * 角色编号
     */
    private int roleId;

    /**
     * 构造方法
     */
    public UserRoleBean() {
        id = -1;
        userId = -1;
        roleId = -1;
    }


    public void setId(int id){
        this.id = id ;
    }

    public int getId(){
        return this.id ;
    }

    public void setUserId(int userId){
        this.userId = userId ;
    }

    public int getUserId(){
        return this.userId ;
    }

    public void setRoleId(int roleId){
        this.roleId = roleId ;
    }

    public int getRoleId(){
        return this.roleId ;
    }
}