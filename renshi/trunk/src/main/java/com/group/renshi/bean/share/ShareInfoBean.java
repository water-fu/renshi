package com.group.renshi.bean.share;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 blog_share_info
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: ShareInfoBean.java,v 0.1 2015-06-09 下午02:11:11 Exp $
 */
public class ShareInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 分享编号
	 */
	private int shareId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 分享标题
	 */
	private java.lang.String shareTitle;

	/**
	 * 分享类型 1.视频 2.观点 3.病例 4.文档 5.提问
	 */
	private int shareType;

	/**
	 * 分享标签
	 */
	private java.lang.String shareTag;

	/**
	 * 分享描述
	 */
	private java.lang.String shareDesc;

	/**
	 * 所属专业
	 */
	private java.lang.String belongProfess;

	/**
	 * 阅读权限
	 */
	private int readPermission;

	/**
	 * 审批状态 0.未审批 1.审批通过 2.审批未通过
	 */
	private int shareStatus;

	/**
	 * 点赞数量
	 */
	private int likeNum;

	/**
	 * 收藏数量
	 */
	private int collectionNum;

	/**
	 * 查看次数
	 */
	private int readNum;

	/**
	 * 评论次数
	 */
	private int commentNum;

	/**
	 * 等级
	 */
	private int shareLevel;

	// Extend Attribute 为空间分享数据查询展示用
	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 头像地址
	 */
	private String headUrl;

	/**
	 * 所属科室
	 */
	private String belongDept;

	/**
	 * 工作职称
	 */
	private String workProfess;

	/**
	 * 生成发布时间
	 */
	private String publicDate;

	/**
	 * 是否收藏 1：未收藏 0： 收藏
	 */
	private int isCollection;

	/**
	 * 是否关注 1：未关注 0：关注
	 */
	private int isPraise;

	/**
	 * 收藏时间
	 */
	private Date collectionDate;

	/**
	 * 点赞时间
	 */
	private Date praiseDate;

	/**
	 * 构造方法
	 */
	public ShareInfoBean() {
		shareId = -1;
		accountId = -1;
		shareTitle = null;
		shareType = -1;
		shareTag = null;
		shareDesc = null;
		belongProfess = null;
		readPermission = -1;
		shareStatus = -1;
		likeNum = -1;
		collectionNum = -1;
		readNum = -1;
		commentNum = -1;
		shareLevel = -1;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public int getShareId() {
		return this.shareId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setShareTitle(java.lang.String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public java.lang.String getShareTitle() {
		return this.shareTitle;
	}

	public void setShareType(int shareType) {
		this.shareType = shareType;
	}

	public int getShareType() {
		return this.shareType;
	}

	public void setShareTag(java.lang.String shareTag) {
		this.shareTag = shareTag;
	}

	public java.lang.String getShareTag() {
		return this.shareTag;
	}

	public void setShareDesc(java.lang.String shareDesc) {
		this.shareDesc = shareDesc;
	}

	public java.lang.String getShareDesc() {
		return this.shareDesc;
	}

	public void setBelongProfess(java.lang.String belongProfess) {
		this.belongProfess = belongProfess;
	}

	public java.lang.String getBelongProfess() {
		return this.belongProfess;
	}

	public void setReadPermission(int readPermission) {
		this.readPermission = readPermission;
	}

	public int getReadPermission() {
		return this.readPermission;
	}

	public void setShareStatus(int shareStatus) {
		this.shareStatus = shareStatus;
	}

	public int getShareStatus() {
		return this.shareStatus;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getLikeNum() {
		return this.likeNum;
	}

	public void setCollectionNum(int collectionNum) {
		this.collectionNum = collectionNum;
	}

	public int getCollectionNum() {
		return this.collectionNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

	public int getReadNum() {
		return this.readNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getBelongDept() {
		return belongDept;
	}

	public void setBelongDept(String belongDept) {
		this.belongDept = belongDept;
	}

	public String getWorkProfess() {
		return workProfess;
	}

	public void setWorkProfess(String workProfess) {
		this.workProfess = workProfess;
	}

	/**
	 * 1分钟之内，显示XX秒前 1小时之内，显示XX分钟前 1小时以上，显示今天HH:mm 1天以上，显示昨天HH:mm 2天以上，显示MM-DD
	 * HH:mm
	 * 
	 * @return
	 */
	public String getPublicDate() {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");

		Date nowDate = new Date();
		String dateStr = simple.format(nowDate);
		try {
			nowDate = simple.parse(dateStr);
		} catch (ParseException e) {
		}

		Date publishDate = getCreateDate();
		String publishDateStr = simple.format(publishDate);
		try {
			publishDate = simple.parse(publishDateStr);
		} catch (ParseException e) {
		}

		long diff = nowDate.getTime() - publishDate.getTime();

		if (diff / (day * 2) > 0) { // 2天以上
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"MM-dd HH:mm");
			this.publicDate = simpleDateFormat.format(getCreateDate());

		} else if (diff / day > 0) { // 1天以上
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
			this.publicDate = "昨天 " + simpleDateFormat.format(getCreateDate());

		} else if (diff / hour > 0) { // 1小时以上
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
			this.publicDate = "今天 " + simpleDateFormat.format(getCreateDate());

		} else if (diff / minute > 0) { // 1分钟以上
			this.publicDate = diff / minute + "分钟前";

		} else if (diff / second < 5) { // 5秒以内
			this.publicDate = "刚刚";

		} else { // 5秒以上，60一下
			this.publicDate = diff / second + "秒前";
		}

		return publicDate;
	}

	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}

	private static int second = 1000;

	private static int minute = second * 60;

	private static int hour = minute * 60;

	private static int day = hour * 24;

	public int getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(int isCollection) {
		this.isCollection = isCollection;
	}

	public Date getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}

	public int getIsPraise() {
		return isPraise;
	}

	public void setIsPraise(int isPraise) {
		this.isPraise = isPraise;
	}

	public String getShareTypeName() {
		switch (this.shareType) {
		case 1:
			return "视频";
		case 2:
			return "观点";
		case 3:
			return "病例";
		case 4:
			return "文档";
		case 5:
			return "提问";
		default:
			return "";
		}
	}

	public Date getPraiseDate() {
		return praiseDate;
	}

	public void setPraiseDate(Date praiseDate) {
		this.praiseDate = praiseDate;
	}

	public int getShareLevel() {
		return shareLevel;
	}

	public void setShareLevel(int shareLevel) {
		this.shareLevel = shareLevel;
	}
}