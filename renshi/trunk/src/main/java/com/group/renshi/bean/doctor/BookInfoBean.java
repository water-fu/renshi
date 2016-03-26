package com.group.renshi.bean.doctor;

import com.group.webFramework.common.BaseEntity;

/**
 * 总体说明 doctor_book_info
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: BookInfoBean.java,v 0.1 2015-06-17 下午11:11:07 Exp $
 */
public class BookInfoBean extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 著作编号
	 */
	private int bookId;

	/**
	 * 账户编号
	 */
	private int accountId;

	/**
	 * 著作名称
	 */
	private java.lang.String bookName;

	/**
	 * 作者类型 1.第一作者 2.第二作者 3.译者
	 */
	private String authorType;

	/**
	 * 作者名称
	 */
	private java.lang.String authorName;

	/**
	 * 出版时间
	 */
	private String publishDate;

	/**
	 * 出版机构
	 */
	private java.lang.String publishDept;

	/**
	 * 著作描述
	 */
	private java.lang.String bookDesc;

	/**
	 * 构造方法
	 */
	public BookInfoBean() {
		bookId = -1;
		accountId = -1;
		bookName = null;
		authorType = null;
		authorName = null;
		publishDate = null;
		publishDept = null;
		bookDesc = null;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setBookName(java.lang.String bookName) {
		this.bookName = bookName;
	}

	public java.lang.String getBookName() {
		return this.bookName;
	}

	/**
	 * Getter method for property <tt>authorType</tt>.
	 * 
	 * @return property value of authorType
	 */
	public String getAuthorType() {
		return authorType;
	}

	/**
	 * Setter method for property <tt>authorType</tt>.
	 * 
	 * @param authorType
	 *            value to be assigned to property authorType
	 */
	public void setAuthorType(String authorType) {
		this.authorType = authorType;
	}

	public void setAuthorName(java.lang.String authorName) {
		this.authorName = authorName;
	}

	public java.lang.String getAuthorName() {
		return this.authorName;
	}

	/**
	 * Getter method for property <tt>publishDate</tt>.
	 * 
	 * @return property value of publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * Setter method for property <tt>publishDate</tt>.
	 * 
	 * @param publishDate
	 *            value to be assigned to property publishDate
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public void setPublishDept(java.lang.String publishDept) {
		this.publishDept = publishDept;
	}

	public java.lang.String getPublishDept() {
		return this.publishDept;
	}

	public void setBookDesc(java.lang.String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public java.lang.String getBookDesc() {
		return this.bookDesc;
	}
}