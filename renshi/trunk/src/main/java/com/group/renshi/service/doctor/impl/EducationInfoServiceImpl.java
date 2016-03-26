package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.EducationInfoBean;
import com.group.renshi.service.doctor.EducationInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: EducationInfoServiceImpl.java,v 0.1 2015-06-17 下午10:32:37 Exp $
 */
@Service("educationInfoService")
@Transactional
public class EducationInfoServiceImpl extends ServiceSupport implements EducationInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.doctor.EducationInfoService#insertEducationInfo(com.group.renshi.bean.doctor.EducationInfoBean)
	 */
	@Override
	public EducationInfoBean insertEducationInfo(EducationInfoBean educationInfoBean) {
		educationInfoDao.insert(educationInfoBean);
		return educationInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.doctor.EducationInfoService#deleteEducationInfo(int)
	 */
	@Override
	public void deleteEducationInfo(int id) {
		educationInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.doctor.EducationInfoService#updateEducationInfo(com.group.renshi.bean.doctor.EducationInfoBean)
	 */
	@Override
	public void updateEducationInfo(EducationInfoBean educationInfoBean) {
		EducationInfoBean educationInfoBeanData = educationInfoDao.load(educationInfoBean
				.getEducationId());

		educationInfoDao.update(educationInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.doctor.EducationInfoService#findById(int)
	 */
	@Override
	public EducationInfoBean findById(int id) {
		return educationInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.doctor.EducationInfoService#listEducationInfo(com.group.renshi.bean.doctor.EducationInfoBean)
	 */
	@Override
	public List<EducationInfoBean> listEducationInfo(EducationInfoBean educationInfoBean) {
		List<EducationInfoBean> educationInfoList = educationInfoDao.listData(educationInfoBean);
		return educationInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.doctor.EducationInfoService#pageEducationInfo(com.group.renshi.bean.doctor.EducationInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<EducationInfoBean> pageEducationInfo(
			EducationInfoBean educationInfoBean, PageQueryResult<EducationInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(educationInfoDao, educationInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}