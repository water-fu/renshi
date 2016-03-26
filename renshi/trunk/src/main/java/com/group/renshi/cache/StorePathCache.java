package com.group.renshi.cache;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.group.renshi.constant.SystemConstantType;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.ConfigParse;

/**
 * 总体说明
 * 	文件上传存储路径缓存
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ExampleCache.java,v 0.1 2015-5-19 下午3:08:11 Exp $
 */
public class StorePathCache extends BaseCache {

	private static Logger logger = LoggerFactory.getLogger(StorePathCache.class);

	// 文件上传存储路径
	private String[] configs = { SystemConstantType.ID_CARD, SystemConstantType.CRETIFICATE_PATH,
			SystemConstantType.HEAD_PATH, SystemConstantType.VIDEO_PATH,
			SystemConstantType.POINT_PATH, SystemConstantType.CASE_PATH,
			SystemConstantType.LIBRARY_PATH, SystemConstantType.QUESTION_PATH };

	/**
	 * 构造方法是私有的
	 */
	private StorePathCache() {
		setCacheBool(true);
		setCacheName("上传存储路径缓存");
	}

	/**
	 * 对外开放
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	public static synchronized StorePathCache getInstance() throws ApplicationException {
		StorePathCache storePathCache = (StorePathCache) BaseCache
				.getCachedInstance(StorePathCache.class.getName());
		if (storePathCache == null) {
			storePathCache = new StorePathCache();
			storePathCache.doSmartLoad();
			BaseCache.setCachedInstance(StorePathCache.class.getName(), storePathCache);
		}
		return storePathCache;
	}

	/** 
	 * @see com.group.renshi.cache.BaseCache#reloadAllData()
	 */
	@Override
	protected void reloadAllData() throws ApplicationException {
		logger.info(">>>>> 获取文件上传存储路径开始...");

		Map<String, String> configMap = ConfigParse.parseConfig("storePath.properties", configs);
		for (String config : configs) {
			put(config, configMap.get(config));
		}

		logger.info(">>>>> 获取文件上传存储路径结束，缓存" + configMap.size() + "条数据...");
	}

	/**
	 * 根据key获取存储路径
	 * 
	 * @param key
	 * @return
	 */
	public String getStorePathByKey(String key) {
		Object obj = get(key);
		if (null == obj) {
			return "";
		}

		return obj.toString();
	}
}
