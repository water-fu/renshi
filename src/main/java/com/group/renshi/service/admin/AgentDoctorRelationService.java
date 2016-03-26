package com.group.renshi.service.admin;

import java.util.List;

import com.group.renshi.bean.admin.AgentDoctorRelationBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AgentDoctorRelationService.java,v 0.1 2015-07-27 下午09:28:49 Exp $
 */
public interface AgentDoctorRelationService {
    /**
     * 插入对象
     *
     * @param AgentDoctorRelationBean  需要插入的实体对象
     * @return 返回插入后带自增长主键的对象
     */
    AgentDoctorRelationBean insertDoctorRelation(AgentDoctorRelationBean AgentDoctorRelationBean);

    /**
     * 根据主键删除
     *
     * @param id  主键编号
     */
    void deleteDoctorRelation(int id);

    /**
     * 更新对象
     *
     * @param AgentDoctorRelationBean  需要更新的实体对象
     */
    void updateDoctorRelation(AgentDoctorRelationBean AgentDoctorRelationBean);

    /**
     * 根据主键获取对象
     *
     * @param id  主键编号
     * @return  返回实体对象
     */
    AgentDoctorRelationBean findById(int id);

    /**
     * 获取列表数据
     *
     * @param AgentDoctorRelationBean  实体对象
     * @return   返回列表对象
     */
    List<AgentDoctorRelationBean> listDoctorRelation(AgentDoctorRelationBean AgentDoctorRelationBean);

    /**
     * 获取分页数据
     *
     * @param AgentDoctorRelationBean  实体对象
     * @param pageQueryResult   分页对象
     * @return  返回分页对象
     */
    PageQueryResult<AgentDoctorRelationBean> pageDoctorRelation(AgentDoctorRelationBean AgentDoctorRelationBean, PageQueryResult<AgentDoctorRelationBean> pageQueryResult);
}