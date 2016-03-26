package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.PrizeInfoBean;
import com.group.renshi.service.doctor.PrizeInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PrizeInfoServiceImpl.java,v 0.1 2015-06-17 下午11:03:59 Exp $
 */
@Service("prizeInfoService")
@Transactional
public class PrizeInfoServiceImpl extends ServiceSupport implements PrizeInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.doctor.PrizeInfoService#insertPrizeInfo(com.group.renshi.bean.doctor.PrizeInfoBean)
	 */
	@Override
	public PrizeInfoBean insertPrizeInfo(PrizeInfoBean prizeInfoBean) {
		prizeInfoDao.insert(prizeInfoBean);
		return prizeInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.doctor.PrizeInfoService#deletePrizeInfo(int)
	 */
	@Override
	public void deletePrizeInfo(int id) {
		prizeInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.doctor.PrizeInfoService#updatePrizeInfo(com.group.renshi.bean.doctor.PrizeInfoBean)
	 */
	@Override
	public void updatePrizeInfo(PrizeInfoBean prizeInfoBean) {
		PrizeInfoBean prizeInfoBeanData = prizeInfoDao.load(prizeInfoBean.getPrizeId());

		prizeInfoDao.update(prizeInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.doctor.PrizeInfoService#findById(int)
	 */
	@Override
	public PrizeInfoBean findById(int id) {
		return prizeInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.doctor.PrizeInfoService#listPrizeInfo(com.group.renshi.bean.doctor.PrizeInfoBean)
	 */
	@Override
	public List<PrizeInfoBean> listPrizeInfo(PrizeInfoBean prizeInfoBean) {
		List<PrizeInfoBean> prizeInfoList = prizeInfoDao.listData(prizeInfoBean);
		return prizeInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.doctor.PrizeInfoService#pagePrizeInfo(com.group.renshi.bean.doctor.PrizeInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<PrizeInfoBean> pagePrizeInfo(PrizeInfoBean prizeInfoBean,
			PageQueryResult<PrizeInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(prizeInfoDao, prizeInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}