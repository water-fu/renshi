package com.group.renshi.action.share;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.share.PraiseInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.service.share.PersonInfoService;
import com.group.renshi.service.share.PraiseInfoService;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.common.BaseController;
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
 * @version $Id: PraiseInfoAction.java,v 0.1 2015-06-23 下午08:20:07 Exp $
 */
@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class PraiseInfoAction extends BaseController {

	@Resource
	private PraiseInfoService praiseInfoService;

	@Resource
	private PersonInfoService personInfoService;

	/**
	 * 点赞
	 * 
	 * @param praiseInfoBean
	 * @return
	 */
	@RequestMapping(value = "addPraise", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addPraise(
			@ModelAttribute PraiseInfoBean praiseInfoBean) {

		try {
			praiseInfoBean.setAccountId(SessionControl.getOpId(request));

			// 插入点赞
			praiseInfoService.insertPraiseInfo(praiseInfoBean);

			return responseAjaxResult("");
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}
	/**
	 * 判断是否点赞
	 * 
	 * @param praiseInfoBean
	 * @return
	 */
	@RequestMapping(value = "addPraise3", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addPraise3(
			@ModelAttribute PraiseInfoBean praiseInfoBean) {

		try {
			praiseInfoBean.setAccountId(SessionControl.getOpId(request));

			PraiseInfoBean praiseInfoBeanCond = new PraiseInfoBean();
			praiseInfoBeanCond.setAccountId(SessionControl.getOpId(request));
			praiseInfoBeanCond.setShareId(praiseInfoBean.getShareId());

			List<PraiseInfoBean> list = praiseInfoService
					.listPraiseInfo(praiseInfoBeanCond);

			int data = 1;
			if (list.isEmpty()) {
				// 没有点赞
				data = 1;
			} else {
				// 已经点赞
				data = -1;
			}

			return responseAjaxResult(data);
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}
	/**
	 * 点赞
	 * 
	 * @param praiseInfoBean
	 * @return
	 */
	@RequestMapping(value = "addPraise2", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addPraise2(
			@ModelAttribute PraiseInfoBean praiseInfoBean) {

		try {
			praiseInfoBean.setAccountId(SessionControl.getOpId(request));

			PraiseInfoBean praiseInfoBeanCond = new PraiseInfoBean();
			praiseInfoBeanCond.setAccountId(SessionControl.getOpId(request));
			praiseInfoBeanCond.setShareId(praiseInfoBean.getShareId());

			List<PraiseInfoBean> list = praiseInfoService
					.listPraiseInfo(praiseInfoBeanCond);

			int data = 1;
			if (list.isEmpty()) {
				// 插入点赞
				praiseInfoService.insertPraiseInfo(praiseInfoBean);
				data = 1;
			} else {
				praiseInfoService.deletePraiseInfo(praiseInfoBean);
				data = -1;
			}

			return responseAjaxResult(data);
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 
	 * 
	 * @param praiseInfoBean
	 * @return
	 */
	@RequestMapping(value = "delPraise", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage delPraise(
			@ModelAttribute PraiseInfoBean praiseInfoBean) {
		try {
			praiseInfoBean.setAccountId(SessionControl.getOpId(request));

			praiseInfoService.deletePraiseInfo(praiseInfoBean);

			return responseAjaxResult("");

		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 获取给我点赞的列表
	 * 
	 * @param accountId
	 * @param pageQueryResult
	 * @return
	 */
	@RequestMapping(value = "{accountId}/praise", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getPraise(
			@PathVariable("accountId") int accountId,
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult,
			@RequestParam(value = "searchType", required = false) Integer searchType) {
		// 获取个人信息
		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		// 获取点赞列表
		PraiseInfoBean praiseInfoBean = new PraiseInfoBean();
		praiseInfoBean.setAccountId(accountId);

		if (searchType != null) {
			praiseInfoBean.setCreateUser(searchType);
		}

		pageQueryResult = praiseInfoService.pagePraiseInfo(praiseInfoBean,
				pageQueryResult);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("personInfoBean", personInfoBean);
		result.put("pageQueryResult", pageQueryResult);
		result.put("searchType", searchType);

		return responseResult("/share/person/praise", result);
	}
}