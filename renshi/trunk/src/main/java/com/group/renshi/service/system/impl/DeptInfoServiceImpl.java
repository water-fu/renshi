package com.group.renshi.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.system.DeptInfoBean;
import com.group.renshi.cache.DeptInfoCache;
import com.group.renshi.service.system.DeptInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: DeptInfoServiceImpl.java,v 0.1 2015-07-14 ����03:03:24 Exp $
 */
@Service("deptInfoService")
@Transactional
public class DeptInfoServiceImpl extends ServiceSupport implements
		DeptInfoService {
	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.system.DeptInfoService#insertDeptInfo(com.group.renshi.bean.system.DeptInfoBean)
	 */
	@Override
	public DeptInfoBean insertDeptInfo(DeptInfoBean deptInfoBean) {
		DeptInfoCache.remove(DeptInfoCache.class.getName());

		deptInfoDao.insert(deptInfoBean);
		return deptInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.system.DeptInfoService#deleteDeptInfo(int)
	 */
	@Override
	public void deleteDeptInfo(int id) {
		DeptInfoCache.remove(DeptInfoCache.class.getName());

		deptInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.system.DeptInfoService#updateDeptInfo(com.group.renshi.bean.system.DeptInfoBean)
	 */
	@Override
	public void updateDeptInfo(DeptInfoBean deptInfoBean) {
		DeptInfoCache.remove(DeptInfoCache.class.getName());

		DeptInfoBean deptInfoBeanData = deptInfoDao.load(deptInfoBean
				.getDeptId());
		deptInfoBeanData.setHospitalId(deptInfoBean.getHospitalId());
		deptInfoBeanData.setDeptName(deptInfoBean.getDeptName());
		deptInfoBeanData.setDeptType(deptInfoBean.getDeptType());
		deptInfoDao.update(deptInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.system.DeptInfoService#findById(int)
	 */
	@Override
	public DeptInfoBean findById(int id) {
		return deptInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.system.DeptInfoService#listDeptInfo(com.group.renshi.bean.system.DeptInfoBean)
	 */
	@Override
	public List<DeptInfoBean> listDeptInfo(DeptInfoBean deptInfoBean) {
		List<DeptInfoBean> deptInfoList = deptInfoDao.listData(deptInfoBean);
		return deptInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.system.DeptInfoService#pageDeptInfo(com.group.renshi.bean.system.DeptInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<DeptInfoBean> pageDeptInfo(
			DeptInfoBean deptInfoBean,
			PageQueryResult<DeptInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(deptInfoDao, deptInfoBean,
				pageQueryResult);

		return pageQueryResult;
	}
}