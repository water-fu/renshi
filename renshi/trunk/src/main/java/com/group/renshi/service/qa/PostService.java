package com.group.renshi.service.qa;

import java.util.List;

import com.group.renshi.bean.qa.PostBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PostService.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
public interface PostService {
	/**
	 * 插入对象
	 * 
	 * @param postBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	PostBean insertPost(PostBean postBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deletePost(int id);

	/**
	 * 更新对象
	 * 
	 * @param postBean  需要更新的实体对象
	 */
	void updatePost(PostBean postBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	PostBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param postBean  实体对象
	 * @return   返回列表对象
	 */
	List<PostBean> listPost(PostBean postBean);

	/**
	 * 获取分页数据
	 * 
	 * @param postBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<PostBean> pagePost(PostBean postBean, PageQueryResult<PostBean> pageQueryResult);
}