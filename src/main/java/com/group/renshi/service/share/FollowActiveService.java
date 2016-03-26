package com.group.renshi.service.share;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.group.renshi.bean.share.FollowActiveBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: FollowActiveService.java,v 0.1 2015-06-09 下午08:53:43 Exp $
 */
public interface FollowActiveService {
	/**
	 * 插入对象
	 * 
	 * @param followActiveBean
	 *            需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	FollowActiveBean insertFollowActive(FollowActiveBean followActiveBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键编号
	 */
	void deleteFollowActive(int id);

	/**
	 * 更新对象
	 * 
	 * @param followActiveBean
	 *            需要更新的实体对象
	 */
	void updateFollowActive(FollowActiveBean followActiveBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id
	 *            主键编号
	 * @return 返回实体对象
	 */
	FollowActiveBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param followActiveBean
	 *            实体对象
	 * @return 返回列表对象
	 */
	List<FollowActiveBean> listFollowActive(FollowActiveBean followActiveBean);

	/**
	 * 获取分页数据
	 * 
	 * @param followActiveBean
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @return 返回分页对象
	 */
	PageQueryResult<Map> pageFollowActive(FollowActiveBean followActiveBean, PageQueryResult<Map> pageQueryResult);

	/**
	 * 关注
	 * 
	 * @param accountId
	 */
	void followActive(HttpServletRequest request, int accountId);

	/**
	 * 校验是否关注
	 * 
	 * @param request
	 * @param accountId
	 * @return
	 */
	boolean isFollowActive(HttpServletRequest request, int accountId);

	/**
	 * 取消关注
	 * 
	 * @param request
	 * @param accountId
	 */
	void unFollowActive(HttpServletRequest request, int accountId);

	// /**
	// *
	// * @param followList
	// * @param userInfolist
	// * @return
	// */
	// List<Map> searchMyConcernAndFans(List<Map> followList,
	// List<UserInfoBean> userInfolist, String isFansOrConcern);

	/**
	 * 
	 * @param followActiveBean
	 * @param pageQueryResult
	 * @param concernName
	 * @param request
	 * @return
	 */
	PageQueryResult<Map> pageFollowActiveWithName(FollowActiveBean followActiveBean,
			PageQueryResult<Map> pageQueryResult, String Name, HttpServletRequest request);
}