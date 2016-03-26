package com.group.renshi.cache;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.group.renshi.bean.system.DeptInfoBean;
import com.group.renshi.dao.system.DeptInfoDao;
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
public class DeptInfoCache extends BaseCache {

	private static Logger logger = LoggerFactory.getLogger(DeptInfoCache.class);

	/**
	 * 构造方法是私有的
	 */
	private DeptInfoCache() {
		setCacheBool(true);
		setCacheName("科室信息缓存");
	}

	/**
	 * 对外开放，
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	public static synchronized DeptInfoCache getInstance()
			throws ApplicationException {
		DeptInfoCache exampleCache = (DeptInfoCache) BaseCache
				.getCachedInstance(DeptInfoCache.class.getName());
		if (exampleCache == null) {
			exampleCache = new DeptInfoCache();
			exampleCache.doSmartLoad();
			BaseCache.setCachedInstance(DeptInfoCache.class.getName(),
					exampleCache);
		}
		return exampleCache;
	}

	/**
	 * @see com.group.renshi.cache.BaseCache#reloadAllData()
	 */
	@Override
	protected void reloadAllData() throws ApplicationException {
		logger.info(">>>>> 获取科室缓存开始...");
		DeptInfoDao deptInfoDao = (DeptInfoDao) SpringBeanUtil
				.getSpringBean("deptInfoDao");
		List<DeptInfoBean> list = deptInfoDao.listData(new DeptInfoBean());

		for (DeptInfoBean deptInfoBean : list) {
			put(deptInfoBean.getDeptId(), deptInfoBean);
		}

		logger.info(">>>>> 获取科室数据结束，缓存" + list.size() + "条数据...");
	}

	/**
	 * 获取下拉列表数据
	 * 
	 * @return
	 */
	public List<DeptInfoBean> getSelectList(int hospitalId) {
		List<DeptInfoBean> list = new ArrayList<DeptInfoBean>();
		for (Object obj : cacheMap.keySet()) {
			int key = Integer.valueOf(obj.toString());
			DeptInfoBean deptInfoBean = (DeptInfoBean) cacheMap.get(key);
			// if (hospitalId == deptInfoBean.getHospitalId()) {
			list.add(deptInfoBean);
			// }
		}

		return list;
	}
}
