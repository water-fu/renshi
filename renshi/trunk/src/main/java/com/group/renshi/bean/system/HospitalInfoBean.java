package com.group.renshi.bean.system;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	system_hospital_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: HospitalInfoBean.java,v 0.1 2015-07-14 ����02:29:28 Exp $
 */
public class HospitalInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * ҽԺ���
     */
    private int hospitalId;
   	
   	/**
     * ��������
     */
    private int areaId;
   	
   	/**
     * ҽԺ����
     */
    private java.lang.String hospitalName;
    
    /**
     * 构�?方法
     */
    public HospitalInfoBean() {
		hospitalId = -1;
		areaId = -1;
		hospitalName = null;
	}

    
    public void setHospitalId(int hospitalId){
        this.hospitalId = hospitalId ;
    }

    public int getHospitalId(){
        return this.hospitalId ;
    }
    
    public void setAreaId(int areaId){
        this.areaId = areaId ;
    }

    public int getAreaId(){
        return this.areaId ;
    }
    
    public void setHospitalName(java.lang.String hospitalName){
        this.hospitalName = hospitalName ;
    }

    public java.lang.String getHospitalName(){
        return this.hospitalName ;
    }
}