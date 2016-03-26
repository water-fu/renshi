package com.group.renshi.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.system.AreaInfoBean;
import com.group.renshi.service.system.AreaInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AreaInfoServiceImpl.java,v 0.1 2015-07-14 ����03:03:24 Exp $
 */
@Service("areaInfoService")
@Transactional
public class AreaInfoServiceImpl extends ServiceSupport implements AreaInfoService
{
	/**
	 * 插入对象
	 * @see com.group.renshi.service.system.AreaInfoService#insertAreaInfo(com.group.renshi.bean.system.AreaInfoBean)
	 */
	@Override
    public AreaInfoBean insertAreaInfo(AreaInfoBean areaInfoBean) {
    	areaInfoDao.insert(areaInfoBean);
    	return areaInfoBean;
    }
    
    /**
	 * 删除对象
	 * @see com.group.renshi.service.system.AreaInfoService#deleteAreaInfo(int)
	 */
    @Override
    public void deleteAreaInfo(int id) {
    	areaInfoDao.delete(id);
    }
    
    /**
	 * 更新对象
	 * @see com.group.renshi.service.system.AreaInfoService#updateAreaInfo(com.group.renshi.bean.system.AreaInfoBean)
	 */
    @Override
    public void updateAreaInfo(AreaInfoBean areaInfoBean) {
    	AreaInfoBean areaInfoBeanData = areaInfoDao.load(areaInfoBean.getAreaId());
		areaInfoBeanData.setAreaName(areaInfoBean.getAreaName());
		areaInfoBeanData.setFirstChar(areaInfoBean.getFirstChar());
    	areaInfoBeanData.setParentId(areaInfoBean.getParentId());
    	areaInfoDao.update(areaInfoBeanData);
    }
    
    /**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.system.AreaInfoService#findById(int)
	 */
    @Override
    public AreaInfoBean findById(int id) {
    	return areaInfoDao.load(id);
    }
    
    /**
	 * 获取列表数据
	 * @see com.group.renshi.service.system.AreaInfoService#listAreaInfo(com.group.renshi.bean.system.AreaInfoBean)
	 */
	@Override
	public List<AreaInfoBean> listAreaInfo(AreaInfoBean areaInfoBean) {
		List<AreaInfoBean> areaInfoList = areaInfoDao.listData(areaInfoBean);
		return areaInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.system.AreaInfoService#pageAreaInfo(com.group.renshi.bean.system.AreaInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<AreaInfoBean> pageAreaInfo(AreaInfoBean areaInfoBean, PageQueryResult<AreaInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(areaInfoDao, areaInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}