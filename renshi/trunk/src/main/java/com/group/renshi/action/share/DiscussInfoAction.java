package com.group.renshi.action.share;

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

import com.group.renshi.bean.share.DiscussInfoBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.service.share.DiscussInfoService;
import com.group.renshi.service.share.PersonInfoService;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: DiscussInfoAction.java,v 0.1 2015-06-24 下午11:23:24 Exp $
 */
@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class DiscussInfoAction extends BaseController {

	@Resource
	private DiscussInfoService discussInfoService;

	@Resource
	private PersonInfoService personInfoService;

	/**
	 * 评论
	 * 	1.判断是否有 “回复@”
	 * 	  如果没有匹配，则加上“回复@XXX的赞：”
	 * 	  如果匹配，则匹配“回复@XXX：”
	 * 		如果匹配，则替换成“回复@XXX的赞：”
	 * 
	 * @return
	 */
	@RequestMapping(value = "addDiscuss", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addDiscuss(@ModelAttribute DiscussInfoBean discussInfoBean) {

		discussInfoService.insertDiscussInfo(discussInfoBean);

		return responseAjaxResult("");
	}

	/**
	 * 获取私信列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "{accountId}/messageList")
	@LoginFilter(needLogin = true)
	public ModelAndView getMessageList(@PathVariable("accountId") int accountId,
			PageQueryResult<DiscussInfoBean> pageQueryResult) {
		PersonInfoBean personInfoBean = personInfoService.findByAccountId(accountId);

		// 我收到的评论
		DiscussInfoBean discussInfoBean = new DiscussInfoBean();
		discussInfoBean.setAccountId(accountId);

		pageQueryResult = discussInfoService.pageDiscussInfo(discussInfoBean, pageQueryResult);

		return responseResult("/share/person/messageList", personInfoBean, pageQueryResult);
	}

	/**
	 * 获取评论
	 * 
	 * @param shareId
	 * @return
	 */
	@RequestMapping(value = "askComment", method = RequestMethod.GET)
	public ModelAndView askComment(@RequestParam("id") int shareId,
			@ModelAttribute PageQueryResult<DiscussInfoBean> pageQueryResult) {

		// 获取分享评论
		DiscussInfoBean discussInfoBean = new DiscussInfoBean();
		discussInfoBean.setShareId(shareId);

		pageQueryResult = discussInfoService.pageDiscussInfo(discussInfoBean, pageQueryResult);

		return responseResult("/share/askanswer/commentDetail", pageQueryResult);
	}
}