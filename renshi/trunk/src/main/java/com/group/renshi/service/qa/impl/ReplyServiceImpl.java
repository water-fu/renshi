package com.group.renshi.service.qa.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.qa.ReplyBean;
import com.group.renshi.service.qa.ReplyService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ReplyServiceImpl.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
@Service("replyService")
@Transactional
public class ReplyServiceImpl extends ServiceSupport implements ReplyService {
	/**
	 * 插入对象
	 * @see ReplyService#insertReply(ReplyBean)
	 */
	@Override
	public ReplyBean insertReply(ReplyBean replyBean) {
		replyDao.insert(replyBean);
		return replyBean;
	}

	/**
	 * 删除对象
	 * @see ReplyService#deleteReply(int)
	 */
	@Override
	public void deleteReply(int id) {
		replyDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see ReplyService#updateReply(ReplyBean)
	 */
	@Override
	public void updateReply(ReplyBean replyBean) {
		ReplyBean replyBeanData = replyDao.load(replyBean.getId());

		replyDao.update(replyBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see ReplyService#findById(int)
	 */
	@Override
	public ReplyBean findById(int id) {
		return replyDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see ReplyService#listReply(ReplyBean)
	 */
	@Override
	public List<ReplyBean> listReply(ReplyBean replyBean) {
		List<ReplyBean> replyList = replyDao.listData(replyBean);
		return replyList;
	}

	/**
	 * 获取分页数据
	 * @see ReplyService#pageReply(ReplyBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<ReplyBean> pageReply(ReplyBean replyBean,
			PageQueryResult<ReplyBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(replyDao, replyBean, pageQueryResult);

		return pageQueryResult;
	}
}