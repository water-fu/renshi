package com.group.renshi.service.proxy.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.proxy.LicenseInfoBean;
import com.group.renshi.service.proxy.LicenseInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: LicenseInfoServiceImpl.java,v 0.1 2015-06-27 ����11:16:27 Exp $
 */
@Service("licenseInfoService")
@Transactional
public class LicenseInfoServiceImpl extends ServiceSupport implements LicenseInfoService
{
	/**
	 * 插入对象
	 * @see com.group.renshi.service.proxy.LicenseInfoService#insertLicenseInfo(com.group.renshi.bean.proxy.LicenseInfoBean)
	 */
	@Override
    public LicenseInfoBean insertLicenseInfo(LicenseInfoBean licenseInfoBean) {
    	licenseInfoDao.insert(licenseInfoBean);
    	return licenseInfoBean;
    }
    
    /**
	 * 删除对象
	 * @see com.group.renshi.service.proxy.LicenseInfoService#deleteLicenseInfo(int)
	 */
    @Override
    public void deleteLicenseInfo(int id) {
    	licenseInfoDao.delete(id);
    }
    
    /**
	 * 更新对象
	 * @see com.group.renshi.service.proxy.LicenseInfoService#updateLicenseInfo(com.group.renshi.bean.proxy.LicenseInfoBean)
	 */
    @Override
    public void updateLicenseInfo(LicenseInfoBean licenseInfoBean) {
    	LicenseInfoBean licenseInfoBeanData = licenseInfoDao.load(licenseInfoBean.getAccountId());
    
    	licenseInfoDao.update(licenseInfoBeanData);
    }
    
    /**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.proxy.LicenseInfoService#findById(int)
	 */
    @Override
    public LicenseInfoBean findById(int id) {
    	return licenseInfoDao.load(id);
    }
    
    /**
	 * 获取列表数据
	 * @see com.group.renshi.service.proxy.LicenseInfoService#listLicenseInfo(com.group.renshi.bean.proxy.LicenseInfoBean)
	 */
	@Override
	public List<LicenseInfoBean> listLicenseInfo(LicenseInfoBean licenseInfoBean) {
		List<LicenseInfoBean> licenseInfoList = licenseInfoDao.listData(licenseInfoBean);
		return licenseInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.proxy.LicenseInfoService#pageLicenseInfo(com.group.renshi.bean.proxy.LicenseInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<LicenseInfoBean> pageLicenseInfo(LicenseInfoBean licenseInfoBean, PageQueryResult<LicenseInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(licenseInfoDao, licenseInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}