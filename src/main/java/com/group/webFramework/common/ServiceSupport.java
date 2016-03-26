package com.group.webFramework.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.group.renshi.dao.admin.*;
import com.group.renshi.dao.doctor.AuthenticInfoDao;
import com.group.renshi.dao.doctor.BookInfoDao;
import com.group.renshi.dao.doctor.ContactInfoDao;
import com.group.renshi.dao.doctor.EducationInfoDao;
import com.group.renshi.dao.doctor.MeetingInfoDao;
import com.group.renshi.dao.doctor.PatentInfoDao;
import com.group.renshi.dao.doctor.PatientJudgeDao;
import com.group.renshi.dao.doctor.PrizeInfoDao;
import com.group.renshi.dao.doctor.UserInfoDao;
import com.group.renshi.dao.doctor.WorkInfoDao;
import com.group.renshi.dao.proxy.BaseInfoDao;
import com.group.renshi.dao.proxy.LicenseInfoDao;
import com.group.renshi.dao.qa.CommentDao;
import com.group.renshi.dao.qa.MentionDao;
import com.group.renshi.dao.qa.PostDao;
import com.group.renshi.dao.qa.ReplyDao;
import com.group.renshi.dao.share.AttachInfoDao;
import com.group.renshi.dao.share.CaseInfoDao;
import com.group.renshi.dao.share.CollectionInfoDao;
import com.group.renshi.dao.share.DiscussInfoDao;
import com.group.renshi.dao.share.FollowActiveDao;
import com.group.renshi.dao.share.MsgContentDao;
import com.group.renshi.dao.share.MsgInfoDao;
import com.group.renshi.dao.share.PersonInfoDao;
import com.group.renshi.dao.share.PraiseInfoDao;
import com.group.renshi.dao.share.QuestionInfoDao;
import com.group.renshi.dao.share.ShareInfoDao;
import com.group.renshi.dao.share.TagInfoDao;
import com.group.renshi.dao.share.VideoInfoDao;
import com.group.renshi.dao.system.AccountInfoDao;
import com.group.renshi.dao.system.AreaInfoDao;
import com.group.renshi.dao.system.DeptInfoDao;
import com.group.renshi.dao.system.HospitalInfoDao;
import com.group.renshi.dao.system.ValidMailDao;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明 Service实现类的父类
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: ServiceSupport.java,v 0.1 2015-5-19 上午9:29:19 Exp $
 */
public class ServiceSupport {

	@Resource
	protected AuthenticInfoDao authenticInfoDao;
	@Resource
	protected ContactInfoDao contactInfoDao;
	@Resource
	protected UserInfoDao userInfoDao;
	@Resource
	protected AccountInfoDao accountInfoDao;
	@Resource
	protected ValidMailDao validMailDao;
	@Resource
	protected AreaInfoDao areaInfoDao;
	@Resource
	protected DeptInfoDao deptInfoDao;
	@Resource
	protected HospitalInfoDao hospitalInfoDao;

	@Resource
	protected EducationInfoDao educationInfoDao;

	@Resource
	protected WorkInfoDao workInfoDao;

	@Resource
	protected PrizeInfoDao prizeInfoDao;

	@Resource
	protected PatientJudgeDao patientJudgeDao;

	@Resource
	protected BookInfoDao bookInfoDao;

	@Resource
	protected PatentInfoDao patentInfoDao;

	@Resource
	protected MeetingInfoDao meetingInfoDao;

	// ==============个人空间=================//

	@Resource
	protected FollowActiveDao followActiveDao;

	@Resource
	protected PersonInfoDao personInfoDao;

	@Resource
	protected ShareInfoDao shareInfoDao;

	@Resource
	protected AttachInfoDao attachInfoDao;

	@Resource
	protected CollectionInfoDao collectionInfoDao;

	@Resource
	protected PraiseInfoDao praiseInfoDao;

	@Resource
	protected DiscussInfoDao discussInfoDao;

	@Resource
	protected TagInfoDao tagInfoDao;

	@Resource
	protected VideoInfoDao videoInfoDao;

	@Resource
	protected CaseInfoDao caseInfoDao;

	@Resource
	protected QuestionInfoDao questionInfoDao;

	@Resource
	protected MsgInfoDao msgInfoDao;

	@Resource
	protected MsgContentDao msgContentDao;

	// ==============医问医答=================//
	@Resource
	protected CommentDao commentDao;

	@Resource
	protected MentionDao mentionDao;

	@Resource
	protected PostDao postDao;

	@Resource
	protected ReplyDao replyDao;

	// 代理商信息

	@Resource
	protected BaseInfoDao baseInfoDao;

	@Resource
	protected LicenseInfoDao licenseInfoDao;

	// 后台管理
	@Resource
	protected PermissionDao permissionDao;
	@Resource
	protected RoleDao roleDao;
	@Resource
	protected RolePermissionDao rolePermissionDao;
	@Resource
	protected UserDao userDao;
	@Resource
	protected UserRoleDao userRoleDao;
	@Resource
	protected AgentDoctorRelationDao agentDoctorRelationDao;

	/**
	 * 分页查询工具类
	 * 
	 * @param baseDao
	 *            查询DAO对象
	 * @param baseEntity
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @param map
	 *            【可选参数】 自定义参数map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected PageQueryResult pageDataUtil(BaseDao baseDao,
			BaseEntity baseEntity, PageQueryResult pageQueryResult,
			Map<String, Object>... map) {
		// 获取具体javaBean的类名,并且首字母变小写
		String entityName = toFirstCharLower(baseEntity.getClass()
				.getSimpleName());
		String pageName = toFirstCharLower(pageQueryResult.getClass()
				.getSimpleName());

		// 封装分页查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 自定义param参数，可选参数
		if (null != map) {
			for (int i = 0; i < map.length; i++) {
				paramMap.putAll(map[i]);
			}
		}

		paramMap.put(entityName, baseEntity);
		paramMap.put(pageName, pageQueryResult);

		// 查询总记录数
		int totalCount = baseDao.countPageData(paramMap);

		List userList = new ArrayList();
		// 数量大于0,再进行查询数据
		if (totalCount > 0) {
			// 查询数据
			userList = baseDao.pageData(paramMap);
		}

		// 设置分页查询结果
		pageQueryResult.setList(userList);
		pageQueryResult.setTotalCount(totalCount);

		return pageQueryResult;
	}

	/**
	 * 首字母变小写
	 * 
	 * @param name
	 * @return
	 */
	protected String toFirstCharLower(String name) {
		StringBuffer sb = new StringBuffer();
		sb.append(name.substring(0, 1).toLowerCase()).append(name.substring(1));

		return sb.toString();
	}
}
