package com.group.renshi.service.share;

import java.util.List;

import com.group.renshi.bean.share.PersonInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: PersonInfoService.java,v 0.1 2015-06-09 下午08:53:43 Exp $
 */
public interface PersonInfoService {
	/**
	 * 插入对象
	 * 
	 * @param personInfoBean
	 *            需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	PersonInfoBean insertPersonInfo(PersonInfoBean personInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键编号
	 */
	void deletePersonInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param personInfoBean
	 *            需要更新的实体对象
	 */
	void updatePersonInfo(PersonInfoBean personInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id
	 *            主键编号
	 * @return 返回实体对象
	 */
	PersonInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param personInfoBean
	 *            实体对象
	 * @return 返回列表对象
	 */
	List<PersonInfoBean> listPersonInfo(PersonInfoBean personInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param personInfoBean
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @return 返回分页对象
	 */
	PageQueryResult<PersonInfoBean> pagePersonInfo(
			PersonInfoBean personInfoBean,
			PageQueryResult<PersonInfoBean> pageQueryResult);

	/**
	 * 根据accountId获取个人空间信息
	 * 
	 * @param accountId
	 * @return
	 */
	PersonInfoBean findByAccountId(int accountId);

	/**
	 * 个人空间流量数量+1
	 * 
	 * @param personInfoBean
	 */
	void updateBrowerNum(PersonInfoBean personInfoBean);

	/**
	 * 获取最权威医生列表
	 * 
	 * @return
	 */
	List<PersonInfoBean> findMostAnswer();

	/**
	 * 
	 * @param id
	 */
	void openSpace(int id);

	/**
	 * 
	 * @param id
	 */
	void closeSpace(int id);

	/**
	 * 
	 * @return
	 */
	List<PersonInfoBean> findMostPerson(String shareType);
}