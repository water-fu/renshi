package com.group.renshi.service.doctor.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.renshi.bean.doctor.ContactInfoBean;
import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.cache.ProfessionalCache;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.doctor.UserInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.entity.UserDetails;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.SessionControl;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: UserInfoServiceImpl.java,v 0.1 2015-05-25 下午09:07:32 Exp $
 */
@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl extends ServiceSupport implements
		UserInfoService {

	private static final Logger log = Logger
			.getLogger(UserInfoServiceImpl.class);

	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.doctor.UserInfoService#insertUserInfo(com.group.renshi.bean.doctor.UserInfoBean)
	 */
	@Override
	public UserInfoBean insertUserInfo(UserInfoBean userInfoBean) {
		userInfoDao.insert(userInfoBean);
		return userInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.doctor.UserInfoService#deleteUserInfo(int)
	 */
	@Override
	public void deleteUserInfo(int id) {
		userInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.doctor.UserInfoService#updateUserInfo(com.group.renshi.bean.doctor.UserInfoBean)
	 */
	@Override
	public void updateUserInfo(UserInfoBean userInfoBean) {
		UserInfoBean userInfoBeanData = userInfoDao.load(userInfoBean
				.getAccountId());

		userInfoDao.update(userInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.doctor.UserInfoService#findById(int)
	 */
	@Override
	public UserInfoBean findById(int id) {
		return userInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.doctor.UserInfoService#listUserInfo(com.group.renshi.bean.doctor.UserInfoBean)
	 */
	@Override
	public List<UserInfoBean> listUserInfo(UserInfoBean userInfoBean) {
		List<UserInfoBean> userInfoList = userInfoDao.listData(userInfoBean);
		return userInfoList;
	}

	/**
	 * 获取分页数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<UserInfoBean> pageUserInfo(
			UserInfoBean userInfoBean,
			PageQueryResult<UserInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(userInfoDao, userInfoBean,
				pageQueryResult);
		return pageQueryResult;
	}

	/**
	 * 认证保存第一步
	 */
	@Override
	public AccountInfoBean baseInfo(HttpServletRequest request,
			UserInfoBean userInfoBean, ContactInfoBean contactInfoBean,
			String headUrl, String professParam) {
		int accountId = userInfoBean.getAccountId();

		// 设置头像地址
		AccountInfoBean accountInfoBean = accountInfoDao.load(accountId);
		accountInfoBean.setHeadUrl(headUrl);
		accountInfoBean
				.setAccountStatus(SystemConstantType.ACCOUNT_STATUS_FIRST);
		accountInfoDao.update(accountInfoBean);

		// 保存联系方式
		contactInfoDao.insert(contactInfoBean);

		// 保存认证信息
		AuthenticInfoBean authenticInfoBean = new AuthenticInfoBean();
		authenticInfoBean.setAccountId(accountId);

		String[] professStrs = professParam.split(",");
		for (String profess : professStrs) {
			// 取职称是属于哪个类型
			String type = ProfessionalCache.getInstance().get(profess.trim())
					.toString();
			if (type.equals(ProfessionalCache.WORK)) {
				// 工作职称
				authenticInfoBean.setWorkProfess(profess.trim());

				authenticInfoBean.setProfessLevel(Integer
						.parseInt(ProfessionalCache.getInstance()
								.get("level_" + profess.trim()).toString()));

				userInfoBean.setWorkProfess(profess.trim());

			} else if (type.equals(ProfessionalCache.ACADEMIC)) {
				// 学术职称
				authenticInfoBean.setAcademicProfess(profess.trim());

			} else if (type.equals(ProfessionalCache.EDUCATION)) {
				// 教育职称
				authenticInfoBean.setEducationProfess(profess.trim());
			}
		}

		authenticInfoDao.insert(authenticInfoBean);

		// 保存个人信息
		userInfoDao.insert(userInfoBean);

		// 把数据放进session中
		UserDetails userDetails = SessionControl.getCurUserDetail(request);
		userDetails.setAccountInfoBean(accountInfoBean);
		userDetails.setUserInfoBean(userInfoBean);

		SessionControl.setAttribute(request, SystemConstantType.USER_DETAILS,
				userDetails);

		return accountInfoBean;
	}

	/**
	 * 认证保存第二步
	 * 
	 * @see com.group.renshi.service.doctor.UserInfoService#authInfo(com.group.renshi.bean.doctor.AuthenticInfoBean)
	 */
	@Override
	public AccountInfoBean authInfo(AuthenticInfoBean authenticInfoBean) {
		// 更新认证信息的证书连接和身份证证书链接
		AuthenticInfoBean authenticInfoBeanData = authenticInfoDao
				.load(authenticInfoBean.getAccountId());

		authenticInfoBeanData.setCertificateType(authenticInfoBean
				.getCertificateType());
		authenticInfoBeanData.setCertificateNo(authenticInfoBean
				.getCertificateNo());
		authenticInfoBeanData.setCertificateUrl(authenticInfoBean
				.getCertificateUrl());

		authenticInfoBeanData.setIdCard(authenticInfoBean.getIdCard());
		authenticInfoBeanData.setFrontUrl(authenticInfoBean.getFrontUrl());
		authenticInfoBeanData.setBackUrl(authenticInfoBean.getBackUrl());

		authenticInfoDao.update(authenticInfoBeanData);

		// 更新认证状态
		AccountInfoBean accountInfoBean = accountInfoDao
				.load(authenticInfoBeanData.getAccountId());
		accountInfoBean
				.setAccountStatus(SystemConstantType.ACCOUNT_STATUS_SECOND);

		accountInfoDao.update(accountInfoBean);

		return accountInfoBean;
	}

	/**
	 * 查找可能认识的人和对你有帮助的人
	 * 
	 * @param userInfoBean
	 */
	@Override
	public Map<String, List<UserInfoBean>> findKnowAndHelpList(
			UserInfoBean userInfoBean) {

		Map<String, List<UserInfoBean>> retMap = new HashMap<String, List<UserInfoBean>>();

		// 1、查找可能认识的人--同科室、同医院、同城、同学校同年级
		// 不包括我, 且没有关注的
		String belongDept = userInfoBean.getBelongDept();
		String belongHospital = userInfoBean.getBelongHospital();
		String liveTown = userInfoBean.getLiveTown();

		PageQueryResult<UserInfoBean> pageQueryResult = new PageQueryResult<UserInfoBean>();
		pageQueryResult.setPageNo(1);
		pageQueryResult.setPageSize(5);

		List<UserInfoBean> knowBeanList = userInfoDao.QueryKnowBeanList(
				belongDept, belongHospital, liveTown, "",
				userInfoBean.getAccountId(), pageQueryResult);

		// 2、查找对你有帮助的人--同科室，且职称级别比自己高

		AuthenticInfoBean obj = new AuthenticInfoBean();
		obj.setAccountId(userInfoBean.getAccountId());
		List<AuthenticInfoBean> list1 = authenticInfoDao.listData(obj);
		int professLevel = -1;
		if (list1.size() == 0) {
			log.info("根据用户编号<" + userInfoBean.getAccountId() + ">无法获取医生工作信息。");
		} else {
			professLevel = list1.get(0).getProfessLevel();
		}

		PageQueryResult<UserInfoBean> pageQueryResult1 = new PageQueryResult<UserInfoBean>();
		pageQueryResult1.setPageNo(1);
		pageQueryResult1.setPageSize(5);

		List<UserInfoBean> helpBeanList = userInfoDao.QueryHelpBeanList(
				belongDept, professLevel, userInfoBean.getAccountId(),
				pageQueryResult1);

		retMap.put("knowBeanList", knowBeanList);
		retMap.put("helpBeanList", helpBeanList);

		return retMap;
	}

	/**
	 * @see com.group.renshi.service.doctor.UserInfoService#saveForm1(com.group.renshi.bean.doctor.UserInfoBean,
	 *      com.group.renshi.bean.system.AccountInfoBean)
	 */
	@Override
	public void saveForm1(UserInfoBean userInfoBean,
			AccountInfoBean accountInfoBean) {
		AccountInfoBean accountInfoBeanData = accountInfoDao
				.load(accountInfoBean.getAccountId());
		UserInfoBean userInfoBeanData = userInfoDao.load(userInfoBean
				.getAccountId());

		accountInfoBeanData.setHeadUrl(accountInfoBean.getHeadUrl());

		userInfoBeanData.setAccountSex(userInfoBean.getAccountSex());
		userInfoBeanData.setBirthDate(userInfoBean.getBirthDate());
		userInfoBeanData.setLiveTown(userInfoBean.getLiveTown());

		accountInfoDao.update(accountInfoBeanData);

		userInfoDao.update(userInfoBeanData);
	}

	/**
	 * @see com.group.renshi.service.doctor.UserInfoService#saveForm2(com.group.renshi.bean.doctor.UserInfoBean,
	 *      com.group.renshi.bean.doctor.AuthenticInfoBean)
	 */
	@Override
	public void saveForm2(UserInfoBean userInfoBean,
			AuthenticInfoBean authenticInfoBean) {
		UserInfoBean userInfoBeanData = userInfoDao.load(userInfoBean
				.getAccountId());
		AuthenticInfoBean authenticInfoBeanData = authenticInfoDao
				.load(authenticInfoBean.getAccountId());

		authenticInfoBeanData
				.setWorkProfess(authenticInfoBean.getWorkProfess());
		authenticInfoBeanData.setAcademicProfess(authenticInfoBean
				.getAcademicProfess());
		authenticInfoBeanData.setEducationProfess(authenticInfoBean
				.getEducationProfess());

		authenticInfoDao.update(authenticInfoBeanData);

		userInfoBeanData.setBelongHospital(userInfoBean.getBelongHospital());
		userInfoBeanData.setBelongDept(userInfoBean.getBelongDept());
		userInfoBeanData.setBelongMedical(userInfoBean.getBelongMedical());
		userInfoBeanData.setSpecilArea(userInfoBean.getSpecilArea());
		userInfoBeanData.setPersonInfro(userInfoBean.getPersonInfro());

		userInfoDao.update(userInfoBeanData);
	}

	/**
	 * @see com.group.renshi.service.doctor.UserInfoService#saveForm3(com.group.renshi.bean.doctor.ContactInfoBean)
	 */
	@Override
	public void saveForm3(ContactInfoBean contactInfoBean) {
		ContactInfoBean contactInfoBeanData = contactInfoDao
				.load(contactInfoBean.getAccountId());

		contactInfoBeanData.setPhoneNo(contactInfoBean.getPhoneNo());
		contactInfoBeanData.setQqNo(contactInfoBean.getQqNo());

		contactInfoDao.update(contactInfoBeanData);
	}
}