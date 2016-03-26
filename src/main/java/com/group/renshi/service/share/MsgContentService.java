package com.group.renshi.service.share;

import java.util.List;

import com.group.renshi.bean.share.MsgContentBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MsgContentService.java,v 0.1 2015-07-27 ����09:31:12 Exp $
 */
public interface MsgContentService
{
	/**
	 * 插入对象
	 * 
	 * @param msgContentBean  �?��插入的实体对�?	 * @return 返回插入后带自增长主键的对象
	 */
    MsgContentBean insertMsgContent(MsgContentBean msgContentBean);
    
    /**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
    void deleteMsgContent(int id);
    
    /**
	 * 更新对象
	 * 
	 * @param msgContentBean  �?��更新的实体对�?	 */
    void updateMsgContent(MsgContentBean msgContentBean);
    
    /**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
    MsgContentBean findById(int id);
    
    /**
	 * 获取列表数据
	 * 
	 * @param msgContentBean  实体对象
	 * @return   返回列表对象
	 */
    List<MsgContentBean> listMsgContent(MsgContentBean msgContentBean);
    
    /**
	 * 获取分页数据
	 * 
	 * @param msgContentBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<MsgContentBean> pageMsgContent(MsgContentBean msgContentBean, PageQueryResult<MsgContentBean> pageQueryResult);
}