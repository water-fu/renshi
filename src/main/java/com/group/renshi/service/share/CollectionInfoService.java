package com.group.renshi.service.share;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.group.renshi.bean.share.CollectionInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: CollectionInfoService.java,v 0.1 2015-06-23 下午09:56:44 Exp $
 */
public interface CollectionInfoService {
	/**
	 * 插入对象
	 * 
	 * @param collectionInfoBean
	 *            需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	CollectionInfoBean insertCollectionInfo(CollectionInfoBean collectionInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键编号
	 */
	void deleteCollectionInfo(CollectionInfoBean collectionInfoBean);

	/**
	 * 更新对象
	 * 
	 * @param collectionInfoBean
	 *            需要更新的实体对象
	 */
	void updateCollectionInfo(CollectionInfoBean collectionInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id
	 *            主键编号
	 * @return 返回实体对象
	 */
	CollectionInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param collectionInfoBean
	 *            实体对象
	 * @return 返回列表对象
	 */
	List<CollectionInfoBean> listCollectionInfo(CollectionInfoBean collectionInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param collectionInfoBean
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @return 返回分页对象
	 */
	PageQueryResult<ShareInfoBean> pageCollectionInfo(CollectionInfoBean collectionInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 根据标题搜索 收藏记录
	 * 
	 * @param collectionInfoBean
	 * @param pageQueryResult
	 * @param request
	 * @param collectTitle
	 * @return
	 */
	PageQueryResult<ShareInfoBean> pageCollectionSearch(
			CollectionInfoBean collectionInfoBean, PageQueryResult<ShareInfoBean> pageQueryResult,
			String collectTitle, HttpServletRequest request);
}