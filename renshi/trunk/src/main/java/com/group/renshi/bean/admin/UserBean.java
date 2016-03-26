package com.group.renshi.bean.admin;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	admin_user
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: UserBean.java,v 0.1 2015-07-25 下午12:50:19 Exp $
 */
public class UserBean extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 后台用户编号
     */
    private int userId;

    /**
     * 父帐号用户编号,只有子帐号才有父帐号
     */
    private int parentId;

    /**
     * 登录用户名
     */
    private java.lang.String loginAccount;

    /**
     * 登录密码
     */
    private java.lang.String loginPassword;

    /**
     * 用户类型(1:认仕网管理员、2:代理商、3:代理商子账号)
     */
    private java.lang.String userType;

    /**
     * 邮箱
     */
    private java.lang.String email;

    /**
     * 用户手机号
     */
    private java.lang.String phone;

    /**
     * 状态(待认证、已认证、认证失败、解约中、已解约)
     */
    private int status;

    /**
     * 代理商邀请方
     */
    private int inviter;

    /**
     * 构造方法
     */
    public UserBean() {
        userId = -1;
        parentId = -1;
        loginAccount = null;
        loginPassword = null;
        userType = null;
        email = null;
        phone = null;
        status = -1;
        inviter = -1;
    }


    public void setUserId(int userId){
        this.userId = userId ;
    }

    public int getUserId(){
        return this.userId ;
    }

    public void setParentId(int parentId){
        this.parentId = parentId ;
    }

    public int getParentId(){
        return this.parentId ;
    }

    public void setLoginAccount(java.lang.String loginAccount){
        this.loginAccount = loginAccount ;
    }

    public java.lang.String getLoginAccount(){
        return this.loginAccount ;
    }

    public void setLoginPassword(java.lang.String loginPassword){
        this.loginPassword = loginPassword ;
    }

    public java.lang.String getLoginPassword(){
        return this.loginPassword ;
    }

    public void setUserType(java.lang.String userType){
        this.userType = userType ;
    }

    public java.lang.String getUserType(){
        return this.userType ;
    }

    public void setEmail(java.lang.String email){
        this.email = email ;
    }

    public java.lang.String getEmail(){
        return this.email ;
    }

    public void setPhone(java.lang.String phone){
        this.phone = phone ;
    }

    public java.lang.String getPhone(){
        return this.phone ;
    }

    public void setStatus(int status){
        this.status = status ;
    }

    public int getStatus(){
        return this.status ;
    }

    public void setInviter(int inviter){
        this.inviter = inviter ;
    }

    public int getInviter(){
        return this.inviter ;
    }
}