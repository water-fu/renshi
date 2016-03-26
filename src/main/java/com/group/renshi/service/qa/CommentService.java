package com.group.renshi.service.qa;

import java.util.List;

import com.group.renshi.bean.qa.CommentBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: CommentService.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
public interface CommentService {
	/**
	 * 插入对象
	 * 
	 * @param commentBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	CommentBean insertComment(CommentBean commentBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteComment(int id);

	/**
	 * 更新对象
	 * 
	 * @param commentBean  需要更新的实体对象
	 */
	void updateComment(CommentBean commentBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	CommentBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param commentBean  实体对象
	 * @return   返回列表对象
	 */
	List<CommentBean> listComment(CommentBean commentBean);

	/**
	 * 获取分页数据
	 * 
	 * @param commentBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<CommentBean> pageComment(CommentBean commentBean,
			PageQueryResult<CommentBean> pageQueryResult);
}