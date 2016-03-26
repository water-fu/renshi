package com.group.renshi.service.doctor;

import java.util.List;

import com.group.renshi.bean.doctor.PatentInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PatentInfoService.java,v 0.1 2015-06-17 下午11:14:34 Exp $
 */
public interface PatentInfoService {
	/**
	 * 插入对象
	 * 
	 * @param patentInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	PatentInfoBean insertPatentInfo(PatentInfoBean patentInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deletePatentInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param patentInfoBean  需要更新的实体对象
	 */
	void updatePatentInfo(PatentInfoBean patentInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	PatentInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param patentInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<PatentInfoBean> listPatentInfo(PatentInfoBean patentInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param patentInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<PatentInfoBean> pagePatentInfo(PatentInfoBean patentInfoBean,
			PageQueryResult<PatentInfoBean> pageQueryResult);
}