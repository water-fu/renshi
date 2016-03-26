package com.group.renshi.service.share.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.share.DiscussInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.service.share.DiscussInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: DiscussInfoServiceImpl.java,v 0.1 2015-06-24 下午11:23:24 Exp $
 */
@Service("discussInfoService")
@Transactional
public class DiscussInfoServiceImpl extends ServiceSupport implements DiscussInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.share.DiscussInfoService#insertDiscussInfo(com.group.renshi.bean.share.DiscussInfoBean)
	 */
	@Override
	public DiscussInfoBean insertDiscussInfo(DiscussInfoBean discussInfoBean) {

		// 更新评论数量
		ShareInfoBean shareInfoBean = shareInfoDao.load(discussInfoBean.getShareId());
		shareInfoBean.setCommentNum(shareInfoBean.getCommentNum() + 1);
		shareInfoDao.update(shareInfoBean);

		// 插入评论表
		discussInfoBean.setDiscussPath("");

		discussInfoDao.insert(discussInfoBean);

		return discussInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.share.DiscussInfoService#deleteDiscussInfo(int)
	 */
	@Override
	public void deleteDiscussInfo(int id) {
		discussInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.share.DiscussInfoService#updateDiscussInfo(com.group.renshi.bean.share.DiscussInfoBean)
	 */
	@Override
	public void updateDiscussInfo(DiscussInfoBean discussInfoBean) {
		DiscussInfoBean discussInfoBeanData = discussInfoDao.load(discussInfoBean.getDiscussId());

		discussInfoDao.update(discussInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.share.DiscussInfoService#findById(int)
	 */
	@Override
	public DiscussInfoBean findById(int id) {
		return discussInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.share.DiscussInfoService#listDiscussInfo(com.group.renshi.bean.share.DiscussInfoBean)
	 */
	@Override
	public List<DiscussInfoBean> listDiscussInfo(DiscussInfoBean discussInfoBean) {
		List<DiscussInfoBean> discussInfoList = discussInfoDao.listData(discussInfoBean);
		return discussInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.share.DiscussInfoService#pageDiscussInfo(com.group.renshi.bean.share.DiscussInfoBean)
	 */
	@Override
	public PageQueryResult<DiscussInfoBean> pageDiscussInfo(DiscussInfoBean discussInfoBean,
			PageQueryResult<DiscussInfoBean> pageQueryResult) {
		// 获取具体javaBean的类名,并且首字母变小写
		String entityName = toFirstCharLower(discussInfoBean.getClass().getSimpleName());
		String pageName = toFirstCharLower(pageQueryResult.getClass().getSimpleName());

		// 封装分页查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put(entityName, discussInfoBean);
		paramMap.put(pageName, pageQueryResult);

		// 查询总记录数
		int totalCount = discussInfoDao.countComment(paramMap);

		List<DiscussInfoBean> userList = new ArrayList<DiscussInfoBean>();
		// 数量大于0,再进行查询数据
		if (totalCount > 0) {
			// 查询数据
			userList = discussInfoDao.pageComment(paramMap);
		}

		// 设置分页查询结果
		pageQueryResult.setList(userList);
		pageQueryResult.setTotalCount(totalCount);

		return pageQueryResult;
	}
}