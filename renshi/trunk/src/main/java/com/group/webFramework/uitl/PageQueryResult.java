package com.group.webFramework.uitl;

import java.util.List;

/**
 * 总体说明 分页查询结果类
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: PageQueryResult.java,v 0.1 2015-5-19 下午8:04:20 Exp $
 */
public class PageQueryResult<T> {

	/**
	 * 总记录数
	 */
	private long totalCount;

	/**
	 * 每页显示记录数
	 */
	private int pageSize;

	/**
	 * 页数
	 */
	private int pageNo;

	/**
	 * 结果集合
	 */
	private List<T> list;

	public PageQueryResult() {
		pageNo = 1;
		pageSize = 15;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getStartNum() {
		if (pageNo <= 0) {
			this.pageNo = 1;
		}
		return (pageNo - 1) * this.pageSize;
	}

	public int getEndNum() {
		return pageNo * pageSize;
	}

	public long getTotalPage() {
		if (totalCount == 0) {
			return 1;
		}
		return (this.totalCount / this.pageSize)
				+ ((this.totalCount % this.pageSize) != 0 ? 1 : 0);
	}
}
