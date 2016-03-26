package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 鎬讳綋璇存槑
 *	share_question_info
 *
 * <p>鍏蜂綋璇存槑</p>
 *
 * @author Administrator
 * @version $Id: QuestionInfoBean.java,v 0.1 2015-07-09 下午10:26:59 Exp $
 */
public class QuestionInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * 案例编号
     */
    private int shareId;
   	
   	/**
     * 病人性别
     */
    private java.lang.String patientSex;
   	
   	/**
     * 病人年龄
     */
    private java.lang.String patientAge;
   	
   	/**
     * 现病史
     */
    private java.lang.String illnessDesc;
   	
   	/**
     * 检查结果
     */
    private java.lang.String checkResult;
    
    /**
     * 鏋勯?鏂规硶
     */
    public QuestionInfoBean() {
		shareId = -1;
		patientSex = null;
		patientAge = null;
		illnessDesc = null;
		checkResult = null;
	}

    
    public void setShareId(int shareId){
        this.shareId = shareId ;
    }

    public int getShareId(){
        return this.shareId ;
    }
    
    public void setPatientSex(java.lang.String patientSex){
        this.patientSex = patientSex ;
    }

    public java.lang.String getPatientSex(){
        return this.patientSex ;
    }
    
    public void setPatientAge(java.lang.String patientAge){
        this.patientAge = patientAge ;
    }

    public java.lang.String getPatientAge(){
        return this.patientAge ;
    }
    
    public void setIllnessDesc(java.lang.String illnessDesc){
        this.illnessDesc = illnessDesc ;
    }

    public java.lang.String getIllnessDesc(){
        return this.illnessDesc ;
    }
    
    public void setCheckResult(java.lang.String checkResult){
        this.checkResult = checkResult ;
    }

    public java.lang.String getCheckResult(){
        return this.checkResult ;
    }
}