package com.group.renshi.service.admin.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.admin.PermissionBean;
import com.group.renshi.service.admin.PermissionService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PermissionServiceImpl.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
@Service("permissionService")
@Transactional
public class PermissionServiceImpl extends ServiceSupport implements PermissionService
{
	/**
	 * 插入对象
	 * @see com.group.renshi.service.admin.PermissionService#insertPermission(com.group.renshi.bean.admin.PermissionBean)
	 */
	@Override
	public PermissionBean insertPermission(PermissionBean permissionBean) {
		permissionDao.insert(permissionBean);
		return permissionBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.admin.PermissionService#deletePermission(int)
	 */
	@Override
	public void deletePermission(int id) {
		permissionDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.admin.PermissionService#updatePermission(com.group.renshi.bean.admin.PermissionBean)
	 */
	@Override
	public void updatePermission(PermissionBean permissionBean) {
		PermissionBean permissionBeanData = permissionDao.load(permissionBean.getPermId());

		permissionDao.update(permissionBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.admin.PermissionService#findById(int)
	 */
	@Override
	public PermissionBean findById(int id) {
		return permissionDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.admin.PermissionService#listPermission(com.group.renshi.bean.admin.PermissionBean)
	 */
	@Override
	public List<PermissionBean> listPermission(PermissionBean permissionBean) {
		List<PermissionBean> permissionList = permissionDao.listData(permissionBean);
		return permissionList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.admin.PermissionService#pagePermission(com.group.renshi.bean.admin.PermissionBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<PermissionBean> pagePermission(PermissionBean permissionBean, PageQueryResult<PermissionBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(permissionDao, permissionBean, pageQueryResult);

		return pageQueryResult;
	}
}