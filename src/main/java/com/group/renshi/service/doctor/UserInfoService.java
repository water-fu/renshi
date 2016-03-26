package com.group.renshi.service.doctor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.renshi.bean.doctor.ContactInfoBean;
import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: UserInfoService.java,v 0.1 2015-05-25 下午09:07:32 Exp $
 */
public interface UserInfoService {
	/**
	 * 插入对象
	 * 
	 * @param userInfoBean
	 *            需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	UserInfoBean insertUserInfo(UserInfoBean userInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键编号
	 */
	void deleteUserInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param userInfoBean
	 *            需要更新的实体对象
	 */
	void updateUserInfo(UserInfoBean userInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id
	 *            主键编号
	 * @return 返回实体对象
	 */
	UserInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param userInfoBean
	 *            实体对象
	 * @return 返回列表对象
	 */
	List<UserInfoBean> listUserInfo(UserInfoBean userInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param userInfoBean
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @return 返回分页对象
	 */
	PageQueryResult<UserInfoBean> pageUserInfo(UserInfoBean userInfoBean,
			PageQueryResult<UserInfoBean> pageQueryResult);

	/**
	 * 认证保存第一步
	 * 
	 * @param userInfoBean
	 * @param contactInfoBean
	 * @param request
	 */
	AccountInfoBean baseInfo(HttpServletRequest request,
			UserInfoBean userInfoBean, ContactInfoBean contactInfoBean,
			String headUrl, String profess);

	/**
	 * 认证保存第二步
	 * 
	 * @param authenticInfoBean
	 * @return
	 */
	AccountInfoBean authInfo(AuthenticInfoBean authenticInfoBean);

	/**
	 * 查找可能认识的人和对你有帮助的人
	 * 
	 * @param userInfoBean
	 */
	Map<String, List<UserInfoBean>> findKnowAndHelpList(
			UserInfoBean userInfoBean);

	/**
	 * 
	 * @param userInfoBean
	 * @param accountInfoBean
	 */
	void saveForm1(UserInfoBean userInfoBean, AccountInfoBean accountInfoBean);

	/**
	 * 
	 * @param userInfoBean
	 * @param authenticInfoBean
	 */
	void saveForm2(UserInfoBean userInfoBean,
			AuthenticInfoBean authenticInfoBean);

	/**
	 * 
	 * @param contactInfoBean
	 */
	void saveForm3(ContactInfoBean contactInfoBean);
}