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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group.renshi.bean.share.CollectionInfoBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.service.share.CollectionInfoService;
import com.group.renshi.service.share.PersonInfoService;
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
 * @version $Id: CollectionInfoAction.java,v 0.1 2015-06-23 下午09:56:44 Exp $
 */
@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class CollectionInfoAction extends BaseController {

	@Resource
	private CollectionInfoService collectionInfoService;

	@Resource
	private PersonInfoService personInfoService;

	/**
	 * 收藏
	 * 
	 * @param shareId
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "addCollection", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addCollection(
			@ModelAttribute CollectionInfoBean collectionInfoBean) {
		try {
			// 设置当前登录用户
			collectionInfoBean.setAccountId(SessionControl.getOpId(request));

			collectionInfoService.insertCollectionInfo(collectionInfoBean);

			return responseAjaxResult("");
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 收藏
	 * 
	 * @param shareId
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "addCollection2", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addCollection2(
			@ModelAttribute CollectionInfoBean collectionInfoBean) {
		try {
			// 设置当前登录用户
			collectionInfoBean.setAccountId(SessionControl.getOpId(request));

			CollectionInfoBean collectionInfoBeanCond = new CollectionInfoBean();
			collectionInfoBeanCond
					.setAccountId(SessionControl.getOpId(request));
			collectionInfoBeanCond.setShareId(collectionInfoBean.getShareId());

			int data = 1;

			List<CollectionInfoBean> list = collectionInfoService
					.listCollectionInfo(collectionInfoBeanCond);
			if (list.isEmpty()) {
				collectionInfoService.insertCollectionInfo(collectionInfoBean);
				data = 1;
			} else {
				collectionInfoService.deleteCollectionInfo(collectionInfoBean);
				data = -1;
			}

			return responseAjaxResult(data);

		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 取消收藏
	 * 
	 * @param shareId
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "delCollection", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage delCollection(
			@ModelAttribute CollectionInfoBean collectionInfoBean) {
		try {
			// 设置当前登录用户
			collectionInfoBean.setAccountId(SessionControl.getOpId(request));

			collectionInfoService.deleteCollectionInfo(collectionInfoBean);

			return responseAjaxResult("");
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	// /**
	// * 获取我收藏的分享内容 原来
	// *
	// * @return
	// */
	// @RequestMapping(value = "{accountId}/collection")
	// @LoginFilter(needLogin = true)
	// public ModelAndView getCollection(@PathVariable("accountId") int
	// accountId
	// // @ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult
	// ) {
	// // 获取个人信息
	// PersonInfoBean personInfoBean = personInfoService
	// .findByAccountId(accountId);
	//
	// // // 获取收藏列表
	// // CollectionInfoBean collectionInfoBean = new CollectionInfoBean();
	// // collectionInfoBean.setAccountId(accountId);
	// //
	// // pageQueryResult = collectionInfoService.pageCollectionInfo(
	// // collectionInfoBean, pageQueryResult);
	//
	// // 结果返回
	// Map<String, Object> resultMap = new HashMap<String, Object>();
	// resultMap.put("personInfoBean", personInfoBean);
	// // resultMap.put("pageQueryResult", pageQueryResult);
	//
	// return responseResult("/share/person/collect", resultMap);
	// }
	/**
	 * 获取我收藏的分享内容 新 jty 8/6
	 * 
	 * @return
	 */
	@RequestMapping(value = "{accountId}/collection")
	@LoginFilter(needLogin = true)
	public ModelAndView getCollection(@PathVariable("accountId") int accountId
			) {
		// 获取个人信息
		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		// 结果返回 id
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("personInfoBean", personInfoBean);

		return responseResult("/share/person/collect", resultMap);
	}
	/**
	 * 根据标题 搜索 收藏记录
	 * 
	 * @param shareId
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "collectionForSearch", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ModelAndView searchCollection(
			int accountId, int pageNo,
			String queryCondition, String collectTitle) {
		PageQueryResult<ShareInfoBean> pageQueryResult = new PageQueryResult<ShareInfoBean>();
		pageQueryResult.setPageNo(pageNo);

		// 获取收藏列表
		CollectionInfoBean collectionInfoBean = new CollectionInfoBean();
		collectionInfoBean.setAccountId(accountId);

		pageQueryResult = collectionInfoService.pageCollectionSearch(
				collectionInfoBean, pageQueryResult, collectTitle, request);
		List<ShareInfoBean> list = pageQueryResult.getList();
		for (ShareInfoBean shareInfo : list) {
			// 标题长度过长时，截取前20个字符
			if (shareInfo.getShareTitle().length() >= 30)
				shareInfo.setShareTitle(shareInfo.getShareTitle().substring(0, 20) + "...");
			// 内容过长时 截取前两百个字符
			if (shareInfo.getShareDesc().length() >= 200)
				shareInfo.setShareDesc(shareInfo.getShareDesc().substring(0, 200) + "...");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageQueryResult", pageQueryResult);

		return responseResult("/share/person/collectionList", resultMap);
	}
}