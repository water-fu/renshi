package com.group.renshi.bean.proxy;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	proxy_license_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: LicenseInfoBean.java,v 0.1 2015-06-27 ����11:16:27 Exp $
 */
public class LicenseInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * �˻����
     */
    private int accountId;
   	
   	/**
     * ���֤����
     */
    private java.lang.String idCard;
   	
   	/**
     * �����ַ
     */
    private java.lang.String frontUrl;
   	
   	/**
     * �����ַ
     */
    private java.lang.String backUrl;
   	
   	/**
     * Ӫҵִ��
     */
    private java.lang.String licenseNo;
   	
   	/**
     * ��Ƭ��ַ
     */
    private java.lang.String licenseUrl;
    
    /**
     * 构�?方法
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