package com.group.renshi.service.proxy;

import java.util.List;

import com.group.renshi.bean.proxy.LicenseInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: LicenseInfoService.java,v 0.1 2015-06-27 ����11:16:27 Exp $
 */
public interface LicenseInfoService
{
	/**
	 * 插入对象
	 * 
	 * @param licenseInfoBean  �?��插入的实体对�?	 * @return 返回插入后带自增长主键的对象
	 */
    LicenseInfoBean insertLicenseInfo(LicenseInfoBean licenseInfoBean);
    
    /**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
    void deleteLicenseInfo(int id);
    
    /**
	 * 更新对象
	 * 
	 * @param licenseInfoBean  �?��更新的实体对�?	 */
    void updateLicenseInfo(LicenseInfoBean licenseInfoBean);
    
    /**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
    LicenseInfoBean findById(int id);
    
    /**
	 * 获取列表数据
	 * 
	 * @param licenseInfoBean  实体对象
	 * @return   返回列表对象
	 */
    List<LicenseInfoBean> listLicenseInfo(LicenseInfoBean licenseInfoBean);
    
    /**
	 * 获取分页数据
	 * 
	 * @param licenseInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<LicenseInfoBean> pageLicenseInfo(LicenseInfoBean licenseInfoBean, PageQueryResult<LicenseInfoBean> pageQueryResult);
}