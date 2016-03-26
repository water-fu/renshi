package com.group.renshi.service.share;

import java.util.List;

import com.group.renshi.bean.share.VideoInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: VideoInfoService.java,v 0.1 2015-07-05 ����09:51:39 Exp $
 */
public interface VideoInfoService
{
	/**
	 * 插入对象
	 * 
	 * @param videoInfoBean  �?��插入的实体对�?	 * @return 返回插入后带自增长主键的对象
	 */
    VideoInfoBean insertVideoInfo(VideoInfoBean videoInfoBean);
    
    /**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
    void deleteVideoInfo(int id);
    
    /**
	 * 更新对象
	 * 
	 * @param videoInfoBean  �?��更新的实体对�?	 */
    void updateVideoInfo(VideoInfoBean videoInfoBean);
    
    /**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
    VideoInfoBean findById(int id);
    
    /**
	 * 获取列表数据
	 * 
	 * @param videoInfoBean  实体对象
	 * @return   返回列表对象
	 */
    List<VideoInfoBean> listVideoInfo(VideoInfoBean videoInfoBean);
    
    /**
	 * 获取分页数据
	 * 
	 * @param videoInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<VideoInfoBean> pageVideoInfo(VideoInfoBean videoInfoBean, PageQueryResult<VideoInfoBean> pageQueryResult);
}