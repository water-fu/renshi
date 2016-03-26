package com.group.renshi.service.share.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.qa.MentionBean;
import com.group.renshi.bean.share.AttachInfoBean;
import com.group.renshi.bean.share.CaseInfoBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.share.QuestionInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.bean.share.VideoInfoBean;
import com.group.renshi.service.share.ShareInfoService;
import com.group.webFramework.common.BaseDao;
import com.group.webFramework.common.BaseEntity;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.exception.ApplicationException;
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
 * @version $Id: ShareInfoServiceImpl.java,v 0.1 2015-06-09 下午02:11:11 Exp $
 */
@Service("shareInfoService")
@Transactional
public class ShareInfoServiceImpl extends ServiceSupport implements
		ShareInfoService {
	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.blog.ShareInfoService#insertShareInfo(com.group.renshi.bean.blog.ShareInfoBean)
	 */
	@Override
	public ShareInfoBean insertShareInfo(ShareInfoBean shareInfoBean,
			HttpServletRequest request) {

		// 对标签进行拆解
		if (shareInfoBean.getShareTag() != null
				&& !"".equals(shareInfoBean.getShareTag())) {
			shareInfoBean.setShareTag(shareInfoBean.getShareTag().replace("，",
					","));
		}

		shareInfoBean.setShareStatus(0);
		shareInfoBean.setLikeNum(0);
		shareInfoBean.setCollectionNum(0);
		shareInfoBean.setReadNum(0);
		shareInfoBean.setCommentNum(0);
		shareInfoBean.setShareLevel(0);

		// 提问，不需要审核
		if (shareInfoBean.getShareType() == 5) {
			shareInfoBean.setShareStatus(1);
		}

		shareInfoDao.insert(shareInfoBean);

		// 插入爱特信息
		Object obj = request.getAttribute("callone");
		if (null != obj) {
			String atStr = obj.toString();
			if (!"".equals(atStr)) {
				String[] ats = atStr.split(" |,|，");
				for (String at : ats) {
					String name = at.trim().substring(1);

					UserInfoBean userInfoBean = new UserInfoBean();
					userInfoBean.setRealName(name);

					List<UserInfoBean> list = userInfoDao
							.listData(userInfoBean);
					if (list.isEmpty()) {
						throw new ApplicationException("提醒用户[" + name + "]不存在");
					}

					MentionBean mentionBean = new MentionBean();
					mentionBean.setAccountId(list.get(0).getAccountId());
					mentionBean.setCommonId(shareInfoBean.getShareId());
					mentionBean.setIsRead("0");
					mentionBean.setMsg("");

					mentionDao.insert(mentionBean);
				}
			}
		}

		// 更新分享数量
		PersonInfoBean personInfoBean = new PersonInfoBean();
		personInfoBean.setAccountId(shareInfoBean.getAccountId());
		List<PersonInfoBean> list = personInfoDao.listData(personInfoBean);
		if (!CollectionUtils.isEmpty(list)) {

			personInfoBean = list.get(0);
			// 视频
			if (shareInfoBean.getShareType() == 1) {
				personInfoBean.setVideoNum(personInfoBean.getVideoNum() + 1);
			}
			// 观点
			else if (shareInfoBean.getShareType() == 2) {
				personInfoBean
						.setArticleNum(personInfoBean.getArticleNum() + 1);
			}
			// 病例
			else if (shareInfoBean.getShareType() == 3) {
				personInfoBean.setCaseNum(personInfoBean.getCaseNum() + 1);
			}
			// 文库
			else if (shareInfoBean.getShareType() == 4) {
				personInfoBean.setCourseNum(personInfoBean.getCourseNum() + 1);
			}
			// 医问
			else if (shareInfoBean.getShareType() == 5) {
				personInfoBean.setQaNum(personInfoBean.getQaNum() + 1);
			}

			personInfoDao.update(personInfoBean);
		}

		// 添加视频地址
		if (shareInfoBean.getShareType() == 1) {
			String videoUrl = request.getAttribute("fileUrl") + "";
			if (null != videoUrl && !"".equals(videoUrl)) {
				AttachInfoBean attachInfoBean = new AttachInfoBean();
				attachInfoBean.setShareId(shareInfoBean.getShareId());
				attachInfoBean.setAttachType(3);
				attachInfoBean.setAttachName("");
				attachInfoBean.setAttachUrl(videoUrl);
				attachInfoBean.setAttachSuffix("");

				attachInfoDao.insert(attachInfoBean);

				VideoInfoBean videoInfoBean = new VideoInfoBean();
				videoInfoBean.setShareId(shareInfoBean.getShareId());
				videoInfoBean.setVideoUrl(videoUrl);

				videoInfoDao.insert(videoInfoBean);
			}
		}
		// 观点
		else if (shareInfoBean.getShareType() == 2) {
			String videoUrl = request.getAttribute("fileUrl") + "";
			if (null != videoUrl && !"".equals(videoUrl)) {
				AttachInfoBean attachInfoBean = new AttachInfoBean();
				attachInfoBean.setShareId(shareInfoBean.getShareId());
				attachInfoBean.setAttachType(1);
				attachInfoBean.setAttachName("");
				attachInfoBean.setAttachUrl(videoUrl);
				attachInfoBean.setAttachSuffix("");

				attachInfoDao.insert(attachInfoBean);
			}
		}
		// 病例
		else if (shareInfoBean.getShareType() == 3) {
			String videoUrl = request.getAttribute("fileUrl") + "";
			if (null != videoUrl && !"".equals(videoUrl)) {
				AttachInfoBean attachInfoBean = new AttachInfoBean();
				attachInfoBean.setShareId(shareInfoBean.getShareId());
				attachInfoBean.setAttachType(1);
				attachInfoBean.setAttachName("");
				attachInfoBean.setAttachUrl(videoUrl);
				attachInfoBean.setAttachSuffix("");

				attachInfoDao.insert(attachInfoBean);

			}

			// 插入病例详细信息
			CaseInfoBean caseInfoBeanCond = (CaseInfoBean) request
					.getAttribute("caseInfoBean");

			if (caseInfoBeanCond != null) {
				CaseInfoBean caseInfoBean = new CaseInfoBean();
				caseInfoBean.setShareId(shareInfoBean.getShareId());
				caseInfoBean.setPatientSex(caseInfoBeanCond.getPatientSex());
				caseInfoBean.setPatientAge(caseInfoBeanCond.getPatientAge());

				caseInfoDao.insert(caseInfoBean);
			}

		}
		// 文库
		else if (shareInfoBean.getShareType() == 4) {
			String libraryUrl = request.getAttribute("fileUrl") + "";
			String libraryName = request.getAttribute("fileName") + "";

			if (null != libraryUrl && !"".equals(libraryUrl)) {
				AttachInfoBean attachInfoBean = new AttachInfoBean();
				attachInfoBean.setShareId(shareInfoBean.getShareId());
				attachInfoBean.setAttachType(2);

				attachInfoBean.setAttachName(libraryName);
				attachInfoBean.setAttachUrl(libraryUrl);
				attachInfoBean.setAttachSuffix("");

				attachInfoDao.insert(attachInfoBean);
			}
		}
		// 医问
		else if (shareInfoBean.getShareType() == 5) {
			String videoUrl = request.getAttribute("fileUrl") + "";
			if (null != videoUrl && !"".equals(videoUrl)) {
				AttachInfoBean attachInfoBean = new AttachInfoBean();
				attachInfoBean.setShareId(shareInfoBean.getShareId());
				attachInfoBean.setAttachType(1);
				attachInfoBean.setAttachName("");
				attachInfoBean.setAttachUrl(videoUrl);
				attachInfoBean.setAttachSuffix("");

				attachInfoDao.insert(attachInfoBean);

			}

			// 插入医问详细信息
			QuestionInfoBean questionInfoBeanCond = (QuestionInfoBean) request
					.getAttribute("questionInfoBean");
			if (questionInfoBeanCond != null) {
				QuestionInfoBean questionInfoBean = new QuestionInfoBean();
				questionInfoBean.setShareId(shareInfoBean.getShareId());
				questionInfoBean.setPatientAge(questionInfoBeanCond
						.getPatientAge());
				questionInfoBean.setPatientSex(questionInfoBeanCond
						.getPatientSex());

				questionInfoDao.insert(questionInfoBean);
			}

		}

		return shareInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.blog.ShareInfoService#deleteShareInfo(int)
	 */
	@Override
	public void deleteShareInfo(int id) {
		shareInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.blog.ShareInfoService#updateShareInfo(com.group.renshi.bean.blog.ShareInfoBean)
	 */
	@Override
	public void updateShareInfo(ShareInfoBean shareInfoBean) {
		ShareInfoBean shareInfoBeanData = shareInfoDao.load(shareInfoBean
				.getShareId());
		shareInfoBeanData.setShareStatus(1);// 审核通过
		shareInfoDao.update(shareInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.blog.ShareInfoService#findById(int)
	 */
	@Override
	public ShareInfoBean findById(int id) {
		return shareInfoDao.load(id);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.blog.ShareInfoService#findById(int)
	 */
	@Override
	public ShareInfoBean loadExtend(int id) {
		ShareInfoBean shareInfoBean = shareInfoDao.loadExtend(id);

		// 更新浏览数量
		shareInfoBean.setReadNum(shareInfoBean.getReadNum() + 1);
		shareInfoDao.update(shareInfoBean);

		return shareInfoBean;
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.blog.ShareInfoService#listShareInfo(com.group.renshi.bean.blog.ShareInfoBean)
	 */
	@Override
	public List<ShareInfoBean> listShareInfo(ShareInfoBean shareInfoBean) {
		List<ShareInfoBean> shareInfoList = shareInfoDao
				.listData(shareInfoBean);
		return shareInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.blog.ShareInfoService#pageShareInfo(com.group.renshi.bean.blog.ShareInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<ShareInfoBean> pageShareInfo(
			ShareInfoBean shareInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchType,
			HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchType", searchType);
		if (SessionControl.getCurUserDetail(request) == null) {
			paramMap.put("curAccountId", shareInfoBean.getAccountId());
		} else {
			paramMap.put("curAccountId", SessionControl.getOpId(request));
		}

		pageQueryResult = this.pageDataUtil(shareInfoDao, shareInfoBean,
				pageQueryResult, paramMap);

		return pageQueryResult;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.blog.ShareInfoService#pageShareInfo(com.group.renshi.bean.blog.ShareInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<ShareInfoBean> pageShareInfoWithTime(
			ShareInfoBean shareInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchType,
			java.sql.Date sqlDate, HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchType", searchType);
		paramMap.put("shareTime", sqlDate);
		if (SessionControl.getCurUserDetail(request) == null) {
			paramMap.put("curAccountId", shareInfoBean.getAccountId());
			paramMap.put("isMySelf", "-1");
		} else {
			paramMap.put("curAccountId", SessionControl.getOpId(request));
			if (SessionControl.getOpId(request) == shareInfoBean.getAccountId()) {
				paramMap.put("isMySelf", "1");
			} else {
				paramMap.put("isMySelf", "0");
			}
		}

		pageQueryResult = this.pageDataUtil(shareInfoDao, shareInfoBean,
				pageQueryResult, paramMap);

		return pageQueryResult;
	}

	/**
	 * 获取所有待审核的医生作品数据
	 * 
	 * @param shareInfoBean
	 * @param pageQueryResult
	 * @return
	 */
	public PageQueryResult<ShareInfoBean> pageShareInfo(
			ShareInfoBean shareInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(shareInfoDao, shareInfoBean,
				pageQueryResult);
		return pageQueryResult;
	}

	/**
	 * 获取热门分享
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#getHotList(int)
	 */
	@Override
	public List<ShareInfoBean> getHotList(int accountId) {

		List<ShareInfoBean> list = shareInfoDao.getHotList(accountId);

		return list;
	}

	/**
	 * 获取分享附件
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#getAttachInfoList(int)
	 */
	@Override
	public List<AttachInfoBean> getAttachInfoList(int shareId) {
		AttachInfoBean attachInfoBean = new AttachInfoBean();
		attachInfoBean.setShareId(shareId);

		List<AttachInfoBean> attachInfoList = attachInfoDao
				.listData(attachInfoBean);

		return attachInfoList;
	}

	/**
	 * 获取热门医问列表
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#getNewAskAnswer(com.group.webFramework.uitl.PageQueryResult)
	 */
	@Override
	public PageQueryResult<ShareInfoBean> getNewAskAnswer(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon) {

		int count = shareInfoDao.countNewAskAnswer(searchCon);

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao.listNewAskAnswer(
					pageQueryResult, searchCon);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;
	}

	/**
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#getHotAskAnswer(com.group.webFramework.uitl.PageQueryResult)
	 */
	@Override
	public PageQueryResult<ShareInfoBean> getHotAskAnswer(
			PageQueryResult<ShareInfoBean> pageQueryResult) {

		int count = shareInfoDao.countHotAskAnswer();

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao
					.listHotAskAnswer(pageQueryResult);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;
	}

	/**
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#getNoAskAnswer(com.group.webFramework.uitl.PageQueryResult)
	 */
	@Override
	public PageQueryResult<ShareInfoBean> getNoAskAnswer(
			PageQueryResult<ShareInfoBean> pageQueryResult) {

		int count = shareInfoDao.countNoAskAnswer();

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao
					.listNoAskAnswer(pageQueryResult);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;
	}

	/**
	 * 获取推荐视屏
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#listLevelVideo(com.group.webFramework.uitl.PageQueryResult)
	 */
	@Override
	public PageQueryResult<ShareInfoBean> listLevelVideo(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon) {

		int count = shareInfoDao.countLevelVideo(1, searchCon);

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao.listLevelVideo(1,
					pageQueryResult, searchCon);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;
	}

	/**
	 * 根据科室查询视屏
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#listProfessVideo(java.lang.String,
	 *      com.group.webFramework.uitl.PageQueryResult)
	 */
	@Override
	public PageQueryResult<ShareInfoBean> listProfessVideo(String profess,
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon) {

		int count = shareInfoDao.countProfessVideo(profess, 1, searchCon);

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao.listProfessVideo(profess,
					1, pageQueryResult, searchCon);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;
	}

	/**
	 * 获取推荐视屏
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#listLevelVideo(com.group.webFramework.uitl.PageQueryResult)
	 */
	@Override
	public PageQueryResult<ShareInfoBean> listLevelPoint(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon) {

		int count = shareInfoDao.countLevelVideo(2, searchCon);

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao.listLevelVideo(2,
					pageQueryResult, searchCon);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;
	}

	/**
	 * 根据科室查询视屏
	 * 
	 * @see com.group.renshi.service.share.ShareInfoService#listProfessVideo(java.lang.String,
	 *      com.group.webFramework.uitl.PageQueryResult)
	 */
	@Override
	public PageQueryResult<ShareInfoBean> listProfessPoint(String profess,
			PageQueryResult<ShareInfoBean> pageQueryResult) {

		int count = shareInfoDao.countProfessVideo(profess, 2, null);

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao.listProfessVideo(profess,
					2, pageQueryResult, null);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;
	}

	@Override
	public PageQueryResult<ShareInfoBean> listLevelCase(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon) {

		int count = shareInfoDao.countLevelVideo(3, searchCon);

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao.listLevelVideo(3,
					pageQueryResult, searchCon);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;

	}

	@Override
	public PageQueryResult<ShareInfoBean> listLevelLibrary(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon) {

		int count = shareInfoDao.countLevelVideo(4, searchCon);

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao.listLevelVideo(4,
					pageQueryResult, searchCon);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;

	}

	protected PageQueryResult pageDataUtil(BaseDao baseDao,
			BaseEntity baseEntity, PageQueryResult pageQueryResult) {
		// 获取具体javaBean的类名,并且首字母变小写
		String entityName = toFirstCharLower(baseEntity.getClass()
				.getSimpleName());
		String pageName = toFirstCharLower(pageQueryResult.getClass()
				.getSimpleName());
		// 封装分页查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 自定义param参数，可选参数
		paramMap.put(entityName, baseEntity);
		paramMap.put(pageName, pageQueryResult);
		// 查询总记录数
		int totalCount = shareInfoDao.countPageDocProductions(paramMap);
		List userList = new ArrayList();
		// 数量大于0,再进行查询数据
		if (totalCount > 0) {
			// 查询数据
			userList = shareInfoDao.pageDocProductions(paramMap);
		}
		// 设置分页查询结果
		pageQueryResult.setList(userList);
		pageQueryResult.setTotalCount(totalCount);

		return pageQueryResult;
	}

	/**
	 * @see com.group.renshi.service.share.ShareInfoService#loadReloadme()
	 */
	@Override
	public PageQueryResult<ShareInfoBean> loadReloadme(int accountId,
			PageQueryResult<ShareInfoBean> pageQueryResult) {

		int count = shareInfoDao.countRelateme(accountId);

		if (count > 0) {
			List<ShareInfoBean> list = shareInfoDao.listReloateme(accountId,
					pageQueryResult);
			pageQueryResult.setList(list);
			pageQueryResult.setTotalCount(count);
		} else {
			pageQueryResult.setList(new ArrayList<ShareInfoBean>());
			pageQueryResult.setTotalCount(0);
		}

		return pageQueryResult;
	}

	public static void main(String[] args) {
		String s = "@123 @sdfsdf,@sdfsdfsf，@q3234234";
		String[] ss = s.split(" |,|，");
		for (String string : ss) {
			System.out.println(string);
		}
	}

	/**
	 * @see com.group.renshi.service.share.ShareInfoService#getInterestVList(java.lang.String)
	 */
	@Override
	public List<ShareInfoBean> getInterestVList(// String searchType,
			String shareType, String belongDept) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 自定义param参数，可选参数
		// paramMap.put("searchType", searchType);
		if ("".equals(belongDept.trim()))
			paramMap.put("belongDept", null);
		else
			paramMap.put("belongDept", belongDept.trim());

		paramMap.put("shareType", shareType.trim());

		List<ShareInfoBean> list = shareInfoDao.getInterestVlist(paramMap);
		return list;
	}
}