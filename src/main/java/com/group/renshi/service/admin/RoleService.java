package com.group.renshi.service.admin;

import java.util.List;

import com.group.renshi.bean.admin.RoleBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: RoleService.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
public interface RoleService
{
    /**
     * 插入对象
     *
     * @param roleBean  需要插入的实体对象
     * @return 返回插入后带自增长主键的对象
     */
    RoleBean insertRole(RoleBean roleBean);

    /**
     * 根据主键删除
     *
     * @param id  主键编号
     */
    void deleteRole(int id);

    /**
     * 更新对象
     *
     * @param roleBean  需要更新的实体对象
     */
    void updateRole(RoleBean roleBean);

    /**
     * 根据主键获取对象
     *
     * @param id  主键编号
     * @return  返回实体对象
     */
    RoleBean findById(int id);

    /**
     * 获取列表数据
     *
     * @param roleBean  实体对象
     * @return   返回列表对象
     */
    List<RoleBean> listRole(RoleBean roleBean);

    /**
     * 获取分页数据
     *
     * @param roleBean  实体对象
     * @param pageQueryResult   分页对象
     * @return  返回分页对象
     */
    PageQueryResult<RoleBean> pageRole(RoleBean roleBean, PageQueryResult<RoleBean> pageQueryResult);
}