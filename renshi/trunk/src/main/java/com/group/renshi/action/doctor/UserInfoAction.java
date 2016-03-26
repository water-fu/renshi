package com.group.renshi.action.doctor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.renshi.bean.doctor.BookInfoBean;
import com.group.renshi.bean.doctor.ContactInfoBean;
import com.group.renshi.bean.doctor.EducationInfoBean;
import com.group.renshi.bean.doctor.MeetingInfoBean;
import com.group.renshi.bean.doctor.PatentInfoBean;
import com.group.renshi.bean.doctor.PrizeInfoBean;
import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.doctor.WorkInfoBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.bean.system.DeptInfoBean;
import com.group.renshi.cache.DeptInfoCache;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.doctor.AuthenticInfoService;
import com.group.renshi.service.doctor.BookInfoService;
import com.group.renshi.service.doctor.ContactInfoService;
import com.group.renshi.service.doctor.EducationInfoService;
import com.group.renshi.service.doctor.MeetingInfoService;
import com.group.renshi.service.doctor.PatentInfoService;
import com.group.renshi.service.doctor.PrizeInfoService;
import com.group.renshi.service.doctor.UserInfoService;
import com.group.renshi.service.doctor.WorkInfoService;
import com.group.renshi.service.share.FollowActiveService;
import com.group.renshi.service.share.PersonInfoService;
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
 * @version $Id: UserInfoAction.java,v 0.1 2015-05-25 下午09:07:32 Exp $
 */
@Controller
@RequestMapping("/doctor")
@Scope("prototype")
public class UserInfoAction extends BaseController {

	final static int HOSPITALID = 1;
	@Resource
	private AccountInfoService accountInfoService;
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private AuthenticInfoService authenticInfoService;
	@Resource
	private ContactInfoService contactInfoService;
	@Resource
	private WorkInfoService workInfoService;
	@Resource
	private EducationInfoService educationInfoService;
	@Resource
	private PersonInfoService personInfoService;

	@Resource
	private PrizeInfoService prizeInfoService;
	@Resource
	private BookInfoService bookInfoService;
	@Resource
	private PatentInfoService patentInfoService;
	@Resource
	private MeetingInfoService meetingInfoService;
	@Resource
	private FollowActiveService followActiveService;

	/**
	 * 跳转找医友页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "findDoctor", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView toFindDoctor() {
		UserDetails userDetails = SessionControl.getCurUserDetail(request);
		UserInfoBean userInfo = userDetails.getUserInfoBean();
		// 查询你可能认识的人、对你有帮助的人
		Map<String, List<UserInfoBean>> retMap = userInfoService
				.findKnowAndHelpList(userInfo);

		return responseResult("/doctor/find/findDoctor", retMap);
	}

	@RequestMapping(value = "doctorhelp", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView doctorHelp() {

		return responseResult("/doctor/find/findDoctor");
	}

	@RequestMapping(value = "doctorknow", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView doctorKnow() {

		return responseResult("/doctor/find/doctorknow");
	}

	/**
	 * 搜索医生列表
	 * 
	 * @param userInfoBean
	 * @param pageQueryResult
	 * @return
	 */
	@RequestMapping(value = "searchDoctors", method = RequestMethod.POST)
	public ModelAndView searchDoctors(
			@ModelAttribute UserInfoBean userInfoBean,
			@ModelAttribute PageQueryResult<UserInfoBean> pageQueryResult) {
		if ("".equals(userInfoBean.getRealName())) {
			userInfoBean.setRealName(null);
		}
		if ("".equals(userInfoBean.getLiveTown())) {
			userInfoBean.setLiveTown(null);
		}
		if ("".equals(userInfoBean.getBelongHospital())) {
			userInfoBean.setBelongHospital(null);
		}
		if ("".equals(userInfoBean.getBelongDept())) {
			userInfoBean.setBelongDept(null);
		}
		// 设置不等于自己条件
		// userInfoBean.setAccountId(SessionControl.getOpId(request));

		pageQueryResult = userInfoService.pageUserInfo(userInfoBean,
				pageQueryResult);

		List<UserInfoBean> list = pageQueryResult.getList();

		for (UserInfoBean userInfo : list) {
			// 处理 个人简介长度
			if (userInfo.getPersonInfro().length() >= 30)
				userInfo.setPersonInfro(userInfo.getPersonInfro().substring(0,
						30)
						+ "...");

			// 处理是否关注 借用createUser字段存储
			boolean isFollow = followActiveService.isFollowActive(request,
					userInfo.getAccountId());
			if (isFollow)
				// 返回true 表示已经关注
				userInfo.setCreateUser(1);
			else
				// 未关注
				userInfo.setCreateUser(0);
		}
		return responseResult("/doctor/find/userInfoList", pageQueryResult);
	}

	/**
	 * 跳转至第一步认证页面 调试使用
	 * 
	 * @return
	 */
	@RequestMapping(value = "toBaseInfo", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView toBaseInfo(@RequestParam("id") int accountId) {
		AccountInfoBean accountInfoBean = accountInfoService
				.findById(accountId);

		return responseResult("/doctor/userInfo/baseInfo", accountInfoBean);
	}

	/**
	 * 认证第一步保存
	 * 
	 * @param userInfoBean
	 *            个人信息
	 * @param contactInfoBean
	 *            联系信息
	 * @return
	 */
	@RequestMapping(value = "baseInfo", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage baseInfo(@ModelAttribute UserInfoBean userInfoBean,
			@ModelAttribute ContactInfoBean contactInfoBean,
			@RequestParam("headUrl") String headUrl,
			@RequestParam("profess") String profess) {

		AccountInfoBean accountInfoBean = userInfoService.baseInfo(request,
				userInfoBean, contactInfoBean, headUrl, profess);

		return responseAjaxResult(accountInfoBean);
	}

	/**
	 * 跳转至第二步认证页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAuthInfo", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView toAuthInfo(@RequestParam("id") int accountId) {
		AccountInfoBean accountInfoBean = accountInfoService
				.findById(accountId);
		return responseResult("/doctor/userInfo/authInfo", accountInfoBean);
	}

	/**
	 * 认证第二步保存
	 * 
	 * @param authenticInfoBean
	 * @return
	 */
	@RequestMapping(value = "authInfo", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage authInfo(
			@ModelAttribute AuthenticInfoBean authenticInfoBean) {
		// 插入医生的 权威认证资料
		AccountInfoBean accountInfoBean = userInfoService
				.authInfo(authenticInfoBean);

		// 缓存也设置成第三步
		SessionControl.getCurUserDetail(request).getAccountInfoBean()
				.setAccountStatus(SystemConstantType.ACCOUNT_STATUS_SECOND);

		return responseAjaxResult(accountInfoBean);
	}

	/**
	 * 跳转至第二步认证页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toApprove", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView toApprove(@RequestParam("id") int accountId) {
		AccountInfoBean accountInfoBean = accountInfoService
				.findById(accountId);

		return responseResult("/doctor/userInfo/approve", accountInfoBean);
	}

	/**
	 * 管理员审批
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "approve", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage approve(@RequestParam("id") int accountId) {
		AccountInfoBean accountInfoBean = accountInfoService.approve(request,
				accountId);

		return responseAjaxResult(accountInfoBean);
	}

	/**
	 * 根据医院编号获取科室 修改为直接获取所有科室
	 * 
	 * @param hospitalId
	 * @return
	 */
	@RequestMapping(value = "getDeptInfo", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage getDeptInfo() {// @RequestParam("hospitalId") int
											// hospitalId
		List<DeptInfoBean> deptInfoBeanList = DeptInfoCache.getInstance()
				.getSelectList(HOSPITALID);

		return responseAjaxResult(deptInfoBeanList);
	}

	/**
	 * 个人维护基本信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "toBasicInfo", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getBaseInfo(@RequestParam("id") int id) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(id);
		UserInfoBean userInfoBean = userInfoService.findById(id);
		AuthenticInfoBean authenticInfoBean = authenticInfoService.findById(id);
		ContactInfoBean contactInfoBean = contactInfoService.findById(id);

		return responseResult("doctor/userAdmin/basicInfo", accountInfoBean,
				userInfoBean, authenticInfoBean, contactInfoBean);
	}

	/**
	 * 保存基本信息
	 * 
	 * @param userInfoBean
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "saveForm1", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage saveForm1(@ModelAttribute UserInfoBean userInfoBean,
			@ModelAttribute AccountInfoBean accountInfoBean) {
		userInfoService.saveForm1(userInfoBean, accountInfoBean);

		// 更新session
		SessionControl.getCurUserDetail(request).getAccountInfoBean()
				.setHeadUrl(accountInfoBean.getHeadUrl());

		return responseAjaxResult("");
	}

	/**
	 * 保存基本信息
	 * 
	 * @param userInfoBean
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "saveForm2", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage saveForm2(@ModelAttribute UserInfoBean userInfoBean,
			@ModelAttribute AuthenticInfoBean AuthenticInfoBean) {
		userInfoService.saveForm2(userInfoBean, AuthenticInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 保存基本信息
	 * 
	 * @param userInfoBean
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "saveForm3", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage saveForm3(
			@ModelAttribute ContactInfoBean contactInfoBean) {
		userInfoService.saveForm3(contactInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "toEduWork", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView toEduWork(@RequestParam("id") int id) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(id);

		WorkInfoBean workInfoBean = new WorkInfoBean();
		workInfoBean.setAccountId(id);

		List<WorkInfoBean> list = workInfoService.listWorkInfo(workInfoBean);

		EducationInfoBean educationInfoBean = new EducationInfoBean();
		educationInfoBean.setAccountId(id);

		List<EducationInfoBean> eduList = educationInfoService
				.listEducationInfo(educationInfoBean);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("accountInfoBean", accountInfoBean);
		resultMap.put("workList", list);
		resultMap.put("eduList", eduList);

		return responseResult("doctor/userAdmin/eduwork", resultMap);
	}

	/**
	 * 
	 * 
	 * @param workInfoBean
	 * @return
	 */
	@RequestMapping(value = "addWork", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addWork(@ModelAttribute WorkInfoBean workInfoBean) {
		workInfoService.insertWorkInfo(workInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param workInfoBean
	 * @return
	 */
	@RequestMapping(value = "delWork", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage delWork(@RequestParam("id") int id) {
		workInfoService.deleteWorkInfo(id);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param workInfoBean
	 * @return
	 */
	@RequestMapping(value = "addEdu", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addEdu(
			@ModelAttribute EducationInfoBean educationInfoBean) {
		educationInfoService.insertEducationInfo(educationInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param workInfoBean
	 * @return
	 */
	@RequestMapping(value = "delEdu", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage delEdu(@RequestParam("id") int id) {
		educationInfoService.deleteEducationInfo(id);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "toCertifiCation", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getCertifiCation(@RequestParam("id") int id) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(id);
		UserInfoBean userInfoBean = userInfoService.findById(id);
		AuthenticInfoBean authenticInfoBean = authenticInfoService.findById(id);
		ContactInfoBean contactInfoBean = contactInfoService.findById(id);

		return responseResult("doctor/userAdmin/certification",
				accountInfoBean, userInfoBean, authenticInfoBean,
				contactInfoBean);
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "toSecurity", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getSecurity(@RequestParam("id") int id) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(id);

		PersonInfoBean personInfoBean = new PersonInfoBean();
		personInfoBean.setAccountId(id);
		PersonInfoBean personInfoBeanData = personInfoService.listPersonInfo(
				personInfoBean).get(0);

		return responseResult("doctor/userAdmin/security", accountInfoBean,
				personInfoBeanData);
	}

	/**
	 * 
	 * 
	 * @param oldPassword
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage changePassword(@RequestParam("id") int accountId,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("password") String password) {
		accountInfoService.changePassword(accountId, oldPassword, password);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "openSpace", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage openSpace(@RequestParam("id") int id) {
		personInfoService.openSpace(id);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "closeSpace", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage closeSpace(@RequestParam("id") int id) {
		personInfoService.closeSpace(id);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "toAchievement", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getAchievement(@RequestParam("id") int id) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(id);

		PrizeInfoBean prizeInfoBean = new PrizeInfoBean();
		prizeInfoBean.setAccountId(id);
		List<PrizeInfoBean> prizeList = prizeInfoService
				.listPrizeInfo(prizeInfoBean);

		BookInfoBean bookInfoBean = new BookInfoBean();
		bookInfoBean.setAccountId(id);
		List<BookInfoBean> bookList = bookInfoService
				.listBookInfo(bookInfoBean);

		PatentInfoBean patentInfoBean = new PatentInfoBean();
		patentInfoBean.setAccountId(id);
		List<PatentInfoBean> patentList = patentInfoService
				.listPatentInfo(patentInfoBean);

		MeetingInfoBean meetingInfoBean = new MeetingInfoBean();
		meetingInfoBean.setAccountId(id);
		List<MeetingInfoBean> meetingList = meetingInfoService
				.listMeetingInfo(meetingInfoBean);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("accountInfoBean", accountInfoBean);
		resultMap.put("prizeList", prizeList);
		resultMap.put("bookList", bookList);
		resultMap.put("patentList", patentList);
		resultMap.put("meetingList", meetingList);

		return responseResult("doctor/userAdmin/achievement", resultMap);
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "addPrize", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addPrize(@ModelAttribute PrizeInfoBean prizeInfoBean) {

		prizeInfoService.insertPrizeInfo(prizeInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "addBook", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addBook(@ModelAttribute BookInfoBean bookInfoBean) {

		bookInfoService.insertBookInfo(bookInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "addPatent", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addPatent(
			@ModelAttribute PatentInfoBean patentInfoBean) {

		patentInfoService.insertPatentInfo(patentInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "addMeeting", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addMeeting(
			@ModelAttribute MeetingInfoBean meetingInfoBean) {

		meetingInfoService.insertMeetingInfo(meetingInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delPrize", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage delPrize(@RequestParam("id") int id) {

		prizeInfoService.deletePrizeInfo(id);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delBook", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage delBook(@RequestParam("id") int id) {

		bookInfoService.deleteBookInfo(id);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delPatent", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage delPatent(@RequestParam("id") int id) {

		patentInfoService.deletePatentInfo(id);

		return responseAjaxResult("");
	}

	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delMeeting", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage delMeeting(@RequestParam("id") int id) {

		meetingInfoService.deleteMeetingInfo(id);

		return responseAjaxResult("");
	}

	// 查找已经认证通过的医生--后台调用
	@RequestMapping(value = "serarchApprovedDoc", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> serarchApprovedDoc(int page, int rows,
			String realName) {

		UserInfoBean userInfoBean = new UserInfoBean();
		if (null == realName) {
			userInfoBean.setRealName(" ");
		} else {
			userInfoBean.setRealName(realName);
		}
		PageQueryResult<UserInfoBean> pageQueryResult = new PageQueryResult<UserInfoBean>();
		pageQueryResult = userInfoService.pageUserInfo(userInfoBean,
				pageQueryResult);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pageQueryResult.getTotalCount());
		map.put("rows", pageQueryResult.getList());
		return map;
	}

	@RequestMapping(value = "changePasswordForAdmin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage changePasswordForAdmin(int accountId,
			String oldPassword, String password) {
		accountInfoService.changePassword(accountId, oldPassword, password);
		return responseAjaxResult("");
	}
}