package com.group.webFramework.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 总体说明
 * 	JavaBean父类
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: BaseEntity.java,v 0.1 2015-5-19 上午9:56:12 Exp $
 */
public class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 新增用户
	 */
	private int createUser;

	/**
	 * 新增日期
	 */
	private Date createDate;

	/**
	 * 更新用户
	 */
	private int updateUser;

	/**
	 * 更新日期
	 */
	private Date updateDate;

	/**
	 * 父类构造方法
	 */
	public BaseEntity() {
		this.createUser = -1;
		this.createDate = null;
		this.updateUser = -1;
		this.updateDate = null;
	}

	public int getCreateUser() {
		return createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
