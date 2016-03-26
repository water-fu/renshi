package com.group.renshi.service.qa.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.qa.CommentBean;
import com.group.renshi.service.qa.CommentService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: CommentServiceImpl.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl extends ServiceSupport implements CommentService {
	/**
	 * 插入对象
	 * @see CommentService#insertComment(CommentBean)
	 */
	@Override
	public CommentBean insertComment(CommentBean commentBean) {
		commentDao.insert(commentBean);
		return commentBean;
	}

	/**
	 * 删除对象
	 * @see CommentService#deleteComment(int)
	 */
	@Override
	public void deleteComment(int id) {
		commentDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see CommentService#updateComment(CommentBean)
	 */
	@Override
	public void updateComment(CommentBean commentBean) {
		CommentBean commentBeanData = commentDao.load(commentBean.getId());

		commentDao.update(commentBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see CommentService#findById(int)
	 */
	@Override
	public CommentBean findById(int id) {
		return commentDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see CommentService#listComment(CommentBean)
	 */
	@Override
	public List<CommentBean> listComment(CommentBean commentBean) {
		List<CommentBean> commentList = commentDao.listData(commentBean);
		return commentList;
	}

	/**
	 * 获取分页数据
	 * @see CommentService#pageComment(CommentBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<CommentBean> pageComment(CommentBean commentBean,
			PageQueryResult<CommentBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(commentDao, commentBean, pageQueryResult);

		return pageQueryResult;
	}
}