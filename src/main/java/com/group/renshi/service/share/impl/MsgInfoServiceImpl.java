package com.group.renshi.service.share.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.share.MsgInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.service.share.MsgInfoService;
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
 * @version $Id: MsgInfoServiceImpl.java,v 0.1 2015-07-27 ����09:31:12 Exp $
 */
@Service("msgInfoService")
@Transactional
public class MsgInfoServiceImpl extends ServiceSupport implements
		MsgInfoService {
	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.share.MsgInfoService#insertMsgInfo(com.group.renshi.bean.share.MsgInfoBean)
	 */
	@Override
	public MsgInfoBean insertMsgInfo(MsgInfoBean msgInfoBean) {
		msgInfoBean.setSendDate(new Date());
		msgInfoBean.setMsgCount(0);
		msgInfoBean.setMsgdedCount(0);

		msgInfoDao.insert(msgInfoBean);
		return msgInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.share.MsgInfoService#deleteMsgInfo(int)
	 */
	@Override
	public void deleteMsgInfo(int id) {
		msgInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.share.MsgInfoService#updateMsgInfo(com.group.renshi.bean.share.MsgInfoBean)
	 */
	@Override
	public void updateMsgInfo(MsgInfoBean msgInfoBean) {
		MsgInfoBean msgInfoBeanData = msgInfoDao.load(msgInfoBean.getMsgId());

		msgInfoDao.update(msgInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.share.MsgInfoService#findById(int)
	 */
	@Override
	public MsgInfoBean findById(int id) {
		return msgInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.share.MsgInfoService#listMsgInfo(com.group.renshi.bean.share.MsgInfoBean)
	 */
	@Override
	public List<MsgInfoBean> listMsgInfo(MsgInfoBean msgInfoBean) {
		List<MsgInfoBean> msgInfoList = msgInfoDao.listData(msgInfoBean);
		return msgInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.share.MsgInfoService#pageMsgInfo(com.group.renshi.bean.share.MsgInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<MsgInfoBean> pageMsgInfo(MsgInfoBean msgInfoBean,
			PageQueryResult<MsgInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(msgInfoDao, msgInfoBean,
				pageQueryResult);

		List<MsgInfoBean> list = pageQueryResult.getList();
		for (MsgInfoBean msgInfoBeanData : list) {
			if (msgInfoBeanData.getAccountId() == msgInfoBean.getAccountId()) {

				AccountInfoBean accountInfoBean = accountInfoDao
						.load(msgInfoBeanData.getAccountedId());
				msgInfoBeanData.setHeadUrl(accountInfoBean.getHeadUrl());

				UserInfoBean userInfoBean = userInfoDao.load(msgInfoBeanData
						.getAccountedId());
				msgInfoBeanData.setRealName(userInfoBean.getRealName());

				msgInfoBeanData.setCreateUser(userInfoBean.getAccountId());

			} else if (msgInfoBeanData.getAccountedId() == msgInfoBean
					.getAccountId()) {

				AccountInfoBean accountInfoBean = accountInfoDao
						.load(msgInfoBeanData.getAccountId());
				msgInfoBeanData.setHeadUrl(accountInfoBean.getHeadUrl());

				UserInfoBean userInfoBean = userInfoDao.load(msgInfoBeanData
						.getAccountId());
				msgInfoBeanData.setRealName(userInfoBean.getRealName());

				msgInfoBeanData.setCreateUser(userInfoBean.getAccountId());
			}
		}

		return pageQueryResult;
	}
}