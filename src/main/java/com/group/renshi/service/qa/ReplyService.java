package com.group.renshi.service.qa;

import java.util.List;

import com.group.renshi.bean.qa.ReplyBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ReplyService.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
public interface ReplyService {
	/**
	 * 插入对象
	 * 
	 * @param replyBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	ReplyBean insertReply(ReplyBean replyBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteReply(int id);

	/**
	 * 更新对象
	 * 
	 * @param replyBean  需要更新的实体对象
	 */
	void updateReply(ReplyBean replyBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	ReplyBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param replyBean  实体对象
	 * @return   返回列表对象
	 */
	List<ReplyBean> listReply(ReplyBean replyBean);

	/**
	 * 获取分页数据
	 * 
	 * @param replyBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<ReplyBean> pageReply(ReplyBean replyBean,
			PageQueryResult<ReplyBean> pageQueryResult);
}