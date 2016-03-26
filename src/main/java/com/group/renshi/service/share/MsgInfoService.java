package com.group.renshi.service.share;

import java.util.List;

import com.group.renshi.bean.share.MsgInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MsgInfoService.java,v 0.1 2015-07-27 ����09:31:12 Exp $
 */
public interface MsgInfoService
{
	/**
	 * 插入对象
	 * 
	 * @param msgInfoBean  �?��插入的实体对�?	 * @return 返回插入后带自增长主键的对象
	 */
    MsgInfoBean insertMsgInfo(MsgInfoBean msgInfoBean);
    
    /**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
    void deleteMsgInfo(int id);
    
    /**
	 * 更新对象
	 * 
	 * @param msgInfoBean  �?��更新的实体对�?	 */
    void updateMsgInfo(MsgInfoBean msgInfoBean);
    
    /**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
    MsgInfoBean findById(int id);
    
    /**
	 * 获取列表数据
	 * 
	 * @param msgInfoBean  实体对象
	 * @return   返回列表对象
	 */
    List<MsgInfoBean> listMsgInfo(MsgInfoBean msgInfoBean);
    
    /**
	 * 获取分页数据
	 * 
	 * @param msgInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<MsgInfoBean> pageMsgInfo(MsgInfoBean msgInfoBean, PageQueryResult<MsgInfoBean> pageQueryResult);
}