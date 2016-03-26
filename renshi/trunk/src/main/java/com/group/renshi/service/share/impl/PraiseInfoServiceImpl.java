package com.group.renshi.service.share.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.group.renshi.bean.share.PraiseInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.service.share.PraiseInfoService;
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
 * @version $Id: PraiseInfoServiceImpl.java,v 0.1 2015-06-23 下午08:20:07 Exp $
 */
@Service("praiseInfoService")
@Transactional
public class PraiseInfoServiceImpl extends ServiceSupport implements
		PraiseInfoService {

	/**
	 * 点赞记录插入
	 * 
	 * @see com.group.renshi.service.share.PraiseInfoService#insertPraiseInfo(com.group.renshi.bean.share.PraiseInfoBean)
	 */
	@Override
	public PraiseInfoBean insertPraiseInfo(PraiseInfoBean praiseInfoBean) {

		praiseInfoBean.setIsRead(0);
		praiseInfoDao.insert(praiseInfoBean);

		// 更新分享表中like_num+1
		ShareInfoBean shareInfoBean = shareInfoDao.load(praiseInfoBean
				.getShareId());
		shareInfoBean.setLikeNum(shareInfoBean.getLikeNum() + 1);

		shareInfoDao.update(shareInfoBean);

		return praiseInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.share.PraiseInfoService#deletePraiseInfo(int)
	 */
	@Override
	public void deletePraiseInfo(PraiseInfoBean praiseInfoBean) {

		List<PraiseInfoBean> list = praiseInfoDao.listData(praiseInfoBean);
		if (!CollectionUtils.isEmpty(list)) {
			praiseInfoBean = list.get(0);

			// 删除点赞记录
			praiseInfoDao.delete(praiseInfoBean.getPraiseId());

			// 更新分享表中like_num-1

			ShareInfoBean shareInfoBean = shareInfoDao.load(praiseInfoBean
					.getShareId());
			shareInfoBean.setLikeNum(shareInfoBean.getLikeNum() - 1);

			shareInfoDao.update(shareInfoBean);

		}
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.share.PraiseInfoService#updatePraiseInfo(com.group.renshi.bean.share.PraiseInfoBean)
	 */
	@Override
	public void updatePraiseInfo(PraiseInfoBean praiseInfoBean) {
		PraiseInfoBean praiseInfoBeanData = praiseInfoDao.load(praiseInfoBean
				.getPraiseId());

		praiseInfoDao.update(praiseInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.share.PraiseInfoService#findById(int)
	 */
	@Override
	public PraiseInfoBean findById(int id) {
		return praiseInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.share.PraiseInfoService#listPraiseInfo(com.group.renshi.bean.share.PraiseInfoBean)
	 */
	@Override
	public List<PraiseInfoBean> listPraiseInfo(PraiseInfoBean praiseInfoBean) {
		List<PraiseInfoBean> praiseInfoList = praiseInfoDao
				.listData(praiseInfoBean);
		return praiseInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.share.PraiseInfoService#pagePraiseInfo(com.group.renshi.bean.share.PraiseInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<ShareInfoBean> pagePraiseInfo(
			PraiseInfoBean praiseInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(praiseInfoDao, praiseInfoBean,
				pageQueryResult);

		return pageQueryResult;
	}
}