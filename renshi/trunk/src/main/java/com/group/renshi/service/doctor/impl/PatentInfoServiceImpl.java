package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.PatentInfoBean;
import com.group.renshi.service.doctor.PatentInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PatentInfoServiceImpl.java,v 0.1 2015-06-17 下午11:14:34 Exp $
 */
@Service("patentInfoService")
@Transactional
public class PatentInfoServiceImpl extends ServiceSupport implements PatentInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.doctor.PatentInfoService#insertPatentInfo(com.group.renshi.bean.doctor.PatentInfoBean)
	 */
	@Override
	public PatentInfoBean insertPatentInfo(PatentInfoBean patentInfoBean) {
		patentInfoDao.insert(patentInfoBean);
		return patentInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.doctor.PatentInfoService#deletePatentInfo(int)
	 */
	@Override
	public void deletePatentInfo(int id) {
		patentInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.doctor.PatentInfoService#updatePatentInfo(com.group.renshi.bean.doctor.PatentInfoBean)
	 */
	@Override
	public void updatePatentInfo(PatentInfoBean patentInfoBean) {
		PatentInfoBean patentInfoBeanData = patentInfoDao.load(patentInfoBean.getPatentId());

		patentInfoDao.update(patentInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.doctor.PatentInfoService#findById(int)
	 */
	@Override
	public PatentInfoBean findById(int id) {
		return patentInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.doctor.PatentInfoService#listPatentInfo(com.group.renshi.bean.doctor.PatentInfoBean)
	 */
	@Override
	public List<PatentInfoBean> listPatentInfo(PatentInfoBean patentInfoBean) {
		List<PatentInfoBean> patentInfoList = patentInfoDao.listData(patentInfoBean);
		return patentInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.doctor.PatentInfoService#pagePatentInfo(com.group.renshi.bean.doctor.PatentInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<PatentInfoBean> pagePatentInfo(PatentInfoBean patentInfoBean,
			PageQueryResult<PatentInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(patentInfoDao, patentInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}