package com.group.renshi.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.group.webFramework.exception.ApplicationException;

/**
 * 该类用来做为所有需要缓存的类的基类
 * @author 
 * @date 
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class BaseCache {

	// 用于存放所有缓存
	private static Map instanceMap = new TreeMap();

	// 是否已经加载
	protected boolean hasLoaded = false;

	// 缓存内容
	protected Map cacheMap = new HashMap();

	// 是否缓存
	protected boolean cacheBool = true;

	// 排序方式
	protected int orderType;

	// 缓存名字
	protected String cacheName;

	// 缓存同步标志
	protected String mutex = "mutex";

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	protected boolean getCacheBool() {
		return cacheBool;
	}

	protected void setCacheBool(boolean cacheBool) {
		this.cacheBool = cacheBool;
	}

	protected int getOrderType() {
		return orderType;
	}

	protected void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	/*--------------------------------基类方法  start---------------------------------*/

	/**
	 * 装载缓存数据
	 * @throws Exception
	 */
	protected void doSmartLoad() throws ApplicationException {
		//如果不支持缓存则直接退出
		if (!this.getCacheBool()) {
			return;
		}
		if (!hasLoaded) {
			cacheMap.clear();
			reloadAllData();
			hasLoaded = true;
		}
	}

	/**
	 * 得到缓存类的实例
	 * @param className
	 * @return
	 */
	public static BaseCache getCachedInstance(String className) {
		return (BaseCache) instanceMap.get(className);
	}

	/**
	 * 删除缓存
	 * @param key
	 * @param entity
	 */
	public static void remove(Object key) {
		instanceMap.remove(key);
	}

	/**
	 * 添加缓存类的实例
	 * @param className
	 * @return
	 */
	public static void setCachedInstance(String className, BaseCache baseCache) {
		if (baseCache.getCacheBool()) {
			instanceMap.put(className, baseCache);
		}
	}

	/**
	 * 获得某个缓存的具体元素
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		return cacheMap.get(key);
	}

	/**
	 * 向具体的某个缓存中添加元素
	 * @param key
	 * @param entity
	 */
	public void put(Object key, Object entity) {
		cacheMap.put(key, entity);
	}

	/**
	 * 具体缓存中是否包含某个key
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {
		return cacheMap.containsKey(key);
	}

	/**
	 * 具体缓存中是否包含某个对象
	 * @param obj
	 * @return
	 */
	public boolean containsValue(Object obj) {
		return cacheMap.containsValue(obj);
	}

	/**
	 * 得到缓存的所有key
	 * @return
	 */
	public Set getKeys() {
		return cacheMap.keySet();
	}

	/**
	 * 得到缓存的所有结果
	 * @return
	 */
	public Collection getValues() {
		return cacheMap.values();
	}

	/**
	 * 返回一个新的map，以防止调用方扰乱数据
	 * @return
	 */
	public Map getMap() {
		Map newMap = new HashMap();
		newMap.putAll(cacheMap);
		return newMap;
	}

	/**
	 * 重置缓存为未加载
	 */
	public void doClear() {
		hasLoaded = false;
	}

	/*--------------------------------基类方法  end---------------------------------*/

	/*--------------------------------需要子类实现的方法  start---------------------------------*/
	/**
	 * 子类单独实现
	 * @throws Exception
	 */
	protected abstract void reloadAllData() throws ApplicationException;

	/*--------------------------------需要子类实现的方法  end---------------------------------*/
}