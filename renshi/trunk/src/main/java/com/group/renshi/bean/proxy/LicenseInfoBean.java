package com.group.renshi.bean.proxy;

import com.group.webFramework.common.BaseEntity;

/**
 * 鎬讳綋璇存槑
 *	proxy_license_info
 *
 * <p>鍏蜂綋璇存槑</p>
 *
 * @author Administrator
 * @version $Id: LicenseInfoBean.java,v 0.1 2015-06-27 下午11:16:27 Exp $
 */
public class LicenseInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * 账户编号
     */
    private int accountId;
   	
   	/**
     * 身份证编码
     */
    private java.lang.String idCard;
   	
   	/**
     * 正面地址
     */
    private java.lang.String frontUrl;
   	
   	/**
     * 反面地址
     */
    private java.lang.String backUrl;
   	
   	/**
     * 营业执照
     */
    private java.lang.String licenseNo;
   	
   	/**
     * 照片地址
     */
    private java.lang.String licenseUrl;
    
    /**
     * 鏋勯?鏂规硶
     */
    public LicenseInfoBean() {
		accountId = -1;
		idCard = null;
		frontUrl = null;
		backUrl = null;
		licenseNo = null;
		licenseUrl = null;
	}

    
    public void setAccountId(int accountId){
        this.accountId = accountId ;
    }

    public int getAccountId(){
        return this.accountId ;
    }
    
    public void setIdCard(java.lang.String idCard){
        this.idCard = idCard ;
    }

    public java.lang.String getIdCard(){
        return this.idCard ;
    }
    
    public void setFrontUrl(java.lang.String frontUrl){
        this.frontUrl = frontUrl ;
    }

    public java.lang.String getFrontUrl(){
        return this.frontUrl ;
    }
    
    public void setBackUrl(java.lang.String backUrl){
        this.backUrl = backUrl ;
    }

    public java.lang.String getBackUrl(){
        return this.backUrl ;
    }
    
    public void setLicenseNo(java.lang.String licenseNo){
        this.licenseNo = licenseNo ;
    }

    public java.lang.String getLicenseNo(){
        return this.licenseNo ;
    }
    
    public void setLicenseUrl(java.lang.String licenseUrl){
        this.licenseUrl = licenseUrl ;
    }

    public java.lang.String getLicenseUrl(){
        return this.licenseUrl ;
    }
}