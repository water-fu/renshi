package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.ContactInfoBean;
import com.group.renshi.service.doctor.ContactInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: ContactInfoServiceImpl.java,v 0.1 2015-05-25 下午09:07:32 Exp $
 */
@Service("contactInfoService")
@Transactional
public class ContactInfoServiceImpl extends ServiceSupport implements ContactInfoService {
	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.doctor.ContactInfoService#insertContactInfo(com.group.renshi.bean.doctor.ContactInfoBean)
	 */
	@Override
	public ContactInfoBean insertContactInfo(ContactInfoBean contactInfoBean) {
		contactInfoDao.insert(contactInfoBean);
		return contactInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.doctor.ContactInfoService#deleteContactInfo(int)
	 */
	@Override
	public void deleteContactInfo(int id) {
		contactInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.doctor.ContactInfoService#updateContactInfo(com.group.renshi.bean.doctor.ContactInfoBean)
	 */
	@Override
	public void updateContactInfo(ContactInfoBean contactInfoBean) {
		ContactInfoBean contactInfoBeanData = contactInfoDao.load(contactInfoBean.getAccountId());

		contactInfoDao.update(contactInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.doctor.ContactInfoService#findById(int)
	 */
	@Override
	public ContactInfoBean findById(int id) {
		return contactInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.doctor.ContactInfoService#listContactInfo(com.group.renshi.bean.doctor.ContactInfoBean)
	 */
	@Override
	public List<ContactInfoBean> listContactInfo(ContactInfoBean contactInfoBean) {
		List<ContactInfoBean> contactInfoList = contactInfoDao.listData(contactInfoBean);
		return contactInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.doctor.ContactInfoService#pageContactInfo(com.group.renshi.bean.doctor.ContactInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<ContactInfoBean> pageContactInfo(ContactInfoBean contactInfoBean,
			PageQueryResult<ContactInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(contactInfoDao, contactInfoBean, pageQueryResult);

		return pageQueryResult;
	}

	/**
	 * @see com.group.renshi.service.doctor.ContactInfoService#insert(com.group.renshi.bean.doctor.ContactInfoBean)
	 */

}