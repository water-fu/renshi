package com.group.renshi.service.admin.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.admin.RolePermissionBean;
import com.group.renshi.service.admin.RolePermissionService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: RolePermissionServiceImpl.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
@Service("rolePermissionService")
@Transactional
public class RolePermissionServiceImpl extends ServiceSupport implements RolePermissionService
{
	/**
	 * 插入对象
	 * @see com.group.renshi.service.admin.RolePermissionService#insertRolePermission(com.group.renshi.bean.admin.RolePermissionBean)
	 */
	@Override
	public RolePermissionBean insertRolePermission(RolePermissionBean rolePermissionBean) {
		rolePermissionDao.insert(rolePermissionBean);
		return rolePermissionBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.admin.RolePermissionService#deleteRolePermission(int)
	 */
	@Override
	public void deleteRolePermission(int id) {
		rolePermissionDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.admin.RolePermissionService#updateRolePermission(com.group.renshi.bean.admin.RolePermissionBean)
	 */
	@Override
	public void updateRolePermission(RolePermissionBean rolePermissionBean) {
		RolePermissionBean rolePermissionBeanData = rolePermissionDao.load(rolePermissionBean.getId());

		rolePermissionDao.update(rolePermissionBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.admin.RolePermissionService#findById(int)
	 */
	@Override
	public RolePermissionBean findById(int id) {
		return rolePermissionDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.admin.RolePermissionService#listRolePermission(com.group.renshi.bean.admin.RolePermissionBean)
	 */
	@Override
	public List<RolePermissionBean> listRolePermission(RolePermissionBean rolePermissionBean) {
		List<RolePermissionBean> rolePermissionList = rolePermissionDao.listData(rolePermissionBean);
		return rolePermissionList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.admin.RolePermissionService#pageRolePermission(com.group.renshi.bean.admin.RolePermissionBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<RolePermissionBean> pageRolePermission(RolePermissionBean rolePermissionBean, PageQueryResult<RolePermissionBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(rolePermissionDao, rolePermissionBean, pageQueryResult);

		return pageQueryResult;
	}
}