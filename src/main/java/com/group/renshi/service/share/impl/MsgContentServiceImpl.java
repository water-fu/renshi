package com.group.renshi.service.share.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.share.MsgContentBean;
import com.group.renshi.bean.share.MsgInfoBean;
import com.group.renshi.service.share.MsgContentService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: MsgContentServiceImpl.java,v 0.1 2015-07-27 ����09:31:12 Exp $
 */
@Service("msgContentService")
@Transactional
public class MsgContentServiceImpl extends ServiceSupport implements
		MsgContentService {
	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.share.MsgContentService#insertMsgContent(com.group.renshi.bean.share.MsgContentBean)
	 */
	@Override
	public MsgContentBean insertMsgContent(MsgContentBean msgContentBean) {
		msgContentDao.insert(msgContentBean);

		MsgInfoBean msgInfoBean = msgInfoDao.load(msgContentBean.getMsgId());
		msgInfoBean.setMsgContent(msgContentBean.getMsgContent());

		msgInfoDao.update(msgInfoBean);

		return msgContentBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.share.MsgContentService#deleteMsgContent(int)
	 */
	@Override
	public void deleteMsgContent(int id) {
		msgContentDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.share.MsgContentService#updateMsgContent(com.group.renshi.bean.share.MsgContentBean)
	 */
	@Override
	public void updateMsgContent(MsgContentBean msgContentBean) {
		MsgContentBean msgContentBeanData = msgContentDao.load(msgContentBean
				.getContentId());

		msgContentDao.update(msgContentBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.share.MsgContentService#findById(int)
	 */
	@Override
	public MsgContentBean findById(int id) {
		return msgContentDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.share.MsgContentService#listMsgContent(com.group.renshi.bean.share.MsgContentBean)
	 */
	@Override
	public List<MsgContentBean> listMsgContent(MsgContentBean msgContentBean) {
		PageQueryResult<MsgContentBean> pageQueryResult = new PageQueryResult<MsgContentBean>();

		List<MsgContentBean> msgContentList = msgContentDao
				.listData(msgContentBean);
		return msgContentList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.share.MsgContentService#pageMsgContent(com.group.renshi.bean.share.MsgContentBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<MsgContentBean> pageMsgContent(
			MsgContentBean msgContentBean,
			PageQueryResult<MsgContentBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(msgContentDao, msgContentBean,
				pageQueryResult);

		return pageQueryResult;
	}
}