package com.group.renshi.service.share.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.share.TagInfoBean;
import com.group.renshi.service.share.TagInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: TagInfoServiceImpl.java,v 0.1 2015-07-03 下午08:32:29 Exp $
 */
@Service("tagInfoService")
@Transactional
public class TagInfoServiceImpl extends ServiceSupport implements TagInfoService
{
	/**
	 * 插入对象
	 * @see com.group.renshi.service.share.TagInfoService#insertTagInfo(com.group.renshi.bean.share.TagInfoBean)
	 */
	@Override
    public TagInfoBean insertTagInfo(TagInfoBean tagInfoBean) {
    	tagInfoDao.insert(tagInfoBean);
    	return tagInfoBean;
    }
    
    /**
	 * 删除对象
	 * @see com.group.renshi.service.share.TagInfoService#deleteTagInfo(int)
	 */
    @Override
    public void deleteTagInfo(int id) {
    	tagInfoDao.delete(id);
    }
    
    /**
	 * 更新对象
	 * @see com.group.renshi.service.share.TagInfoService#updateTagInfo(com.group.renshi.bean.share.TagInfoBean)
	 */
    @Override
    public void updateTagInfo(TagInfoBean tagInfoBean) {
    	TagInfoBean tagInfoBeanData = tagInfoDao.load(tagInfoBean.getTagId());
    
    	tagInfoDao.update(tagInfoBeanData);
    }
    
    /**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.share.TagInfoService#findById(int)
	 */
    @Override
    public TagInfoBean findById(int id) {
    	return tagInfoDao.load(id);
    }
    
    /**
	 * 获取列表数据
	 * @see com.group.renshi.service.share.TagInfoService#listTagInfo(com.group.renshi.bean.share.TagInfoBean)
	 */
	@Override
	public List<TagInfoBean> listTagInfo(TagInfoBean tagInfoBean) {
		List<TagInfoBean> tagInfoList = tagInfoDao.listData(tagInfoBean);
		return tagInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.share.TagInfoService#pageTagInfo(com.group.renshi.bean.share.TagInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<TagInfoBean> pageTagInfo(TagInfoBean tagInfoBean, PageQueryResult<TagInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(tagInfoDao, tagInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}