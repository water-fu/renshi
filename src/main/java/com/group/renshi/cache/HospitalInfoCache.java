package com.group.renshi.cache;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.group.renshi.bean.system.HospitalInfoBean;
import com.group.renshi.dao.system.HospitalInfoDao;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.SpringBeanUtil;

/**
 * 总体说明 医院信息缓存
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: ExampleCache.java,v 0.1 2015-5-19 下午3:08:11 Exp $
 */

public class HospitalInfoCache extends BaseCache {
	private static Logger logger = LoggerFactory
			.getLogger(HospitalInfoCache.class);

	/**
	 * 构造方法是私有的
	 */
	private HospitalInfoCache() {
		setCacheBool(true);
		setCacheName("医院信息缓存");
	}

	/**
	 * 对外开放，
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	public static synchronized HospitalInfoCache getInstance()
			throws ApplicationException {
		HospitalInfoCache exampleCache = (HospitalInfoCache) BaseCache
				.getCachedInstance(HospitalInfoCache.class.getName());
		if (exampleCache == null) {
			exampleCache = new HospitalInfoCache();
			exampleCache.doSmartLoad();
			BaseCache.setCachedInstance(HospitalInfoCache.class.getName(),
					exampleCache);
		}
		return exampleCache;
	}

	/**
	 * @see com.group.renshi.cache.BaseCache#reloadAllData()
	 */
	@Override
	protected void reloadAllData() throws ApplicationException {
		logger.info(">>>>> 获取医院缓存开始...");
		HospitalInfoDao hospitalInfoDao = (HospitalInfoDao) SpringBeanUtil
				.getSpringBean("hospitalInfoDao");
		HospitalInfoBean hospitalInfoBean = new HospitalInfoBean();
		List<HospitalInfoBean> list = hospitalInfoDao
				.listData(hospitalInfoBean);

		for (HospitalInfoBean hospitalInfoBean2 : list) {
			put(hospitalInfoBean2.getHospitalId(), hospitalInfoBean2);
		}

		logger.info(">>>>> 获取示例数据结束，缓存" + list.size() + "条数据...");
	}

	/**
	 * 获取下拉列表数据
	 * 
	 * @return
	 */
	public List<HospitalInfoBean> getSelectList() {
		List<HospitalInfoBean> list = new ArrayList<HospitalInfoBean>();
		for (Object obj : cacheMap.keySet()) {
			int key = Integer.valueOf(obj.toString());
			list.add((HospitalInfoBean) cacheMap.get(key));
		}

		return list;
	}
}
