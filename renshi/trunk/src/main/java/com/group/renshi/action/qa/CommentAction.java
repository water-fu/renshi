package com.group.renshi.action.qa;

import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.entity.UserDetails;
import com.group.webFramework.uitl.SessionControl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group.webFramework.common.BaseController;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: CommentAction.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
@Controller
@RequestMapping("/qa")
@Scope("prototype")
public class CommentAction extends BaseController {



	@LoginFilter(needLogin = true)
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public ModelAndView myDocQaHome(ModelMap modelMap) {
		return responseResult("xxx");
	}



	//@LoginFilter(needLogin = true)
	@RequestMapping(value = "/b", method = RequestMethod.GET)
	public ResponseMessage ajaxRequest(ModelMap modelMap) {
		return responseAjaxResult(new Object());
	}
}