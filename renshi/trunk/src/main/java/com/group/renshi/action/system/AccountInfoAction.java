package com.group.renshi.action.system;

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

import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.share.PersonInfoService;
import com.group.renshi.service.system.AccountInfoService;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.common.BaseController;
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
 * @version $Id: AccountInfoAction.java,v 0.1 2015-05-22 下午02:29:01 Exp $
 */
@RequestMapping("/system")
@Controller
@Scope("prototype")
public class AccountInfoAction extends BaseController {

	@Resource
	private PersonInfoService personInfoService;

	@Resource
	private AccountInfoService accountInfoService;

	@RequestMapping(value = "achieve", method = RequestMethod.GET)
	public ModelAndView myAchieve() {

		return responseResult("/share/person/achieve");
	}

	@RequestMapping(value = "answer", method = RequestMethod.GET)
	public ModelAndView myAnswer() {

		return responseResult("/share/person/answer");
	}

	@RequestMapping(value = "messageList", method = RequestMethod.GET)
	public ModelAndView myMessageList() {

		return responseResult("/share/person/messageList");
	}

	@RequestMapping(value = "publish", method = RequestMethod.GET)
	public ModelAndView myPublish() {

		return responseResult("/share/person/publish");
	}

	@RequestMapping(value = "collect", method = RequestMethod.GET)
	public ModelAndView myCollect() {

		return responseResult("/share/person/collect");
	}

	@RequestMapping(value = "praise", method = RequestMethod.GET)
	public ModelAndView myPraise() {

		return responseResult("/share/person/praise");
	}

	@RequestMapping(value = "useraccess", method = RequestMethod.GET)
	public ModelAndView userAccess() {

		return responseResult("/share/person/userAccess");
	}

	@RequestMapping(value = "messageDialog", method = RequestMethod.GET)
	public ModelAndView messageDialog() {

		return responseResult("/share/person/messageDialog");
	}

	@RequestMapping(value = "askanswer", method = RequestMethod.GET)
	public ModelAndView askAnswer() {
		// 获取最权威医生
		List<PersonInfoBean> userInfoList = personInfoService.findMostAnswer();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mostAnswerUser", userInfoList);

		return responseResult("/share/askanswer/askanswer", map);
	}

	@RequestMapping(value = "askdetail", method = RequestMethod.GET)
	public ModelAndView askDetail() {

		return responseResult("/share/askanswer/askdetail");
	}

	@RequestMapping(value = "asklist", method = RequestMethod.GET)
	public ModelAndView asklist() {

		return responseResult("/share/askanswer/asklist");
	}

	@RequestMapping(value = "case", method = RequestMethod.GET)
	public ModelAndView casepage() {

		return responseResult("/share/case/case");
	}

	@RequestMapping(value = "casedetail", method = RequestMethod.GET)
	public ModelAndView casedetail() {

		return responseResult("/share/case/casedetail");
	}

	@RequestMapping(value = "point", method = RequestMethod.GET)
	public ModelAndView point() {

		return responseResult("/share/point/point");
	}

	@RequestMapping(value = "pointdetail", method = RequestMethod.GET)
	public ModelAndView pointDetail() {

		return responseResult("/share/point/pointdetail");
	}

	@RequestMapping(value = "pointlist", method = RequestMethod.GET)
	public ModelAndView pointlist() {

		return responseResult("/share/point/pointlist");
	}

	@RequestMapping(value = "video", method = RequestMethod.GET)
	public ModelAndView video() {

		return responseResult("/share/video/video");
	}

	@RequestMapping(value = "videodetail", method = RequestMethod.GET)
	public ModelAndView videoDetail() {

		return responseResult("/share/video/videodetail");
	}

	@RequestMapping(value = "videolist", method = RequestMethod.GET)
	public ModelAndView videolist() {

		return responseResult("/share/video/videolist");
	}

	@RequestMapping(value = "library", method = RequestMethod.GET)
	public ModelAndView library() {

		return responseResult("/share/library/library");
	}

	@RequestMapping(value = "librarydetail", method = RequestMethod.GET)
	public ModelAndView libraryDetail() {
		return responseResult("/share/library/librarydetail");
	}

	/**
	 * 跳转注册页面
	 * 
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "registerPage", method = RequestMethod.GET)
	public ModelAndView toRegister() {

		return responseResult("/system/accountInfo/register");
	}

	/**
	 * 注册
	 * 
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage register(
			@ModelAttribute AccountInfoBean accountInfoBean) {
		try {
			// 插入账户信息
			accountInfoService.insertAccountInfo(request, accountInfoBean);

			return responseAjaxResult(accountInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 校验用户名
	 * 
	 * @return
	 */
	@RequestMapping(value = "validAccName", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage validateAccountName(
			@RequestParam("name") String loginAccount) {
		try {
			boolean flag = accountInfoService.validateAccountName(loginAccount);

			return responseAjaxResult(flag);

		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 跳转邮件激活页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "activePage", method = RequestMethod.GET)
	public ModelAndView toActive(@RequestParam("id") int accountId) {

		AccountInfoBean accountInfoBean = accountInfoService
				.findById(accountId);

		return responseResult("/system/accountInfo/active", accountInfoBean);
	}

	/**
	 * 跳转登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "loginPage", method = RequestMethod.GET)
	public ModelAndView toLogin() {

		return responseResult("system/accountInfo/login");
	}

	/**
	 * 登录
	 * 
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage login(@ModelAttribute AccountInfoBean accountInfoBean) {
		try {
			accountInfoBean = accountInfoService
					.login(request, accountInfoBean);
			return responseAjaxResult(accountInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}

	}

	/**
	 * 跳转忘记密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAccount", method = RequestMethod.GET)
	public ModelAndView toAccount() {

		return responseResult("/system/accountInfo/account");
	}

	/**
	 * 确认账号提交
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "account", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage account(
			@RequestParam("accountName") String accountName) {
		try {
			// 确认账号
			AccountInfoBean accountInfoBean = accountInfoService
					.confirmAccount(accountName);

			return responseAjaxResult(accountInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}

	}

	/**
	 * 跳转验证身份页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toValidate", method = RequestMethod.GET)
	public ModelAndView toValidate(@RequestParam("id") String accountId) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(Integer
				.parseInt(accountId));

		// 对账号地址加密
		String loginAccount = accountInfoBean.getLoginAccount();
		String first = loginAccount.substring(0, loginAccount.indexOf("@"));

		StringBuffer account = new StringBuffer();
		account.append(first.substring(0, 2)).append("...")
				.append(first.substring(first.length() - 2))
				.append(loginAccount.substring(loginAccount.indexOf("@")));

		accountInfoBean.setLoginAccount(account.toString());

		return responseResult("/system/accountInfo/validate", accountInfoBean);
	}

	/**
	 * 忘记密码发送邮件
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "sendValidateMail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage sendValidateMail(@RequestParam("id") int accountId) {
		try {
			accountInfoService.sendValidateMail(request, accountId);

			return responseAjaxResult("");
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 忘记密码发送邮件
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "sendRegisterMail", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage sendRegisterMail() {
		try {
			accountInfoService.sendRegisterMail(request);

			return responseAjaxResult("");
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 重置密码页面
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "toResetPwd", method = RequestMethod.GET)
	public ModelAndView toResetPwd(@RequestParam("id") String accountId) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(Integer
				.parseInt(accountId));

		return responseResult("/system/accountInfo/resetPwd", accountInfoBean);
	}

	/**
	 * 重置密码
	 * 
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "resetPwd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage resetPwd(
			@ModelAttribute AccountInfoBean accountInfoBean,
			@RequestParam("key") String key) {
		try {
			accountInfoBean = accountInfoService.resetPwd(request,
					accountInfoBean, key);

			return responseAjaxResult(accountInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		SessionControl
				.removeAttribute(request, SystemConstantType.USER_DETAILS);

		return responseResult("system/accountInfo/login");
	}

	/**
	 * 邮箱绑定重置发送邮件
	 * @author CJH
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "sendResetMail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage sendValidateMail(
			@RequestParam("newEmail") String newMail) {
		accountInfoService.sendResetMailMail(newMail, request);

		return responseAjaxResult("");
	}
}