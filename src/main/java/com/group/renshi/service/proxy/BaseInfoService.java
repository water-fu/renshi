package com.group.renshi.service.proxy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.group.renshi.bean.proxy.BaseInfoBean;
import com.group.renshi.bean.proxy.LicenseInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: BaseInfoService.java,v 0.1 2015-06-27 下午11:11:39 Exp $
 */
public interface BaseInfoService {
	/**
	 * 插入对象
	 * 
	 * @param baseInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	BaseInfoBean insertBaseInfo(BaseInfoBean baseInfoBean, LicenseInfoBean licenseInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteBaseInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param baseInfoBean  需要更新的实体对象
	 */
	void updateBaseInfo(BaseInfoBean baseInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	BaseInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param baseInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<BaseInfoBean> listBaseInfo(BaseInfoBean baseInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param baseInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<BaseInfoBean> pageBaseInfo(BaseInfoBean baseInfoBean,
			PageQueryResult<BaseInfoBean> pageQueryResult);

	/**
	 * 
	 * @param request
	 * @param accountInfoBean
	 * @return
	 */
	AccountInfoBean login(HttpServletRequest request, AccountInfoBean accountInfoBean);

	/**
	 * 
	 * @param request
	 * @param accountInfoBean
	 */
	void insertAccountInfo(HttpServletRequest request, AccountInfoBean accountInfoBean);
}