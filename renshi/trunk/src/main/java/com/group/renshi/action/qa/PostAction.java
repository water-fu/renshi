package com.group.renshi.action.qa;

import javax.annotation.Resource;

import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.entity.UserDetails;
import com.group.webFramework.uitl.SessionControl;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group.renshi.bean.qa.PostBean;
import com.group.renshi.service.qa.PostService;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PostAction.java,v 0.1 2015-06-09 下午05:34:49 Exp $
 */
@Controller
@RequestMapping("/qa")
@Scope("prototype")
public class PostAction extends BaseController {

	private static final Logger log = Logger.getLogger(PostAction.class);

	@Resource
	private PostService postService;


	@LoginFilter(needLogin = true)
	@RequestMapping(value = "/asdf", method = RequestMethod.GET)
	public ModelAndView viewRequest(ModelMap modelMap) {
		UserDetails userDetails = SessionControl.getCurUserDetail(request);
		UserInfoBean userInfo = userDetails.getUserInfoBean();
		return responseResult("xxx");
	}


	//@LoginFilter(needLogin = true)
	@RequestMapping(value = "/queryAllPosts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage queryAllPosts(@ModelAttribute PostBean postBean,
			@ModelAttribute PageQueryResult<PostBean> pageQueryResult) {

		//        PostBean post = postService.findById(1);
		//        String s = post.getContent();
		//        System.out.println(s);
		log.info("=======================================");

		postBean.setId(1);
		pageQueryResult.setPageSize(2);
		pageQueryResult = postService.pagePost(postBean, pageQueryResult);

		return responseAjaxResult(pageQueryResult);
	}

}