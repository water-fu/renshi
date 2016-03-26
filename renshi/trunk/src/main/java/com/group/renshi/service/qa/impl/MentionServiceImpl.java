package com.group.renshi.service.qa.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.qa.MentionBean;
import com.group.renshi.service.qa.MentionService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MentionServiceImpl.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
@Service("mentionService")
@Transactional
public class MentionServiceImpl extends ServiceSupport implements MentionService {
	/**
	 * 插入对象
	 * @see MentionService#insertMention(MentionBean)
	 */
	@Override
	public MentionBean insertMention(MentionBean mentionBean) {
		mentionDao.insert(mentionBean);
		return mentionBean;
	}

	/**
	 * 删除对象
	 * @see MentionService#deleteMention(int)
	 */
	@Override
	public void deleteMention(int id) {
		mentionDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see MentionService#updateMention(MentionBean)
	 */
	@Override
	public void updateMention(MentionBean mentionBean) {
		MentionBean mentionBeanData = mentionDao.load(mentionBean.getId());

		mentionDao.update(mentionBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see MentionService#findById(int)
	 */
	@Override
	public MentionBean findById(int id) {
		return mentionDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see MentionService#listMention(MentionBean)
	 */
	@Override
	public List<MentionBean> listMention(MentionBean mentionBean) {
		List<MentionBean> mentionList = mentionDao.listData(mentionBean);
		return mentionList;
	}

	/**
	 * 获取分页数据
	 * @see MentionService#pageMention(MentionBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<MentionBean> pageMention(MentionBean mentionBean,
			PageQueryResult<MentionBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(mentionDao, mentionBean, pageQueryResult);

		return pageQueryResult;
	}
}