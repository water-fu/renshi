package com.group.renshi.service.admin;

import java.util.List;

import com.group.renshi.bean.admin.PermissionBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PermissionService.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
public interface PermissionService
{
    /**
     * 插入对象
     *
     * @param permissionBean  需要插入的实体对象
     * @return 返回插入后带自增长主键的对象
     */
    PermissionBean insertPermission(PermissionBean permissionBean);

    /**
     * 根据主键删除
     *
     * @param id  主键编号
     */
    void deletePermission(int id);

    /**
     * 更新对象
     *
     * @param permissionBean  需要更新的实体对象
     */
    void updatePermission(PermissionBean permissionBean);

    /**
     * 根据主键获取对象
     *
     * @param id  主键编号
     * @return  返回实体对象
     */
    PermissionBean findById(int id);

    /**
     * 获取列表数据
     *
     * @param permissionBean  实体对象
     * @return   返回列表对象
     */
    List<PermissionBean> listPermission(PermissionBean permissionBean);

    /**
     * 获取分页数据
     *
     * @param permissionBean  实体对象
     * @param pageQueryResult   分页对象
     * @return  返回分页对象
     */
    PageQueryResult<PermissionBean> pagePermission(PermissionBean permissionBean, PageQueryResult<PermissionBean> pageQueryResult);
}