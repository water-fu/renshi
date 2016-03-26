package com.group.renshi.bean.share;

import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明
 *	share_person_info
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PersonInfoBean.java,v 0.1 2015-06-09 下午10:27:53 Exp $
 */
public class PersonInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 空间编号
	 */
	private int personId;

	/**
	 * 用户编号
	 */
	private int accountId;

	/**
	 * 粉丝数量
	 */
	private int fansNum;

	/**
	 * 关注数量
	 */
	private int followNum;

	/**
	 * 浏览数量
	 */
	private int browerNum;

	/**
	 * 视频数量
	 */
	private int videoNum;

	/**
	 * 文章数量
	 */
	private int articleNum;

	/**
	 * 病例数量
	 */
	private int caseNum;

	/**
	 * 课件数量
	 */
	private int courseNum;

	/**
	 * 提问数量
	 */
	private int qaNum;

	/**
	 * 收藏数量
	 */
	private int collectionNum;

	/**
	 * 空间状态
	        0.关闭
	        1.开通
	 */
	private int personStatus;

	/**
	 * 空间等级
	 */
	private int personLevel;

	/**
	 * 活跃度
	 */
	private int personActive;

	/**
	 * 空间特权
	 */
	private int personSpecial;

	/**
	 * 用户信息
	 */
	private UserInfoBean userInfoBean;

	/**
	 * 构造方法
	 */
	public PersonInfoBean() {
		personId = -1;
		accountId = -1;
		fansNum = -1;
		followNum = -1;
		browerNum = -1;
		videoNum = -1;
		articleNum = -1;
		caseNum = -1;
		courseNum = -1;
		qaNum = -1;
		collectionNum = -1;
		personStatus = -1;
		personLevel = -1;
		personActive = -1;
		personSpecial = -1;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setFansNum(int fansNum) {
		this.fansNum = fansNum;
	}

	public int getFansNum() {
		return this.fansNum;
	}

	public void setFollowNum(int followNum) {
		this.followNum = followNum;
	}

	public int getFollowNum() {
		return this.followNum;
	}

	public void setBrowerNum(int browerNum) {
		this.browerNum = browerNum;
	}

	public int getBrowerNum() {
		return this.browerNum;
	}

	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}

	public int getVideoNum() {
		return this.videoNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public int getArticleNum() {
		return this.articleNum;
	}

	public void setCaseNum(int caseNum) {
		this.caseNum = caseNum;
	}

	public int getCaseNum() {
		return this.caseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	public int getCourseNum() {
		return this.courseNum;
	}

	public void setPersonStatus(int personStatus) {
		this.personStatus = personStatus;
	}

	public int getPersonStatus() {
		return this.personStatus;
	}

	public void setPersonLevel(int personLevel) {
		this.personLevel = personLevel;
	}

	public int getPersonLevel() {
		return this.personLevel;
	}

	public void setPersonActive(int personActive) {
		this.personActive = personActive;
	}

	public int getPersonActive() {
		return this.personActive;
	}

	public void setPersonSpecial(int personSpecial) {
		this.personSpecial = personSpecial;
	}

	public int getPersonSpecial() {
		return this.personSpecial;
	}

	public int getQaNum() {
		return qaNum;
	}

	public void setQaNum(int qaNum) {
		this.qaNum = qaNum;
	}

	public int getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(int collectionNum) {
		this.collectionNum = collectionNum;
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}
}