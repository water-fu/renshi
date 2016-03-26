package com.group.renshi.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.group.webFramework.exception.ApplicationException;

/**
 * 总体说明
 * 	缓存类编写示例
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ExampleCache.java,v 0.1 2015-5-19 下午3:08:11 Exp $
 */
public class ExampleCache extends BaseCache {

	private static Logger logger = LoggerFactory.getLogger(ExampleCache.class);

	/**
	 * 构造方法是私有的
	 */
	private ExampleCache() {
		setCacheBool(true);
		setCacheName("示例缓存");
	}

	/**
	 * 对外开放，
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	public static synchronized ExampleCache getInstance() throws ApplicationException {
		ExampleCache exampleCache = (ExampleCache) BaseCache.getCachedInstance(ExampleCache.class
				.getName());
		if (exampleCache == null) {
			exampleCache = new ExampleCache();
			exampleCache.doSmartLoad();
			BaseCache.setCachedInstance(ExampleCache.class.getName(), exampleCache);
		}
		return exampleCache;
	}

	/** 
	 * @see com.group.renshi.cache.BaseCache#reloadAllData()
	 */
	@Override
	protected void reloadAllData() throws ApplicationException {
		logger.info(">>>>> 获取示例数据开始...");

		logger.info(">>>>> 获取示例数据结束，缓存xx条数据...");
	}
}
