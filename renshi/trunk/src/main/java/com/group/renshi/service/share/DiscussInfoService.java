package com.group.renshi.service.share;

import java.util.List;

import com.group.renshi.bean.share.DiscussInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: DiscussInfoService.java,v 0.1 2015-06-24 下午11:23:24 Exp $
 */
public interface DiscussInfoService {
	/**
	 * 插入对象
	 * 
	 * @param discussInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	DiscussInfoBean insertDiscussInfo(DiscussInfoBean discussInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteDiscussInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param discussInfoBean  需要更新的实体对象
	 */
	void updateDiscussInfo(DiscussInfoBean discussInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	DiscussInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param discussInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<DiscussInfoBean> listDiscussInfo(DiscussInfoBean discussInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param discussInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<DiscussInfoBean> pageDiscussInfo(DiscussInfoBean discussInfoBean,
			PageQueryResult<DiscussInfoBean> pageQueryResult);
}