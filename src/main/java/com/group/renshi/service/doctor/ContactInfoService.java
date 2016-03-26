package com.group.renshi.service.doctor;

import java.util.List;

import com.group.renshi.bean.doctor.ContactInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: ContactInfoService.java,v 0.1 2015-05-25 下午09:07:32 Exp $
 */
public interface ContactInfoService {
	/**
	 * 插入对象
	 * 
	 * @param contactInfoBean
	 *            需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	ContactInfoBean insertContactInfo(ContactInfoBean contactInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键编号
	 */
	void deleteContactInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param contactInfoBean
	 *            需要更新的实体对象
	 */
	void updateContactInfo(ContactInfoBean contactInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id
	 *            主键编号
	 * @return 返回实体对象
	 */
	ContactInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param contactInfoBean
	 *            实体对象
	 * @return 返回列表对象
	 */
	List<ContactInfoBean> listContactInfo(ContactInfoBean contactInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param contactInfoBean
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @return 返回分页对象
	 */
	PageQueryResult<ContactInfoBean> pageContactInfo(ContactInfoBean contactInfoBean,
			PageQueryResult<ContactInfoBean> pageQueryResult);
}