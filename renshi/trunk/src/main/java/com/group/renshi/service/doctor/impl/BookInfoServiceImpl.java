package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.BookInfoBean;
import com.group.renshi.service.doctor.BookInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: BookInfoServiceImpl.java,v 0.1 2015-06-17 下午11:11:07 Exp $
 */
@Service("bookInfoService")
@Transactional
public class BookInfoServiceImpl extends ServiceSupport implements BookInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.doctor.BookInfoService#insertBookInfo(com.group.renshi.bean.doctor.BookInfoBean)
	 */
	@Override
	public BookInfoBean insertBookInfo(BookInfoBean bookInfoBean) {
		bookInfoDao.insert(bookInfoBean);
		return bookInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.doctor.BookInfoService#deleteBookInfo(int)
	 */
	@Override
	public void deleteBookInfo(int id) {
		bookInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.doctor.BookInfoService#updateBookInfo(com.group.renshi.bean.doctor.BookInfoBean)
	 */
	@Override
	public void updateBookInfo(BookInfoBean bookInfoBean) {
		BookInfoBean bookInfoBeanData = bookInfoDao.load(bookInfoBean.getBookId());

		bookInfoDao.update(bookInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.doctor.BookInfoService#findById(int)
	 */
	@Override
	public BookInfoBean findById(int id) {
		return bookInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.doctor.BookInfoService#listBookInfo(com.group.renshi.bean.doctor.BookInfoBean)
	 */
	@Override
	public List<BookInfoBean> listBookInfo(BookInfoBean bookInfoBean) {
		List<BookInfoBean> bookInfoList = bookInfoDao.listData(bookInfoBean);
		return bookInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.doctor.BookInfoService#pageBookInfo(com.group.renshi.bean.doctor.BookInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<BookInfoBean> pageBookInfo(BookInfoBean bookInfoBean,
			PageQueryResult<BookInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(bookInfoDao, bookInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}