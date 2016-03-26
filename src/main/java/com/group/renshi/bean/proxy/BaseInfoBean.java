package com.group.renshi.bean.proxy;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	proxy_base_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: BaseInfoBean.java,v 0.1 2015-06-27 下午11:11:39 Exp $
 */
public class BaseInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * 账号信息
     */
    private int accountId;
   	
   	/**
     * 代理商身份
     */
    private int proxyType;
   	
   	/**
     * 代理项目
     */
    private java.lang.String proxyTarget;
   	
   	/**
     * 公司名称
     */
    private java.lang.String companyName;
   	
   	/**
     * 公司类型
     */
    private int companyType;
   	
   	/**
     * 法人名称
     */
    private java.lang.String legalName;
   	
   	/**
     * 公司简介
     */
    private java.lang.String companyInfro;
   	
   	/**
     * 个人性别
     */
    private int personSex;
   	
   	/**
     * 出生年月
     */
    private java.lang.String personBirth;
   	
   	/**
     * 现居城市
     */
    private java.lang.String liveTown;
   	
   	/**
     * 个人简介
     */
    private java.lang.String personInfro;
   	
   	/**
     * 联系人姓名
     */
    private java.lang.String realName;
   	
   	/**
     * 手机号码
     */
    private java.lang.String phoneNo;
   	
   	/**
     * 固定电话
     */
    private java.lang.String telNo;
   	
   	/**
     * 邮箱
     */
    private java.lang.String emailNo;
   	
   	/**
     * QQ号码
     */
    private java.lang.String qqNo;
    
    /**
     * 构造方法
     */
    public BaseInfoBean() {
		accountId = -1;
		proxyType = -1;
		proxyTarget = null;
		companyName = null;
		companyType = -1;
		legalName = null;
		companyInfro = null;
		personSex = -1;
		personBirth = null;
		liveTown = null;
		personInfro = null;
		realName = null;
		phoneNo = null;
		telNo = null;
		emailNo = null;
		qqNo = null;
	}

    
    public void setAccountId(int accountId){
        this.accountId = accountId ;
    }

    public int getAccountId(){
        return this.accountId ;
    }
    
    public void setProxyType(int proxyType){
        this.proxyType = proxyType ;
    }

    public int getProxyType(){
        return this.proxyType ;
    }
    
    public void setProxyTarget(java.lang.String proxyTarget){
        this.proxyTarget = proxyTarget ;
    }

    public java.lang.String getProxyTarget(){
        return this.proxyTarget ;
    }
    
    public void setCompanyName(java.lang.String companyName){
        this.companyName = companyName ;
    }

    public java.lang.String getCompanyName(){
        return this.companyName ;
    }
    
    public void setCompanyType(int companyType){
        this.companyType = companyType ;
    }

    public int getCompanyType(){
        return this.companyType ;
    }
    
    public void setLegalName(java.lang.String legalName){
        this.legalName = legalName ;
    }

    public java.lang.String getLegalName(){
        return this.legalName ;
    }
    
    public void setCompanyInfro(java.lang.String companyInfro){
        this.companyInfro = companyInfro ;
    }

    public java.lang.String getCompanyInfro(){
        return this.companyInfro ;
    }
    
    public void setPersonSex(int personSex){
        this.personSex = personSex ;
    }

    public int getPersonSex(){
        return this.personSex ;
    }
    
    public void setPersonBirth(java.lang.String personBirth){
        this.personBirth = personBirth ;
    }

    public java.lang.String getPersonBirth(){
        return this.personBirth ;
    }
    
    public void setLiveTown(java.lang.String liveTown){
        this.liveTown = liveTown ;
    }

    public java.lang.String getLiveTown(){
        return this.liveTown ;
    }
    
    public void setPersonInfro(java.lang.String personInfro){
        this.personInfro = personInfro ;
    }

    public java.lang.String getPersonInfro(){
        return this.personInfro ;
    }
    
    public void setRealName(java.lang.String realName){
        this.realName = realName ;
    }

    public java.lang.String getRealName(){
        return this.realName ;
    }
    
    public void setPhoneNo(java.lang.String phoneNo){
        this.phoneNo = phoneNo ;
    }

    public java.lang.String getPhoneNo(){
        return this.phoneNo ;
    }
    
    public void setTelNo(java.lang.String telNo){
        this.telNo = telNo ;
    }

    public java.lang.String getTelNo(){
        return this.telNo ;
    }
    
    public void setEmailNo(java.lang.String emailNo){
        this.emailNo = emailNo ;
    }

    public java.lang.String getEmailNo(){
        return this.emailNo ;
    }
    
    public void setQqNo(java.lang.String qqNo){
        this.qqNo = qqNo ;
    }

    public java.lang.String getQqNo(){
        return this.qqNo ;
    }
}