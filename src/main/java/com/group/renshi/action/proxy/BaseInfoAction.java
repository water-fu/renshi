package com.group.renshi.action.proxy;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group.renshi.bean.proxy.BaseInfoBean;
import com.group.renshi.bean.proxy.LicenseInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.proxy.BaseInfoService;
import com.group.renshi.service.system.AccountInfoService;
import com.group.renshi.service.system.ValidMailService;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: BaseInfoAction.java,v 0.1 2015-06-27 下午10:57:47 Exp $
 */
@Controller
@RequestMapping("/proxy")
@Scope("prototype")
public class BaseInfoAction extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(BaseInfoAction.class);

	@Resource
	private BaseInfoService baseInfoService;

	@Resource
	private ValidMailService validMailService;

	@Resource
	private AccountInfoService accountInfoService;

	/**
	 * 跳转代理商登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView toLogin() {

		return responseResult("/system/proxyInfo/login");
	}

	/**
	 * 跳转代理商登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView toLogin2() {

		return responseResult("/system/proxyInfo/login");
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
		accountInfoBean = baseInfoService.login(request, accountInfoBean);

		return responseAjaxResult(accountInfoBean);
	}

	/**
	 * 跳转注册页面
	 * 
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "registerPage", method = RequestMethod.GET)
	public ModelAndView toRegister() {

		return responseResult("/system/proxyInfo/register");
	}

	/**
	 * 注册
	 * 
	 * @param accountInfoBean
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage register(@ModelAttribute AccountInfoBean accountInfoBean) {
		// 插入账户信息
		baseInfoService.insertAccountInfo(request, accountInfoBean);

		return responseAjaxResult(accountInfoBean);
	}

	/**
	 * 邮件激活
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "validMail", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView validMail(@RequestParam("key") String key) {
		try {
			// true表示激活成功,false表示激活失败
			AccountInfoBean accountInfoBean = validMailService.check(key, request);

			return responseResult("/system/proxyInfo/authInfo", accountInfoBean);
		} catch (Exception e) {
			if (e instanceof ApplicationException) {
				logger.error(e.getMessage(), e);

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("failMsg", e.getMessage());

				return responseResult("/system/account/active", map);
			} else {
				throw new ApplicationException(e.getMessage(), e);
			}
		}
	}

	/**
	 * 代理商认证
	 * 
	 * @param baseInfoBean
	 * @return
	 */
	@RequestMapping(value = "toAuthInfo", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView toAuthInfo(@RequestParam("id") int accountId) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(accountId);

		return responseResult("system/proxyInfo/authInfo", accountInfoBean);
	}

	/**
	 * 代理商认证
	 * 
	 * @param baseInfoBean
	 * @return
	 */
	@RequestMapping(value = "authInfo", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage authInfo(@ModelAttribute BaseInfoBean baseInfoBean,
			@ModelAttribute LicenseInfoBean licenseInfoBean) {
		if (baseInfoBean.getProxyType() == SystemConstantType.PROXY_TYPE_COMPANY) {
			baseInfoBean.setRealName(request.getParameter("realName1"));
		} else {
			baseInfoBean.setRealName(request.getParameter("realName2"));
		}

		baseInfoBean = baseInfoService.insertBaseInfo(baseInfoBean, licenseInfoBean);

		return responseAjaxResult(baseInfoBean);
	}

	/**
	 * 等待审批页面
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "toApprove", method = RequestMethod.GET)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ModelAndView toApprove(@RequestParam("id") int accountId) {
		AccountInfoBean accountInfoBean = accountInfoService.findById(accountId);

		return responseResult("/system/proxyInfo/approve", accountInfoBean);
	}
}