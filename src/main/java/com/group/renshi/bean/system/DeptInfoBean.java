package com.group.renshi.bean.system;

import com.group.webFramework.common.BaseEntity;

/**
 * 鎬讳綋璇存槑
 *	system_dept_info
 *
 * <p>鍏蜂綋璇存槑</p>
 *
 * @author Administrator
 * @version $Id: DeptInfoBean.java,v 0.1 2015-07-14 下午03:03:24 Exp $
 */
public class DeptInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * 科室编号
     */
    private int deptId;
   	
   	/**
     * 归属医院
     */
    private int hospitalId;
   	
   	/**
     * 科室名称
     */
    private java.lang.String deptName;
   	
   	/**
     * 科室类型
            1.一级科室
            2.二级科室
     */
    private int deptType;
    
    /**
     * 鏋勯?鏂规硶
     */
    public DeptInfoBean() {
		deptId = -1;
		hospitalId = -1;
		deptName = null;
		deptType = -1;
	}

    
    public void setDeptId(int deptId){
        this.deptId = deptId ;
    }

    public int getDeptId(){
        return this.deptId ;
    }
    
    public void setHospitalId(int hospitalId){
        this.hospitalId = hospitalId ;
    }

    public int getHospitalId(){
        return this.hospitalId ;
    }
    
    public void setDeptName(java.lang.String deptName){
        this.deptName = deptName ;
    }

    public java.lang.String getDeptName(){
        return this.deptName ;
    }
    
    public void setDeptType(int deptType){
        this.deptType = deptType ;
    }

    public int getDeptType(){
        return this.deptType ;
    }
}