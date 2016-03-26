package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.WorkInfoBean;
import com.group.renshi.service.doctor.WorkInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: WorkInfoServiceImpl.java,v 0.1 2015-06-17 下午10:45:58 Exp $
 */
@Service("workInfoService")
@Transactional
public class WorkInfoServiceImpl extends ServiceSupport implements WorkInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.doctor.WorkInfoService#insertWorkInfo(com.group.renshi.bean.doctor.WorkInfoBean)
	 */
	@Override
	public WorkInfoBean insertWorkInfo(WorkInfoBean workInfoBean) {
		workInfoDao.insert(workInfoBean);
		return workInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.doctor.WorkInfoService#deleteWorkInfo(int)
	 */
	@Override
	public void deleteWorkInfo(int id) {
		workInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.doctor.WorkInfoService#updateWorkInfo(com.group.renshi.bean.doctor.WorkInfoBean)
	 */
	@Override
	public void updateWorkInfo(WorkInfoBean workInfoBean) {
		WorkInfoBean workInfoBeanData = workInfoDao.load(workInfoBean.getWorkId());

		workInfoDao.update(workInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.doctor.WorkInfoService#findById(int)
	 */
	@Override
	public WorkInfoBean findById(int id) {
		return workInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.doctor.WorkInfoService#listWorkInfo(com.group.renshi.bean.doctor.WorkInfoBean)
	 */
	@Override
	public List<WorkInfoBean> listWorkInfo(WorkInfoBean workInfoBean) {
		List<WorkInfoBean> workInfoList = workInfoDao.listData(workInfoBean);
		return workInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.doctor.WorkInfoService#pageWorkInfo(com.group.renshi.bean.doctor.WorkInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<WorkInfoBean> pageWorkInfo(WorkInfoBean workInfoBean,
			PageQueryResult<WorkInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(workInfoDao, workInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}