package com.group.renshi.bean.system;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	system_dept_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: DeptInfoBean.java,v 0.1 2015-07-14 ����03:03:24 Exp $
 */
public class DeptInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * ���ұ��
     */
    private int deptId;
   	
   	/**
     * ����ҽԺ
     */
    private int hospitalId;
   	
   	/**
     * ��������
     */
    private java.lang.String deptName;
   	
   	/**
     * ��������
            1.һ������
            2.��������
     */
    private int deptType;
    
    /**
     * 构�?方法
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