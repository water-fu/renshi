package com.group.renshi.bean.admin;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	agent_doctor_relation
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AgentDoctorRelationBean.java,v 0.1 2015-07-27 下午09:28:49 Exp $
 */
public class AgentDoctorRelationBean extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 记录编号
     */
    private int id;

    /**
     * 代理商用户编号(对应admin_user表中userid)
     */
    private int agentUserId;

    /**
     * 医生用户编号(对应system_account_info表中医生的账户编号)
     */
    private int doctorUserId;

    /**
     * 代理关系状态
     */
    private int proxyStatus;

    /**
     * 构造方法
     */
    public AgentDoctorRelationBean() {
        id = -1;
        agentUserId = -1;
        doctorUserId = -1;
        proxyStatus = -1;
    }


    public void setId(int id){
        this.id = id ;
    }

    public int getId(){
        return this.id ;
    }

    public void setAgentUserId(int agentUserId){
        this.agentUserId = agentUserId ;
    }

    public int getAgentUserId(){
        return this.agentUserId ;
    }

    public void setDoctorUserId(int doctorUserId){
        this.doctorUserId = doctorUserId ;
    }

    public int getDoctorUserId(){
        return this.doctorUserId ;
    }

    public void setProxyStatus(int proxyStatus){
        this.proxyStatus = proxyStatus ;
    }

    public int getProxyStatus(){
        return this.proxyStatus ;
    }
}