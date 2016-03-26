package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	share_video_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: VideoInfoBean.java,v 0.1 2015-07-05 ����09:51:39 Exp $
 */
public class VideoInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * ��Ƶ���
     */
    private int shareId;
   	
   	/**
     * ��Ƶ��ַ
     */
    private java.lang.String videoUrl;
    
    /**
     * 构�?方法
     */
    public VideoInfoBean() {
		shareId = -1;
		videoUrl = null;
	}

    
    public void setShareId(int shareId){
        this.shareId = shareId ;
    }

    public int getShareId(){
        return this.shareId ;
    }
    
    public void setVideoUrl(java.lang.String videoUrl){
        this.videoUrl = videoUrl ;
    }

    public java.lang.String getVideoUrl(){
        return this.videoUrl ;
    }
}