package com.group.renshi.service.share.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.share.VideoInfoBean;
import com.group.renshi.service.share.VideoInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: VideoInfoServiceImpl.java,v 0.1 2015-07-05 ����09:51:39 Exp $
 */
@Service("videoInfoService")
@Transactional
public class VideoInfoServiceImpl extends ServiceSupport implements VideoInfoService
{
	/**
	 * 插入对象
	 * @see com.group.renshi.service.share.VideoInfoService#insertVideoInfo(com.group.renshi.bean.share.VideoInfoBean)
	 */
	@Override
    public VideoInfoBean insertVideoInfo(VideoInfoBean videoInfoBean) {
    	videoInfoDao.insert(videoInfoBean);
    	return videoInfoBean;
    }
    
    /**
	 * 删除对象
	 * @see com.group.renshi.service.share.VideoInfoService#deleteVideoInfo(int)
	 */
    @Override
    public void deleteVideoInfo(int id) {
    	videoInfoDao.delete(id);
    }
    
    /**
	 * 更新对象
	 * @see com.group.renshi.service.share.VideoInfoService#updateVideoInfo(com.group.renshi.bean.share.VideoInfoBean)
	 */
    @Override
    public void updateVideoInfo(VideoInfoBean videoInfoBean) {
    	VideoInfoBean videoInfoBeanData = videoInfoDao.load(videoInfoBean.getShareId());
    
    	videoInfoDao.update(videoInfoBeanData);
    }
    
    /**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.share.VideoInfoService#findById(int)
	 */
    @Override
    public VideoInfoBean findById(int id) {
    	return videoInfoDao.load(id);
    }
    
    /**
	 * 获取列表数据
	 * @see com.group.renshi.service.share.VideoInfoService#listVideoInfo(com.group.renshi.bean.share.VideoInfoBean)
	 */
	@Override
	public List<VideoInfoBean> listVideoInfo(VideoInfoBean videoInfoBean) {
		List<VideoInfoBean> videoInfoList = videoInfoDao.listData(videoInfoBean);
		return videoInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.share.VideoInfoService#pageVideoInfo(com.group.renshi.bean.share.VideoInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<VideoInfoBean> pageVideoInfo(VideoInfoBean videoInfoBean, PageQueryResult<VideoInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(videoInfoDao, videoInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}