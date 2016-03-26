package com.group.renshi.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.system.HospitalInfoBean;
import com.group.renshi.cache.HospitalInfoCache;
import com.group.renshi.service.system.HospitalInfoService;
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
 * @version $Id: HospitalInfoServiceImpl.java,v 0.1 2015-07-14 ����03:03:24 Exp
 *          $
 */
@Service("hospitalInfoService")
@Transactional
public class HospitalInfoServiceImpl extends ServiceSupport implements
		HospitalInfoService {
	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.system.HospitalInfoService#insertHospitalInfo(com.group.renshi.bean.system.HospitalInfoBean)
	 */
	@Override
	public HospitalInfoBean insertHospitalInfo(HospitalInfoBean hospitalInfoBean) {
		HospitalInfoCache.remove(HospitalInfoCache.class.getName());

		hospitalInfoDao.insert(hospitalInfoBean);
		return hospitalInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.system.HospitalInfoService#deleteHospitalInfo(int)
	 */
	@Override
	public void deleteHospitalInfo(int id) {
		HospitalInfoCache.remove(HospitalInfoCache.class.getName());

		hospitalInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.system.HospitalInfoService#updateHospitalInfo(com.group.renshi.bean.system.HospitalInfoBean)
	 */
	@Override
	public void updateHospitalInfo(HospitalInfoBean hospitalInfoBean) {
		HospitalInfoCache.remove(HospitalInfoCache.class.getName());

		HospitalInfoBean hospitalInfoBeanData = hospitalInfoDao
				.load(hospitalInfoBean.getHospitalId());
		hospitalInfoBeanData.setAreaId(hospitalInfoBean.getAreaId());
		hospitalInfoBeanData
				.setHospitalName(hospitalInfoBean.getHospitalName());
		hospitalInfoDao.update(hospitalInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.system.HospitalInfoService#findById(int)
	 */
	@Override
	public HospitalInfoBean findById(int id) {
		return hospitalInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.system.HospitalInfoService#listHospitalInfo(com.group.renshi.bean.system.HospitalInfoBean)
	 */
	@Override
	public List<HospitalInfoBean> listHospitalInfo(
			HospitalInfoBean hospitalInfoBean) {
		List<HospitalInfoBean> hospitalInfoList = hospitalInfoDao
				.listData(hospitalInfoBean);
		return hospitalInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.system.HospitalInfoService#pageHospitalInfo(com.group.renshi.bean.system.HospitalInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<HospitalInfoBean> pageHospitalInfo(
			HospitalInfoBean hospitalInfoBean,
			PageQueryResult<HospitalInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(hospitalInfoDao, hospitalInfoBean,
				pageQueryResult);

		return pageQueryResult;
	}
}