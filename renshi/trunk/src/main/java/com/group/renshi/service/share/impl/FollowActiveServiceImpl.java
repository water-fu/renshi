package com.group.renshi.service.share.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.share.FollowActiveBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.share.FollowActiveService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.SessionControl;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: FollowActiveServiceImpl.java,v 0.1 2015-06-09 下午08:53:43 Exp $
 */
@Service("followActiveService")
@Transactional
public class FollowActiveServiceImpl extends ServiceSupport implements
		FollowActiveService {
	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.share.FollowActiveService#insertFollowActive(com.group.renshi.bean.share.FollowActiveBean)
	 */
	@Override
	public FollowActiveBean insertFollowActive(FollowActiveBean followActiveBean) {
		followActiveDao.insert(followActiveBean);
		return followActiveBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.share.FollowActiveService#deleteFollowActive(int)
	 */
	@Override
	public void deleteFollowActive(int id) {
		followActiveDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.share.FollowActiveService#updateFollowActive(com.group.renshi.bean.share.FollowActiveBean)
	 */
	@Override
	public void updateFollowActive(FollowActiveBean followActiveBean) {
		FollowActiveBean followActiveBeanData = followActiveDao
				.load(followActiveBean.getFollowId());

		followActiveDao.update(followActiveBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.share.FollowActiveService#findById(int)
	 */
	@Override
	public FollowActiveBean findById(int id) {
		return followActiveDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.share.FollowActiveService#listFollowActive(com.group.renshi.bean.share.FollowActiveBean)
	 */
	@Override
	public List<FollowActiveBean> listFollowActive(
			FollowActiveBean followActiveBean) {
		List<FollowActiveBean> followActiveList = followActiveDao
				.listData(followActiveBean);
		return followActiveList;
	}

	/**
	 * 获取分页数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<Map> pageFollowActive(
			FollowActiveBean followActiveBean,
			PageQueryResult<Map> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(followActiveDao, followActiveBean,
				pageQueryResult);

		List<Map> list = pageQueryResult.getList();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			int accountId = -1;
			if (followActiveBean.getAccountId() != -1) {
				accountId = (Integer) map.get("FOLLOW_ACCOUNT");
			} else {
				accountId = (Integer) map.get("ACCOUNT_ID");
			}
			PersonInfoBean bean = personInfoDao.loadByAccountId(accountId);
			map.put("FOLLOW_NUM", bean.getFollowNum());// 关注数量
			map.put("FANS_NUM", bean.getFansNum());// 粉丝数量
			map.put("BROWER_NUM", bean.getBrowerNum());// 人气数量--浏览数量

			map.put("VIDEO_NUM", bean.getVideoNum());// 视频数量
			map.put("ARTICLE_NUM", bean.getArticleNum());// 文章数量
			map.put("CASE_NUM", bean.getCaseNum());// 病例数量
			map.put("COURSE_NUM", bean.getCourseNum());// 文件数量--课件数量
			map.put("QA_NUM", bean.getQaNum());// 会议数量--提问数量

			UserInfoBean userInfoBean = userInfoDao.load(accountId);
			map.put("HEAD_URL", userInfoBean.getHeadUrl());
		}
		return pageQueryResult;
	}

	// /**
	// * 在我的关注列表或者他的关注列表里 根据名字进行简单的模糊查询
	// *
	// * 作者 ：金天阳
	// *
	// * userInfoList 根据名字查找所有符合条件的用户 followList 我关注的用户列表 * @see
	// * com.group.renshi.service.share.FollowActiveService
	// * #searchMyConcern(java.lang.String, java.util.List)
	// */
	// @Override
	// public List<Map> searchMyConcernAndFans(List<Map> followList,
	// List<UserInfoBean> userInfolist, String isFansOrConcern) {
	// // 首先根据用户名 查找整个用户表 如果followList里的被关注或者的人（FOLLOW_ACCOUNT）在结果中 那就add进List里
	// // 返回符合条件的List
	// List<Map> newList = new ArrayList<Map>();
	// if (followList != null && !followList.isEmpty()
	// && userInfolist != null && !userInfolist.isEmpty()) {
	//
	// for (int i = 0; i < followList.size(); i++)
	// {
	// Map<String, Object> map = followList.get(i);
	// for (UserInfoBean userInfo : userInfolist) {
	//
	// if ("concern".equals(isFansOrConcern)
	// && userInfo.getAccountId() == (Integer) map.get("FOLLOW_ACCOUNT"))
	// newList.add(map);
	// else if ("fans".equals(isFansOrConcern)
	// && userInfo.getAccountId() == (Integer) map.get("ACCOUNT_ID"))
	// newList.add(map);
	// }
	// }
	// }
	// return newList;
	// }
	/**
	 * 简单的模糊查询 修改SQL版本
	 * 
	 * @see com.group.renshi.service.share.FollowActiveService#pageFollowActiveWithName(com.group.renshi.bean.share.FollowActiveBean,
	 *      com.group.webFramework.uitl.PageQueryResult, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<Map> pageFollowActiveWithName(FollowActiveBean followActiveBean,
			PageQueryResult<Map> pageQueryResult, String name,
			HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", name);
		// if (SessionControl.getCurUserDetail(request) == null) {
		// paramMap.put("curAccountId", followActiveBean.getAccountId());
		// } else {
		// paramMap.put("curAccountId", SessionControl.getOpId(request));
		// }
		pageQueryResult = this.pageDataUtil(followActiveDao, followActiveBean,
				pageQueryResult, paramMap);

		List<Map> list = pageQueryResult.getList();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			int accountId = -1;
			if (followActiveBean.getAccountId() != -1) {
				accountId = (Integer) map.get("FOLLOW_ACCOUNT");
			} else {
				accountId = (Integer) map.get("ACCOUNT_ID");
			}
			PersonInfoBean bean = personInfoDao.loadByAccountId(accountId);
			map.put("FOLLOW_NUM", bean.getFollowNum());// 关注数量
			map.put("FANS_NUM", bean.getFansNum());// 粉丝数量
			map.put("BROWER_NUM", bean.getBrowerNum());// 人气数量--浏览数量

			map.put("VIDEO_NUM", bean.getVideoNum());// 视频数量
			map.put("ARTICLE_NUM", bean.getArticleNum());// 文章数量
			map.put("CASE_NUM", bean.getCaseNum());// 病例数量
			map.put("COURSE_NUM", bean.getCourseNum());// 文件数量--课件数量
			map.put("QA_NUM", bean.getQaNum());// 会议数量--提问数量

			UserInfoBean userInfoBean = userInfoDao.load(accountId);
			map.put("HEAD_URL", userInfoBean.getHeadUrl());
		}
		return pageQueryResult;
	}
	/**
	 * 关注
	 */
	@Override
	public void followActive(HttpServletRequest request, int accountId) {
		UserInfoBean userInfoBean = userInfoDao.load(accountId);

		// 校验是否已经关注
		FollowActiveBean followActiveBeanCond = new FollowActiveBean();
		followActiveBeanCond.setAccountId(SessionControl.getOpId(request));
		followActiveBeanCond.setFollowAccount(accountId);

		List<FollowActiveBean> list = followActiveDao
				.listData(followActiveBeanCond);
		if (!CollectionUtils.isEmpty(list)) {
			throw new ApplicationException("用户已关注");
		}

		// 插入关注数据
		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setFollowAccount(accountId);
		followActiveBean.setFollowName(userInfoBean.getRealName());

		followActiveBean.setAccountId(SessionControl.getOpId(request));

		// 判断他是否已经关注我了
		followActiveBeanCond = new FollowActiveBean();
		followActiveBeanCond.setFollowAccount(SessionControl.getOpId(request));
		followActiveBeanCond.setAccountId(accountId);

		list = followActiveDao.listData(followActiveBeanCond);
		// 如果没有关注，则类型为单向关注
		if (CollectionUtils.isEmpty(list)) {
			followActiveBean.setFollowType(SystemConstantType.FOLLOW_TYPE_ONE);
		}
		// 如果已经关注了，则类型为相互关注
		else {
			followActiveBean.setFollowType(SystemConstantType.FOLLOW_TYPE_TWO);

			// 需要更新他关注我的记录的状态
			FollowActiveBean followActiveBeanData = list.get(0);
			followActiveBeanData
					.setFollowType(SystemConstantType.FOLLOW_TYPE_TWO);

			followActiveDao.update(followActiveBeanData);
		}

		// 插入关注表
		followActiveDao.insert(followActiveBean);

		// 我的的关注数量+1
		PersonInfoBean personInfoBeanCond = new PersonInfoBean();
		personInfoBeanCond.setAccountId(SessionControl.getOpId(request));

		PersonInfoBean personInfoBean = personInfoDao.listData(
				personInfoBeanCond).get(0);
		personInfoBean.setFollowNum(personInfoBean.getFollowNum() + 1);

		personInfoDao.update(personInfoBean);

		// 被关注的用户的粉丝数量+1
		personInfoBeanCond.setAccountId(accountId);

		PersonInfoBean personInfoBean2 = personInfoDao.listData(
				personInfoBeanCond).get(0);
		personInfoBean2.setFansNum(personInfoBean2.getFansNum() + 1);

		personInfoDao.update(personInfoBean2);
	}

	/**
	 * 取消关注
	 * 
	 * @see com.group.renshi.service.share.FollowActiveService#unFollowActive(javax.servlet.http.HttpServletRequest,
	 *      int)
	 */
	@Override
	public void unFollowActive(HttpServletRequest request, int accountId) {
		// 校验是否已经关注
		FollowActiveBean followActiveBeanCond = new FollowActiveBean();
		followActiveBeanCond.setFollowAccount(accountId);
		followActiveBeanCond.setAccountId(SessionControl.getOpId(request));

		List<FollowActiveBean> list = followActiveDao
				.listData(followActiveBeanCond);
		if (CollectionUtils.isEmpty(list)) {
			throw new ApplicationException("用户未关注");
		}

		// 判断他是否已经关注我了
		followActiveBeanCond = new FollowActiveBean();
		followActiveBeanCond.setFollowAccount(SessionControl.getOpId(request));
		followActiveBeanCond.setAccountId(accountId);

		List<FollowActiveBean> condList = followActiveDao
				.listData(followActiveBeanCond);
		// 如果关注我了，则把类型修改为单向关注
		if (!CollectionUtils.isEmpty(condList)) {
			FollowActiveBean followActiveBean = condList.get(0);
			followActiveBean.setFollowType(SystemConstantType.FOLLOW_TYPE_ONE);

			followActiveDao.update(followActiveBean);
		}

		// 删除关注
		followActiveDao.delete(list.get(0).getFollowId());

		// 我的的关注数量-1
		PersonInfoBean personInfoBeanCond = new PersonInfoBean();
		personInfoBeanCond.setAccountId(SessionControl.getOpId(request));

		PersonInfoBean personInfoBean = personInfoDao.listData(
				personInfoBeanCond).get(0);
		personInfoBean.setFollowNum(personInfoBean.getFollowNum() - 1);

		personInfoDao.update(personInfoBean);

		// 被关注的用户的粉丝数量-1
		personInfoBeanCond.setAccountId(accountId);

		PersonInfoBean personInfoBean2 = personInfoDao.listData(
				personInfoBeanCond).get(0);
		personInfoBean2.setFansNum(personInfoBean2.getFansNum() - 1);

		personInfoDao.update(personInfoBean2);
	}

	/**
	 * 校验是否关注
	 * 
	 * @see com.group.renshi.service.share.FollowActiveService#isFollowActive(javax.servlet.http.HttpServletRequest,
	 *      int)
	 */
	@Override
	public boolean isFollowActive(HttpServletRequest request, int accountId) {
		// 校验是否已经关注
		FollowActiveBean followActiveBeanCond = new FollowActiveBean();
		followActiveBeanCond.setFollowAccount(accountId);
		followActiveBeanCond.setAccountId(SessionControl.getOpId(request));

		List<FollowActiveBean> list = followActiveDao
				.listData(followActiveBeanCond);
		// 不为空,则为关注
		if (!CollectionUtils.isEmpty(list)) {
			return true;
		}

		return false;
	}

}