package com.group.webFramework.common;

import java.util.List;
import java.util.Map;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: BaseDao.java,v 0.1 2015-5-19 下午8:29:17 Exp $
 */
public interface BaseDao<T> {
	/**
	 * 插入
	 * 
	 * @param entity
	 * @return 返回成功记录数
	 */
	public int insert(T entity);

	/**
	 * 更新
	 * 
	 * @param user
	 * @return
	 */
	public int update(T entity);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id);

	/**
	 * 查询列表数据
	 * 
	 * @return
	 */
	public List<T> listData(T entity);

	/**
	 * 查询分页数据
	 * 
	 * @return
	 */
	public List<T> pageData(Map<String, Object> map);

	/**
	 * 分页查询统计总数
	 * 
	 * @param map
	 * @return
	 */
	public int countPageData(Map<String, Object> map);

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	public T load(int id);
}
