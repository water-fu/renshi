package com.group.renshi.action.share;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.renshi.service.share.FollowActiveService;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.common.BaseController;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: FollowActiveAction.java,v 0.1 2015-06-09 下午08:53:43 Exp $
 */
@Controller
@RequestMapping("/share")
@Scope("prototype")
public class FollowActiveAction extends BaseController {

	@Resource
	private FollowActiveService followActiveService;

	/**
	 * 关注
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "followActive", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage followActive(@RequestParam("accountId") int accountId) {

		try {
			// 关注
			followActiveService.followActive(request, accountId);

			return responseAjaxResult("");
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 取消关注
	 * 
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "unFollowActive", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage unFollowActive(
			@RequestParam("accountId") int accountId) {
		try {

			followActiveService.unFollowActive(request, accountId);

			return responseAjaxResult("");
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}
}