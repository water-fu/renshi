package com.group.renshi.bean.share;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 share_follow_active
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: FollowActiveBean.java,v 0.1 2015-06-18 下午04:49:43 Exp $
 */
public class FollowActiveBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 关注编号
	 */
	private Integer followId;

	/**
	 * 账户编号
	 */
	private Integer accountId;

	/**
	 * 关注人编号
	 */
	private Integer followAccount;

	/**
	 * 关注人姓名
	 */
	private java.lang.String followName;

	/**
	 * 关注类型，默认1 1.关注 2.相互关注
	 */
	private Integer followType;

	private String queryCondition; // 查询条件:按关注时间排序 OR 按粉丝数量排序

	private Integer searchtype;// 查询种类（粉丝查询还是关注查询，因为把两个查询写到一起并且记录的名字不是粉丝账户名的缘故）

	public Integer getSearchtype() {
		return searchtype;
	}

	public void setSearchtype(Integer searchtype) {
		this.searchtype = searchtype;
	}

	public void setFollowType(Integer followType) {
		this.followType = followType;
	}

	/**
	 * 构造方法
	 */
	public FollowActiveBean() {
		followId = -1;
		accountId = -1;
		followAccount = -1;
		followName = null;
		followType = -1;
	}

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}

	public Integer getFollowId() {
		return this.followId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setFollowAccount(Integer followAccount) {
		this.followAccount = followAccount;
	}

	public Integer getFollowAccount() {
		return this.followAccount;
	}

	public void setFollowName(java.lang.String followName) {
		this.followName = followName;
	}

	public java.lang.String getFollowName() {
		return this.followName;
	}

	public void setFollowType(int followType) {
		this.followType = followType;
	}

	public Integer getFollowType() {
		return this.followType;
	}
}