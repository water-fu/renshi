package com.group.renshi.service.admin.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.admin.RoleBean;
import com.group.renshi.service.admin.RoleService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: RoleServiceImpl.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl extends ServiceSupport implements RoleService
{
	/**
	 * 插入对象
	 * @see com.group.renshi.service.admin.RoleService#insertRole(com.group.renshi.bean.admin.RoleBean)
	 */
	@Override
	public RoleBean insertRole(RoleBean roleBean) {
		roleDao.insert(roleBean);
		return roleBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.admin.RoleService#deleteRole(int)
	 */
	@Override
	public void deleteRole(int id) {
		roleDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.admin.RoleService#updateRole(com.group.renshi.bean.admin.RoleBean)
	 */
	@Override
	public void updateRole(RoleBean roleBean) {
		RoleBean roleBeanData = roleDao.load(roleBean.getRoleId());

		roleDao.update(roleBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.admin.RoleService#findById(int)
	 */
	@Override
	public RoleBean findById(int id) {
		return roleDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.admin.RoleService#listRole(com.group.renshi.bean.admin.RoleBean)
	 */
	@Override
	public List<RoleBean> listRole(RoleBean roleBean) {
		List<RoleBean> roleList = roleDao.listData(roleBean);
		return roleList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.admin.RoleService#pageRole(com.group.renshi.bean.admin.RoleBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<RoleBean> pageRole(RoleBean roleBean, PageQueryResult<RoleBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(roleDao, roleBean, pageQueryResult);

		return pageQueryResult;
	}
}