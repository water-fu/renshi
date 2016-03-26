package com.group.renshi.service.share.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.group.renshi.bean.share.CollectionInfoBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.service.share.CollectionInfoService;
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
 * @version $Id: CollectionInfoServiceImpl.java,v 0.1 2015-06-23 下午09:56:44 Exp
 *          $
 */
@Service("collectionInfoService")
@Transactional
public class CollectionInfoServiceImpl extends ServiceSupport implements CollectionInfoService {

	/**
	 * 收藏
	 * 
	 * @see com.group.renshi.service.share.CollectionInfoService#insertCollectionInfo(com.group.renshi.bean.share.CollectionInfoBean)
	 */
	@Override
	public CollectionInfoBean insertCollectionInfo(CollectionInfoBean collectionInfoBean) {

		// 插入收藏表
		collectionInfoBean.setIsRead(0);

		collectionInfoDao.insert(collectionInfoBean);

		// 更新分享数据的收藏数量+1
		ShareInfoBean shareInfoBean = shareInfoDao.load(collectionInfoBean.getShareId());
		shareInfoBean.setCollectionNum(shareInfoBean.getCollectionNum() + 1);

		shareInfoDao.update(shareInfoBean);

		// 更新当前用户的收藏数量+1
		PersonInfoBean personInfoBean = new PersonInfoBean();
		personInfoBean.setAccountId(collectionInfoBean.getAccountId());
		List<PersonInfoBean> list = personInfoDao.listData(personInfoBean);

		personInfoBean = list.get(0);

		personInfoBean.setCollectionNum(personInfoBean.getCollectionNum() + 1);

		personInfoDao.update(personInfoBean);

		return collectionInfoBean;
	}

	/**
	 * 取消收藏
	 * 
	 * @see com.group.renshi.service.share.CollectionInfoService#deleteCollectionInfo(int)
	 */
	@Override
	public void deleteCollectionInfo(CollectionInfoBean collectionInfoBean) {
		List<CollectionInfoBean> list = collectionInfoDao.listData(collectionInfoBean);
		if (!CollectionUtils.isEmpty(list)) {
			// 收藏对象
			collectionInfoBean = list.get(0);

			// 根据主键删除收藏对象
			collectionInfoDao.delete(collectionInfoBean.getCollectionId());

			// 更新分享数据的收藏数量-1
			ShareInfoBean shareInfoBean = shareInfoDao.load(collectionInfoBean.getShareId());
			shareInfoBean.setCollectionNum(shareInfoBean.getCollectionNum() - 1);

			shareInfoDao.update(shareInfoBean);

			// 更新当前用户的收藏数量-1
			PersonInfoBean personInfoBean = new PersonInfoBean();
			personInfoBean.setAccountId(collectionInfoBean.getAccountId());
			List<PersonInfoBean> personList = personInfoDao.listData(personInfoBean);

			personInfoBean = personList.get(0);

			personInfoBean.setCollectionNum(personInfoBean.getCollectionNum() - 1);

			personInfoDao.update(personInfoBean);
		}

	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.share.CollectionInfoService#updateCollectionInfo(com.group.renshi.bean.share.CollectionInfoBean)
	 */
	@Override
	public void updateCollectionInfo(CollectionInfoBean collectionInfoBean) {
		CollectionInfoBean collectionInfoBeanData = collectionInfoDao.load(collectionInfoBean
				.getCollectionId());

		collectionInfoDao.update(collectionInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.share.CollectionInfoService#findById(int)
	 */
	@Override
	public CollectionInfoBean findById(int id) {
		return collectionInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.share.CollectionInfoService#listCollectionInfo(com.group.renshi.bean.share.CollectionInfoBean)
	 */
	@Override
	public List<CollectionInfoBean> listCollectionInfo(CollectionInfoBean collectionInfoBean) {
		List<CollectionInfoBean> collectionInfoList = collectionInfoDao
				.listData(collectionInfoBean);
		return collectionInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.share.CollectionInfoService#pageCollectionInfo(com.group.renshi.bean.share.CollectionInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<ShareInfoBean> pageCollectionInfo(CollectionInfoBean collectionInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult) {

		pageQueryResult = this.pageDataUtil(collectionInfoDao, collectionInfoBean, pageQueryResult);

		return pageQueryResult;
	}

	/**
	 * 根据标题搜索 收藏记录
	 * 
	 * @see com.group.renshi.service.share.CollectionInfoService#pageCollectionSearch(com.group.renshi.bean.share.CollectionInfoBean,
	 *      com.group.webFramework.uitl.PageQueryResult, java.lang.String,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<ShareInfoBean> pageCollectionSearch(CollectionInfoBean collectionInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult, String collectTitle,
			HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if ("".equals(collectTitle.trim()))
			paramMap.put("collectTitle", null);
		else
			paramMap.put("collectTitle", collectTitle);
		pageQueryResult = this.pageDataUtil(collectionInfoDao, collectionInfoBean,
				pageQueryResult, paramMap);
		return pageQueryResult;
	}
}