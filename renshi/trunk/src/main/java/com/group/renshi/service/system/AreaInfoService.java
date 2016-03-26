package com.group.renshi.service.system;

import java.util.List;

import com.group.renshi.bean.system.AreaInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AreaInfoService.java,v 0.1 2015-07-14 ����03:03:24 Exp $
 */
public interface AreaInfoService
{
	/**
	 * 插入对象
	 * 
	 * @param areaInfoBean  �?��插入的实体对�?	 * @return 返回插入后带自增长主键的对象
	 */
    AreaInfoBean insertAreaInfo(AreaInfoBean areaInfoBean);
    
    /**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
    void deleteAreaInfo(int id);
    
    /**
	 * 更新对象
	 * 
	 * @param areaInfoBean  �?��更新的实体对�?	 */
    void updateAreaInfo(AreaInfoBean areaInfoBean);
    
    /**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
    AreaInfoBean findById(int id);
    
    /**
	 * 获取列表数据
	 * 
	 * @param areaInfoBean  实体对象
	 * @return   返回列表对象
	 */
    List<AreaInfoBean> listAreaInfo(AreaInfoBean areaInfoBean);
    
    /**
	 * 获取分页数据
	 * 
	 * @param areaInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<AreaInfoBean> pageAreaInfo(AreaInfoBean areaInfoBean, PageQueryResult<AreaInfoBean> pageQueryResult);
}