package com.group.renshi.dao.share;

import java.util.List;
import java.util.Map;

import com.group.renshi.bean.share.DiscussInfoBean;
import com.group.webFramework.common.BaseDao;

/**
 * 
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: DiscussInfoDao.java,v 0.1 2015-06-24 下午11:23:24 Exp $
 */
public interface DiscussInfoDao extends BaseDao<DiscussInfoBean> {

	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	int countComment(Map<String, Object> paramMap);

	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	List<DiscussInfoBean> pageComment(Map<String, Object> paramMap);

}
