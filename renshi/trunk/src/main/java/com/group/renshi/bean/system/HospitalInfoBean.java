package com.group.renshi.bean.system;

import com.group.webFramework.common.BaseEntity;

/**
 * 鎬讳綋璇存槑
 *	system_hospital_info
 *
 * <p>鍏蜂綋璇存槑</p>
 *
 * @author Administrator
 * @version $Id: HospitalInfoBean.java,v 0.1 2015-07-14 下午02:29:28 Exp $
 */
public class HospitalInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * 医院编号
     */
    private int hospitalId;
   	
   	/**
     * 归属地市
     */
    private int areaId;
   	
   	/**
     * 医院名称
     */
    private java.lang.String hospitalName;
    
    /**
     * 鏋勯?鏂规硶
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