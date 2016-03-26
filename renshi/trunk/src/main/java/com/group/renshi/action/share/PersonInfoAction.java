package com.group.renshi.action.share;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.renshi.bean.doctor.BookInfoBean;
import com.group.renshi.bean.doctor.EducationInfoBean;
import com.group.renshi.bean.doctor.MeetingInfoBean;
import com.group.renshi.bean.doctor.PatentInfoBean;
import com.group.renshi.bean.doctor.PrizeInfoBean;
import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.doctor.WorkInfoBean;
import com.group.renshi.bean.share.AttachInfoBean;
import com.group.renshi.bean.share.FollowActiveBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.dao.share.PersonInfoDao;
import com.group.renshi.service.doctor.AuthenticInfoService;
import com.group.renshi.service.doctor.BookInfoService;
import com.group.renshi.service.doctor.EducationInfoService;
import com.group.renshi.service.doctor.MeetingInfoService;
import com.group.renshi.service.doctor.PatentInfoService;
import com.group.renshi.service.doctor.PrizeInfoService;
import com.group.renshi.service.doctor.UserInfoService;
import com.group.renshi.service.doctor.WorkInfoService;
import com.group.renshi.service.share.FollowActiveService;
import com.group.renshi.service.share.PersonInfoService;
import com.group.renshi.service.share.ShareInfoService;
import com.group.renshi.service.system.AccountInfoService;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.entity.UserDetails;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.ResponseMessage;
import com.group.webFramework.uitl.SessionControl;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: PersonInfoAction.java,v 0.1 2015-06-09 下午08:53:43 Exp $
 */
@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class PersonInfoAction extends BaseController {

	@Resource
	private PersonInfoService personInfoService;

	@Resource
	private ShareInfoService shareInfoService;

	@Resource
	private AccountInfoService accountInfoService;

	@Resource
	private UserInfoService userInfoService;

	@Resource
	private AuthenticInfoService authenticInfoService;

	@Resource
	private FollowActiveService followActiveService;

	@Resource
	private WorkInfoService workInfoService;

	@Resource
	private EducationInfoService educationInfoService;

	@Resource
	private PrizeInfoService prizeInfoService;

	@Resource
	private BookInfoService bookInfoService;

	@Resource
	private PatentInfoService patentInfoService;

	@Resource
	private MeetingInfoService meetingInfoService;

	@Resource
	protected PersonInfoDao personInfoDao;

	/**
	 * 获取每个模块的最活跃用户
	 * 
	 * @param shareType
	 * @return
	 */
	@RequestMapping(value = "getMostActPerson", method = RequestMethod.GET)
	// @LoginFilter(needLogin = true)
	public ModelAndView getMostActPerson(
			@RequestParam("shareType") String shareType) {
		// 结果返回
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 获取最活跃用户列表
		List<PersonInfoBean> userInfoList = personInfoService.findMostPerson(shareType);
		// 登录后查看视频列表
		if (SessionControl.getCurUserDetail(request) != null)
			for (PersonInfoBean userInfo : userInfoList) {
				// 处理是否关注 借用PersonActive字段存储
				boolean isFollow = followActiveService.isFollowActive(request,
						userInfo.getAccountId());
				if (isFollow)
					// 返回true 表示已经关注
					userInfo.setPersonActive(1);
				else
					// 未关注
					userInfo.setPersonActive(0);
			}
		else {
			// 未登录查看视频列表 不显示关注和个人空间
			resultMap.put("loginTrue", 1);
		}

		resultMap.put("mostActPerson", userInfoList);
		// 选择url
		String url = "/share/common/mostActPerson";
		if ("1".equals(shareType))
			// 视频
			url = "/share/video/mostActPerson";
		else if ("2".equals(shareType.trim()))
			// 观点
			url = "/share/point/mostActPerson";
		else if ("3".equals(shareType.trim()))
			// 病例
			url = "/share/case/mostActPerson";
		else if ("4".equals(shareType.trim()))
			// 文库
			url = "/share/library/mostActPerson";
		return responseResult(url, resultMap);
	}
	/**
	 * 空间首页
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "{accountId}", method = RequestMethod.GET)
	// @LoginFilter(needLogin = true)
	public ModelAndView personSpace(@PathVariable("accountId") int accountId) {

		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		int perstatus = personInfoBean.getPersonStatus();
		// -----原来
		// 如果不是当前用户访问自己的空间 且空间不对外开放时 提醒无权限访问
		// if (perstatus == SystemConstantType.PERSON_STATUS_CLOSE) {
		// Map<String, Object> personId = new HashMap<String, Object>();
		// personId.put("accountIDwithPerson", personInfoBean.getAccountId());
		// return responseResult("error/404", personId);
		// }
		// ------原来end
		UserDetails userDetails = SessionControl.getCurUserDetail(request);

		// 如果不是当前登录用户
		if (userDetails == null
				|| userDetails.getAccountInfoBean().getAccountId() != accountId) {
			// 如果不是当前用户访问自己的空间 且空间不对外开放时 提醒无权限访问
			if (perstatus == SystemConstantType.PERSON_STATUS_CLOSE) {
				Map<String, Object> personId = new HashMap<String, Object>();
				personId.put("accountIDwithPerson",
						personInfoBean.getAccountId());
				return responseResult("error/404", personId);
			}
			// 更新空间热度+1
			personInfoService.updateBrowerNum(personInfoBean);

			return responseResult("/share/person/userAccess", personInfoBean);
		}

		return responseResult("/share/person/person", personInfoBean);
	}

	/**
	 * 加载空间头部信息
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "getScroll", method = RequestMethod.GET)
	// @LoginFilter(needLogin = true)
	public ModelAndView getScroll(@RequestParam("accountId") int accountId) {
		// 账户信息、用户信息、认证信息
		AccountInfoBean accountInfoBean = accountInfoService
				.findById(accountId);
		UserInfoBean userInfoBean = userInfoService.findById(accountId);
		AuthenticInfoBean authenticInfoBean = authenticInfoService
				.findById(accountId);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("accountInfoBean", accountInfoBean);
		resultMap.put("userInfoBean", userInfoBean);
		resultMap.put("authenticInfoBean", authenticInfoBean);

		// 如果不是当前登录用户,则需要判断是否已关注
		if (SessionControl.getCurUserDetail(request) != null
				&& accountId != SessionControl.getOpId(request)) {
			// 是否关注
			boolean isFollow = followActiveService.isFollowActive(request,
					accountId);
			resultMap.put("isFollow", isFollow);
		} else {
			resultMap.put("isFollow", false);
		}

		return responseResult("/share/common/scroll", resultMap);
	}
	/**
	 * 删除 发布的作品 包括视频、文档等5种
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "delContent", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage delContent(
			@RequestParam("shareId") int shareId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			shareInfoService.deleteShareInfo(shareId);
			resultMap.put("shareId", shareId);
			return responseAjaxResult(resultMap);
		} catch (Exception e) {
			resultMap.put("shareId", -1);
			resultMap.put("msg", e.toString());
			return responseAjaxResult(resultMap);
		}
	}
	// ////////////////////////////star
	// /**
	// * 获取分享内容
	// *
	// * @param accountId
	// * @return
	// */
	// @RequestMapping(value = "getContent", method = RequestMethod.GET)
	// public ModelAndView getContent(@ModelAttribute ShareInfoBean
	// shareInfoBean,
	// @ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult,
	// @RequestParam("searchType") String searchType) {
	//
	// pageQueryResult = shareInfoService.pageShareInfo(shareInfoBean,
	// pageQueryResult, searchType, request);
	//
	// List<ShareInfoBean> list = pageQueryResult.getList();
	// if (list != null && 0 != list.size()) {
	// for (ShareInfoBean bean : list) {
	// if (bean.getShareDesc().length() > 200) {
	// bean.setShareDesc(bean.getShareDesc().substring(0, 200)
	// + "......");
	// }
	// }
	// }
	//
	// return responseResult("/share/common/content", pageQueryResult);
	// }
	// ///////////////////////////////以上部分为原来代码 修改者金天阳 7/30
	// /////////////////////end
	/**
	 * 获取分享内容 我的主页 和 他的主页 默认显示的作品列表
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "getContent", method = RequestMethod.GET)
	public ModelAndView getContent(
			@ModelAttribute ShareInfoBean shareInfoBean,
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult,
			@RequestParam("searchType") String searchType,
			@RequestParam(value = "shareTime", required = false) String shareTime) {
		Date date = new Date();// 当前日期
		Calendar calendar = Calendar.getInstance();// 日历对象
		calendar.setTime(date);// 设置当前日期

		// 做测试用//start
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");// 格式化对象
		// (sdf.format(calendar.getTime()));// 输出格式化的日期
		// 做测试用//end

		java.util.Date utilDate = null;
		java.sql.Date sqlDate = null;
		// 事实上shareTIME 一定不会为空 在前端已经处理 如果为空 则值为-1
		if (null != shareTime) {
			if ("1".equals(shareTime)) {// 如果是近一个月份
				calendar.add(Calendar.MONTH, -1);// 月份减一
				utilDate = calendar.getTime();
				// month
			} else if ("2".equals(shareTime)) {// 如果是近一周
				// calendar.add(Calendar.DAY_OF_YEAR, -1);//日期减一//做测试用
				calendar.add(Calendar.WEDNESDAY, -1);
				utilDate = calendar.getTime();
				// week
			}
			// 如果以上两种情况都不是 则一定为-1，此时为查询全部 ，utilDate为null
			if (utilDate != null)
				sqlDate = new java.sql.Date(utilDate.getTime());
		}
		// 原来的方法为shareInfoService.pageShareInfo(shareInfoBean,
		// pageQueryResult, searchType, request)
		// 也可以用，没有删除
		pageQueryResult = shareInfoService.pageShareInfoWithTime(shareInfoBean,
				pageQueryResult, searchType, sqlDate, request);
		// author---star 陈锦辉-----控制内容显示长度
		List<ShareInfoBean> list = pageQueryResult.getList();
		if (list != null && 0 != list.size()) {
			for (ShareInfoBean bean : list) {
				if (bean.getShareDesc().length() > 200) {
					bean.setShareDesc(bean.getShareDesc().substring(0, 200)
							+ "......");
				}
			}
		}
		// ---end 控制内容显示长度
		return responseResult("/share/common/content", pageQueryResult);
	}
	/**
	 * 获取分享内容 详情页的 列表展示
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "getContentForDetail", method = RequestMethod.POST)
	public ModelAndView getContentForVideoDetail(
			@RequestParam("shareType") String shareType,
			@RequestParam("belongDept") String belongDept) {
		List<ShareInfoBean> interestList = shareInfoService.getInterestVList(
				shareType, belongDept);
		// jty 标题过长时 截取6个字符 在侧边栏显示的中文字符最长为5个文字 加上一个“。。。”
		for (ShareInfoBean shareInfo : interestList)
		{
			if (shareInfo.getShareTitle().length() >= 6)
			{
				shareInfo.setShareTitle(shareInfo.getShareTitle().substring(0, 5) + "...");
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("interestList", interestList);
		String url = "/common/getInterestList";
		// shareType 在前端赋值 不肯为空
		if ("1".equals(shareType))
			// 视频
			url = "/share/video/getInterestList";
		else if ("2".equals(shareType.trim()))
			// 观点
			url = "/share/point/getInterestList";
		else if ("3".equals(shareType.trim()))
			// 病例
			url = "/share/case/getInterestList";
		else if ("4".equals(shareType.trim()))
			// 文库
			url = "/share/library/getInterestList";
		else if ("5".equals(shareType.trim()))
			// 提问
			url = "/share/askanswer/getInterestList";
		return responseResult(url, resultMap);
	}
	/**
	 * 获取视频列表页的【猜您喜欢】列表
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "getContentForVideoLike", method = RequestMethod.POST)
	public ModelAndView getContentForVideoLike(
			@RequestParam("shareType") String shareType,
			@RequestParam(value = "belongDept", required = false) String belongDept) {

		// shareType 为1 视频
		List<ShareInfoBean> interestList = shareInfoService.getInterestVList(
				shareType, belongDept);

		// jty 标题过长时 截取6个字符 在侧边栏显示的中文字符最长为5个文字 加上一个“。。。”
		for (ShareInfoBean shareInfo : interestList)
		{
			if (shareInfo.getShareTitle().length() >= 6)
			{
				shareInfo.setShareTitle(shareInfo.getShareTitle().substring(0, 5) + "...");
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("LikeList", interestList);
		String url = "";
		if ("1".equals(shareType))
			url = "/share/video/videoLikeList";
		if ("2".equals(shareType))
			url = "/share/point/pointLikeList";
		if ("3".equals(shareType))
			url = "/share/case/caseLikeList";
		if ("4".equals(shareType))
			url = "/share/library/libraryLikeList";
		return responseResult(url, resultMap);
	}
	/**
	 * 获取热门列表
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "getHotList", method = RequestMethod.GET)
	public ModelAndView getHotList(@RequestParam("accountId") int accountId) {

		List<ShareInfoBean> hotList = shareInfoService.getHotList(accountId);
		// jty 标题过长时 截取8个字符
		for (ShareInfoBean shareInfo : hotList)
		{
			if (shareInfo.getShareTitle().length() >= 9)
			{
				shareInfo.setShareTitle(shareInfo.getShareTitle().substring(0, 8) + "...");
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("hotList", hotList);

		return responseResult("/share/common/hotList", resultMap);
	}

	/**
	 * 获取分享附件信息
	 * 
	 * @param shareId
	 * @return
	 */
	@RequestMapping(value = "getShareAttach", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage getShareAttach(@RequestParam("shareId") int shareId) {

		List<AttachInfoBean> attachInfoList = shareInfoService
				.getAttachInfoList(shareId);

		return responseAjaxResult(attachInfoList);
	}

	/**
	 * 获取左侧个人信息
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "getPersonLeftCon", method = RequestMethod.GET)
	// @LoginFilter(needLogin = true)
	public ModelAndView getPersonLeftCon(
			@RequestParam("accountId") int accountId) {
		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		return responseResult("/share/common/left", personInfoBean);
	}

	/**
	 * 获取我的成就
	 * 
	 * @return
	 */
	@RequestMapping(value = "{accountId}/achievement.htm")
	@LoginFilter(needLogin = true)
	public ModelAndView getAchievememt(@PathVariable("accountId") int accountId) {
		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		PrizeInfoBean prizeInfoBean = new PrizeInfoBean();
		prizeInfoBean.setAccountId(accountId);
		List<PrizeInfoBean> prizeList = prizeInfoService
				.listPrizeInfo(prizeInfoBean);

		BookInfoBean bookInfoBean = new BookInfoBean();
		bookInfoBean.setAccountId(accountId);
		List<BookInfoBean> bookList = bookInfoService
				.listBookInfo(bookInfoBean);

		PatentInfoBean patentInfoBean = new PatentInfoBean();
		patentInfoBean.setAccountId(accountId);
		List<PatentInfoBean> patentList = patentInfoService
				.listPatentInfo(patentInfoBean);

		MeetingInfoBean meetingInfoBean = new MeetingInfoBean();
		meetingInfoBean.setAccountId(accountId);
		List<MeetingInfoBean> meetingList = meetingInfoService
				.listMeetingInfo(meetingInfoBean);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("personInfoBean", personInfoBean);
		resultMap.put("prizeList", prizeList);
		resultMap.put("bookList", bookList);
		resultMap.put("patentList", patentList);
		resultMap.put("meetingList", meetingList);

		return responseResult("/share/person/achieve", resultMap);
	}

	/**
	 * 获取我的作品
	 * 
	 * @return
	 */
	@RequestMapping(value = "{accountId}/share.htm")
	@LoginFilter(needLogin = true)
	public ModelAndView getShare(@PathVariable("accountId") int accountId) {
		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		return responseResult("/share/person/publish", personInfoBean);
	}

	/**
	 * 获取我的医问
	 * 
	 * @return
	 */
	@RequestMapping(value = "{accountId}/qa.htm")
	@LoginFilter(needLogin = true)
	public ModelAndView getAnswer(@PathVariable("accountId") int accountId) {
		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		return responseResult("/share/person/answer", personInfoBean);
	}

	/**
	 * 获取与我相关内容
	 * 
	 * @return
	 */
	@RequestMapping(value = "{accountId}/relateme")
	@LoginFilter(needLogin = true)
	public ModelAndView getRelateme(@PathVariable("accountId") int accountId) {
		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		return responseResult("/share/person/relateme", personInfoBean);
	}

	/**
	 * 关于我
	 */
	@RequestMapping(value = "{accountId}/about.htm", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView aboutMe(@PathVariable("accountId") int accountId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		AccountInfoBean accountInfoBean = accountInfoService
				.findById(accountId);
		resultMap.put("accountInfoBean", accountInfoBean);

		UserInfoBean userInfoBean = userInfoService.findById(accountId);
		resultMap.put("userInfoBean", userInfoBean);

		AuthenticInfoBean authenticInfoBean = authenticInfoService
				.findById(accountId);
		resultMap.put("authenticInfoBean", authenticInfoBean);

		WorkInfoBean reqBean = new WorkInfoBean();
		reqBean.setAccountId(accountId);
		List<WorkInfoBean> workInfoBeanList = workInfoService
				.listWorkInfo(reqBean);
		resultMap.put("workInfoBeanList", workInfoBeanList);

		EducationInfoBean reqBean2 = new EducationInfoBean();
		reqBean2.setAccountId(accountId);
		List<EducationInfoBean> educationInfoBeanList = educationInfoService
				.listEducationInfo(reqBean2);
		resultMap.put("educationInfoBeanList", educationInfoBeanList);

		return responseResult("/share/person/aboutme", resultMap);
	}

	/**
	 * 跳转到粉丝列表页面 并查询
	 */
	@RequestMapping(value = "{accountId}/fans.htm", method = RequestMethod.GET)
	public ModelAndView fans(@PathVariable("accountId") int accountId) {
		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setFollowAccount(accountId);// 查询我的粉丝
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("accountIdForFans", accountId);//
		return responseResult("/share/person/fans", resultMap);
	}

	// 获取分页数据 在粉丝列表查询 根据用户名模糊查询

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/pagefansWithName", method = RequestMethod.POST)
	public ModelAndView PagefansWithName(int accountId, int pageNo,
			String queryCondition, String fansName) {
		PageQueryResult<Map> pageQueryResult = new PageQueryResult<Map>();
		pageQueryResult.setPageNo(pageNo);
		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setFollowAccount(accountId);// 查询我的粉丝
		followActiveBean.setQueryCondition(queryCondition);
		followActiveBean.setSearchtype(SystemConstantType.FANS);// 设置搜索类型为粉丝
		pageQueryResult = followActiveService.pageFollowActiveWithName(
				followActiveBean, pageQueryResult, fansName, request);
		List<Map> list = pageQueryResult.getList();

		for (Map map : list) {

			// 处理是否关注 借用createUser字段存储
			boolean isFollow = followActiveService.isFollowActive(request,
					(Integer) map.get("ACCOUNT_ID"));
			if (isFollow)
				// 返回true 表示已经关注
				map.put("isFollow", 1);
			else
				// 未关注
				map.put("isFollow", 0);
		}
		return responseResult("/share/person/fansListForSearchName",
				pageQueryResult);
	}

	// 获取分页数据 查询所有的粉丝 我的主页和他的主页通用
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/pagefans", method = RequestMethod.GET)
	public ModelAndView Pagefans(int accountId, int pageNo,
			String queryCondition, String fansName) {
		PageQueryResult<Map> pageQueryResult = new PageQueryResult<Map>();
		pageQueryResult.setPageNo(pageNo);
		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setFollowAccount(accountId);// 查询我的粉丝
		followActiveBean.setQueryCondition(queryCondition);
		followActiveBean.setSearchtype(SystemConstantType.FANS);// 设置搜索类型为粉丝
		pageQueryResult = followActiveService.pageFollowActive(
				followActiveBean, pageQueryResult);
		List<Map> list = pageQueryResult.getList();

		for (Map map : list) {

			// 处理是否关注 借用createUser字段存储
			boolean isFollow = followActiveService.isFollowActive(request,
					(Integer) map.get("ACCOUNT_ID"));
			if (isFollow)
				// 返回true 表示已经关注
				map.put("isFollow", 1);
			else
				// 未关注
				map.put("isFollow", 0);
		}
		return responseResult("/share/person/fansList",
				pageQueryResult);
	}

	/**
	 * 跳转到关注页面 并查询
	 */
	@RequestMapping(value = "{accountId}/interest.htm", method =
			RequestMethod.GET)
	public ModelAndView interest(@PathVariable("accountId") int accountId) {

		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setAccountId(accountId);// 查询我的关注
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("accountIdForInterest", accountId);//
		return responseResult("/share/person/interest", resultMap);
	}
	// 获取分页数据 在关注列表中查询 在关注列表中根据用户名模糊查询关注的人
	@RequestMapping(value = "/pageInteWithName", method = RequestMethod.POST)
	public ModelAndView pageInterestsWithName(int accountId, int pageNo,
			String queryCondition, String concernName) {
		PageQueryResult<Map> pageQueryResult = new PageQueryResult<Map>();
		pageQueryResult.setPageNo(pageNo);
		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setAccountId(accountId);// 查询我的关注
		followActiveBean.setQueryCondition(queryCondition);
		followActiveBean.setSearchtype(SystemConstantType.CONCERN);// 设置搜索类型为关注
		pageQueryResult = followActiveService.pageFollowActiveWithName(
				followActiveBean, pageQueryResult, concernName, request);

		// 已经关注的列表 肯定是已经关注的 下面的代码不需要 但是可以保留
		List<Map> list = pageQueryResult.getList();
		for (Map map : list) {

			// 处理是否关注 借用createUser字段存储
			boolean isFollow = followActiveService.isFollowActive(request,
					(Integer) map.get("FOLLOW_ACCOUNT"));
			if (isFollow)
				// 返回true 表示已经关注
				map.put("isFollow", 1);
			else
				// 未关注
				map.put("isFollow", 0);
		}

		return responseResult("/share/person/interestListForSearchName",
				pageQueryResult);
	}
	// 获取分页数据 在关注列表中查询 获取所有的关注 我的主页和他的主页通用
	@RequestMapping(value = "/pageInterests", method = RequestMethod.GET)
	public ModelAndView pageInterests(int accountId, int pageNo,
			String queryCondition) {
		PageQueryResult<Map> pageQueryResult = new PageQueryResult<Map>();
		pageQueryResult.setPageNo(pageNo);
		FollowActiveBean followActiveBean = new FollowActiveBean();
		followActiveBean.setAccountId(accountId);// 查询我的关注
		followActiveBean.setQueryCondition(queryCondition);
		followActiveBean.setSearchtype(SystemConstantType.CONCERN);// 设置搜索类型为关注
		pageQueryResult = followActiveService.pageFollowActive(
				followActiveBean, pageQueryResult);
		List<Map> list = pageQueryResult.getList();
		// 已经关注的列表 肯定是已经关注的 下面的代码不需要 但是可以保留
		for (Map map : list) {

			// 处理是否关注 借用createUser字段存储
			boolean isFollow = followActiveService.isFollowActive(request,
					(Integer) map.get("FOLLOW_ACCOUNT"));
			if (isFollow)
				// 返回true 表示已经关注
				map.put("isFollow", 1);
			else
				// 未关注
				map.put("isFollow", 0);
		}
		return responseResult("/share/person/interestList",
				pageQueryResult);
	}
	/**
	 * 获取最新医问列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "newAskAnswer")
	public ModelAndView getNewAskAnswer(
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult,
			@RequestParam(value = "searchCon", required = false) String searchCon) {
		if ("".equals(searchCon)) {
			searchCon = null;
		}

		// 获取医问医答列表
		PageQueryResult<ShareInfoBean> newAsk = shareInfoService
				.getNewAskAnswer(pageQueryResult, searchCon);

		return responseResult("/share/askanswer/answerContent", newAsk);
	}

	/**
	 * 获取最新医问列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "hotAskAnswer", method = RequestMethod.GET)
	public ModelAndView getHotAskAnswer(
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult) {
		PageQueryResult<ShareInfoBean> newAsk = shareInfoService
				.getHotAskAnswer(pageQueryResult);

		return responseResult("/share/askanswer/answerContent", newAsk);
	}

	/**
	 * 获取最新医问列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "noAskAnswer", method = RequestMethod.GET)
	public ModelAndView getNoAskAnswer(
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult) {
		PageQueryResult<ShareInfoBean> newAsk = shareInfoService
				.getNoAskAnswer(pageQueryResult);

		return responseResult("/share/askanswer/answerContent", newAsk);
	}

	/**
	 * 查询医问医答详细页面
	 * 
	 * @param shareId
	 * @return
	 */
	@RequestMapping(value = "askDetail", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getAskAnswer(@RequestParam("id") int shareId) {
		ShareInfoBean shareInfoBean = shareInfoService.loadExtend(shareId);

		return responseResult("/share/askanswer/askdetail", shareInfoBean);
	}

	/**
	 * 与我相关
	 * 
	 * @return
	 */
	@RequestMapping(value = "{accountId}/relateme", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView myRelateMe(@PathVariable("accountId") int accountId,
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult) {

		int opId = SessionControl.getOpId(request);
		PersonInfoBean personInfoBean = personInfoService.findByAccountId(opId);

		pageQueryResult = shareInfoService.loadReloadme(opId, pageQueryResult);
		return responseResult("/share/person/relateme", pageQueryResult,
				personInfoBean);
	}
}