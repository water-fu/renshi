package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * æ€»ä½“è¯´æ˜Ž
 *	share_video_info
 *
 * <p>å…·ä½“è¯´æ˜Ž</p>
 *
 * @author Administrator
 * @version $Id: VideoInfoBean.java,v 0.1 2015-07-05 ÏÂÎç09:51:39 Exp $
 */
public class VideoInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
   	
   	/**
     * ÊÓÆµ±àºÅ
     */
    private int shareId;
   	
   	/**
     * ÊÓÆµµØÖ·
     */
    private java.lang.String videoUrl;
    
    /**
     * æž„é?æ–¹æ³•
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