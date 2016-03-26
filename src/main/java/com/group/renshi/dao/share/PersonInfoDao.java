package com.group.renshi.dao.share;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.group.renshi.bean.share.PersonInfoBean;
import com.group.webFramework.common.BaseDao;

/**
 * 
 * 总体说明
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: PersonInfoDao.java,v 0.1 2015-06-09 下午08:53:43 Exp $
 */
public interface PersonInfoDao extends BaseDao<PersonInfoBean> {

	/**
	 * 根据accountId查询记录
	 * 
	 * @param accountId
	 * @return
	 */
	public PersonInfoBean loadByAccountId(@Param("accountId") int accountId);

	/**
	 * 获取最权威医生列表
	 * 
	 * @return
	 */
	public List<PersonInfoBean> findMostAnswer();

	/**
	 * 获取每个模块最活跃的用户
	 * 
	 * @param shareType
	 * @return
	 */
	public List<PersonInfoBean> findMostPerson(@Param("shareType") String shareType);

}
