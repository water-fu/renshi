package com.group.renshi.action.qa;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group.renshi.bean.qa.ReplyBean;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ReplyAction.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
@Controller
@RequestMapping("/qa")
@Scope("prototype")
public class ReplyAction extends BaseController {

	private ReplyBean replyBean = new ReplyBean();

	//@LoginFilter(needLogin = true)
	@RequestMapping(value = "/e", method = RequestMethod.GET)
	public ModelAndView viewRequest(ModelMap modelMap) {

		return responseResult("xxx");
	}

	//@LoginFilter(needLogin = true)
	@RequestMapping(value = "/f", method = RequestMethod.GET)
	public ResponseMessage ajaxRequest(ModelMap modelMap) {

		return responseAjaxResult(new Object());
	}

	/* ========getter和setter方法========*/
	public ReplyBean getReplyBean() {
		return this.replyBean;
	}

	public void setReplyBean(ReplyBean replyBean) {
		this.replyBean = replyBean;
	}
}