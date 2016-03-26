package com.group.renshi.service.doctor;

import java.util.List;

import com.group.renshi.bean.doctor.WorkInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: WorkInfoService.java,v 0.1 2015-06-17 下午10:45:58 Exp $
 */
public interface WorkInfoService {
	/**
	 * 插入对象
	 * 
	 * @param workInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	WorkInfoBean insertWorkInfo(WorkInfoBean workInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteWorkInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param workInfoBean  需要更新的实体对象
	 */
	void updateWorkInfo(WorkInfoBean workInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	WorkInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param workInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<WorkInfoBean> listWorkInfo(WorkInfoBean workInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param workInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<WorkInfoBean> pageWorkInfo(WorkInfoBean workInfoBean,
			PageQueryResult<WorkInfoBean> pageQueryResult);
}