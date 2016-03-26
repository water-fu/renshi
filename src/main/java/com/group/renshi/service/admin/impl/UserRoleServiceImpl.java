package com.group.renshi.service.admin.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.admin.UserRoleBean;
import com.group.renshi.service.admin.UserRoleService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: UserRoleServiceImpl.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl extends ServiceSupport implements UserRoleService
{
	/**
	 * 插入对象
	 * @see com.group.renshi.service.admin.UserRoleService#insertUserRole(com.group.renshi.bean.admin.UserRoleBean)
	 */
	@Override
	public UserRoleBean insertUserRole(UserRoleBean userRoleBean) {
		userRoleDao.insert(userRoleBean);
		return userRoleBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.admin.UserRoleService#deleteUserRole(int)
	 */
	@Override
	public void deleteUserRole(int id) {
		userRoleDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.admin.UserRoleService#updateUserRole(com.group.renshi.bean.admin.UserRoleBean)
	 */
	@Override
	public void updateUserRole(UserRoleBean userRoleBean) {
		UserRoleBean userRoleBeanData = userRoleDao.load(userRoleBean.getId());

		userRoleDao.update(userRoleBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.admin.UserRoleService#findById(int)
	 */
	@Override
	public UserRoleBean findById(int id) {
		return userRoleDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.admin.UserRoleService#listUserRole(com.group.renshi.bean.admin.UserRoleBean)
	 */
	@Override
	public List<UserRoleBean> listUserRole(UserRoleBean userRoleBean) {
		List<UserRoleBean> userRoleList = userRoleDao.listData(userRoleBean);
		return userRoleList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.admin.UserRoleService#pageUserRole(com.group.renshi.bean.admin.UserRoleBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<UserRoleBean> pageUserRole(UserRoleBean userRoleBean, PageQueryResult<UserRoleBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(userRoleDao, userRoleBean, pageQueryResult);

		return pageQueryResult;
	}
}