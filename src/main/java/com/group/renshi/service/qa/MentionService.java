package com.group.renshi.service.qa;

import java.util.List;

import com.group.renshi.bean.qa.MentionBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MentionService.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
public interface MentionService {
	/**
	 * 插入对象
	 * 
	 * @param mentionBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	MentionBean insertMention(MentionBean mentionBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteMention(int id);

	/**
	 * 更新对象
	 * 
	 * @param mentionBean  需要更新的实体对象
	 */
	void updateMention(MentionBean mentionBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	MentionBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param mentionBean  实体对象
	 * @return   返回列表对象
	 */
	List<MentionBean> listMention(MentionBean mentionBean);

	/**
	 * 获取分页数据
	 * 
	 * @param mentionBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<MentionBean> pageMention(MentionBean mentionBean,
			PageQueryResult<MentionBean> pageQueryResult);
}