package com.group.renshi.action.qa;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group.renshi.bean.qa.MentionBean;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MentionAction.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
@Controller
@RequestMapping("/qa")
@Scope("prototype")
public class MentionAction extends BaseController {

	private MentionBean mentionBean = new MentionBean();

	//@LoginFilter(needLogin = true)
	@RequestMapping(value = "/c", method = RequestMethod.GET)
	public ModelAndView viewRequest(ModelMap modelMap) {

		return responseResult("xxx");
	}

	//@LoginFilter(needLogin = true)
	@RequestMapping(value = "/d", method = RequestMethod.GET)
	public ResponseMessage ajaxRequest(ModelMap modelMap) {

		return responseAjaxResult(new Object());
	}

	/* ========getter和setter方法========*/
	public MentionBean getMentionBean() {
		return this.mentionBean;
	}

	public void setMentionBean(MentionBean mentionBean) {
		this.mentionBean = mentionBean;
	}
}