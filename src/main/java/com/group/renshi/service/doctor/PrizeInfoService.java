package com.group.renshi.service.doctor;

import java.util.List;

import com.group.renshi.bean.doctor.PrizeInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PrizeInfoService.java,v 0.1 2015-06-17 下午11:03:59 Exp $
 */
public interface PrizeInfoService {
	/**
	 * 插入对象
	 * 
	 * @param prizeInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	PrizeInfoBean insertPrizeInfo(PrizeInfoBean prizeInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deletePrizeInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param prizeInfoBean  需要更新的实体对象
	 */
	void updatePrizeInfo(PrizeInfoBean prizeInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	PrizeInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param prizeInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<PrizeInfoBean> listPrizeInfo(PrizeInfoBean prizeInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param prizeInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<PrizeInfoBean> pagePrizeInfo(PrizeInfoBean prizeInfoBean,
			PageQueryResult<PrizeInfoBean> pageQueryResult);
}