package com.group.renshi.service.qa.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.qa.PostBean;
import com.group.renshi.service.qa.PostService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PostServiceImpl.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
@Service("postService")
@Transactional
public class PostServiceImpl extends ServiceSupport implements PostService {
	/**
	 * 插入对象
	 * @see PostService#insertPost(PostBean)
	 */
	@Override
	public PostBean insertPost(PostBean postBean) {
		postDao.insert(postBean);
		return postBean;
	}

	/**
	 * 删除对象
	 * @see PostService#deletePost(int)
	 */
	@Override
	public void deletePost(int id) {
		postDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see PostService#updatePost(PostBean)
	 */
	@Override
	public void updatePost(PostBean postBean) {
		PostBean postBeanData = postDao.load(postBean.getId());

		postDao.update(postBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see PostService#findById(int)
	 */
	@Override
	public PostBean findById(int id) {
		return postDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see PostService#listPost(PostBean)
	 */
	@Override
	public List<PostBean> listPost(PostBean postBean) {
		List<PostBean> postList = postDao.listData(postBean);
		return postList;
	}

	/**
	 * 获取分页数据
	 * @see PostService#pagePost(PostBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<PostBean> pagePost(PostBean postBean,
			PageQueryResult<PostBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(postDao, postBean, pageQueryResult);

		return pageQueryResult;
	}
}