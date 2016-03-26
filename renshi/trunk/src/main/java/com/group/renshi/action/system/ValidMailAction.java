package com.group.renshi.action.system;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.system.ValidMailService;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.exception.ApplicationException;

/**
 * 总体说明 邮件激活页面
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: ValidMailAction.java,v 0.1 2015-05-24 下午03:56:53 Exp $
 */
@RequestMapping("/system")
@Controller
@Scope("prototype")
public class ValidMailAction extends BaseController {

	private static Logger logger = LoggerFactory
			.getLogger(ValidMailAction.class);

	@Resource
	private ValidMailService validMailServie;

	/**
	 * 邮件激活
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "validMail", method = RequestMethod.GET)
	public ModelAndView validMail(@RequestParam("key") String key,
			HttpServletResponse response) {
		try {
			// true表示激活成功,false表示激活失败
			AccountInfoBean accountInfoBean = validMailServie.check(key,
					request);

			// 认证步骤
			switch (accountInfoBean.getAccountStatus()) {
			// 未认证，跳转到第一步
			case SystemConstantType.ACCOUNT_STATUS_ZERO:
				response.sendRedirect(request.getContextPath()
						+ "/doctor/toBaseInfo?id="
						+ accountInfoBean.getAccountId());
				break;
			// 第一步已认证，跳转到第二步
			case SystemConstantType.ACCOUNT_STATUS_FIRST:
				response.sendRedirect(request.getContextPath()
						+ "/doctor/toAuthInfo?id="
						+ accountInfoBean.getAccountId());
				break;
			// 第二步已认证，跳转到第三步
			case SystemConstantType.ACCOUNT_STATUS_SECOND:
				response.sendRedirect(request.getContextPath()
						+ "/doctor/toApprove?id="
						+ accountInfoBean.getAccountId());
				break;
			case SystemConstantType.ACCOUNT_STATUS_THIRD:
				response.sendRedirect(request.getContextPath() + "/blog/"
						+ accountInfoBean.getAccountId());
				break;
			}

			return responseResult("/doctor/userInfo/baseInfo", accountInfoBean);
		} catch (Exception e) {
			if (e instanceof ApplicationException) {
				logger.error(e.getMessage(), e);

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("failMsg", e.getMessage());

				return responseResult("/system/accountInfo/active", map);
			} else {
				throw new ApplicationException(e.getMessage(), e);
			}
		}
	}

	/**
	 * 忘记密码邮件
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "forgetMail", method = RequestMethod.GET)
	public ModelAndView forgetMail(@RequestParam("key") String key) {
		AccountInfoBean accountInfoBean = validMailServie.forgetMail(key);

		return responseResult("/system/accountInfo/resetPwd", accountInfoBean);
	}

	/**
	 * 重置邮箱邮件
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "resetMail", method = RequestMethod.GET)
	public ModelAndView resetMail(@RequestParam("key") String key,
			@RequestParam("newMail") String newMail) {
		AccountInfoBean accountInfoBean = validMailServie.resetMail(key,
				newMail);

		return responseResult("/system/accountInfo/resetMailSucces",
				accountInfoBean);
	}
}