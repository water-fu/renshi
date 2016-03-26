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

import com.group.renshi.bean.share.CaseInfoBean;
import com.group.renshi.bean.share.QuestionInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.bean.share.VideoInfoBean;
import com.group.renshi.service.share.ShareInfoService;
import com.group.renshi.service.share.VideoInfoService;
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
 * @version $Id: ShareInfoAction.java,v 0.1 2015-06-09 下午02:11:11 Exp $
 */
@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class ShareInfoAction extends BaseController {

	@Resource
	private ShareInfoService shareInfoService;

	@Resource
	private VideoInfoService videoInfoService;

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	private PageQueryResult<ShareInfoBean> subStrShareDesc(
			PageQueryResult<ShareInfoBean> pageQueryResult) {

		// ----jin-start---截取内容长度不超过200//
		List<ShareInfoBean> list = pageQueryResult.getList();
		if (list != null && 0 != list.size()) {
			for (ShareInfoBean bean : list) {
				if (bean.getShareDesc().length() > 200) {
					bean.setShareDesc(bean.getShareDesc().substring(0, 200)
							+ "......");
				}

			}
		}
		// ----jin-end//
		return pageQueryResult;
	}
	/**
	 * 获取视频信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "video")
	public ModelAndView video(
			@RequestParam(value = "searchCon", required = false) String searchCon) {
		PageQueryResult<ShareInfoBean> pageQueryResult = new PageQueryResult<ShareInfoBean>();
		pageQueryResult.setPageSize(10);

		if ("".equals(searchCon)) {
			searchCon = null;
		}

		pageQueryResult = shareInfoService.listLevelVideo(pageQueryResult,
				searchCon);

		// 骨科
		PageQueryResult<ShareInfoBean> pageQueryResult1 = new PageQueryResult<ShareInfoBean>();
		pageQueryResult1.setPageSize(5);
		pageQueryResult1 = shareInfoService.listProfessVideo("骨科",
				pageQueryResult1, searchCon);

		// 外科
		PageQueryResult<ShareInfoBean> pageQueryResult2 = new PageQueryResult<ShareInfoBean>();
		pageQueryResult2.setPageSize(5);
		pageQueryResult2 = shareInfoService.listProfessVideo("外科",
				pageQueryResult2, searchCon);

		// 内科
		PageQueryResult<ShareInfoBean> pageQueryResult3 = new PageQueryResult<ShareInfoBean>();
		pageQueryResult3.setPageSize(5);
		pageQueryResult3 = shareInfoService.listProfessVideo("内科",
				pageQueryResult3, searchCon);

		// 儿科
		PageQueryResult<ShareInfoBean> pageQueryResult4 = new PageQueryResult<ShareInfoBean>();
		pageQueryResult4.setPageSize(5);
		pageQueryResult4 = shareInfoService.listProfessVideo("儿科",
				pageQueryResult4, searchCon);

		// 神经科
		PageQueryResult<ShareInfoBean> pageQueryResult5 = new PageQueryResult<ShareInfoBean>();
		pageQueryResult5.setPageSize(5);
		pageQueryResult5 = shareInfoService.listProfessVideo("神经科",
				pageQueryResult5, searchCon);

		// 妇科
		PageQueryResult<ShareInfoBean> pageQueryResult6 = new PageQueryResult<ShareInfoBean>();
		pageQueryResult6.setPageSize(5);
		pageQueryResult6 = shareInfoService.listProfessVideo("妇科",
				pageQueryResult6, searchCon);

		// --jty--//控制视频详细描述的长度 显示的详细描述不超过200
		pageQueryResult = subStrShareDesc(pageQueryResult);
		pageQueryResult1 = subStrShareDesc(pageQueryResult1);
		pageQueryResult2 = subStrShareDesc(pageQueryResult2);
		pageQueryResult3 = subStrShareDesc(pageQueryResult3);
		pageQueryResult4 = subStrShareDesc(pageQueryResult4);
		pageQueryResult5 = subStrShareDesc(pageQueryResult5);
		pageQueryResult6 = subStrShareDesc(pageQueryResult6);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageQueryResult", pageQueryResult);
		resultMap.put("pageQueryResult1", pageQueryResult1);
		resultMap.put("pageQueryResult2", pageQueryResult2);
		resultMap.put("pageQueryResult3", pageQueryResult3);
		resultMap.put("pageQueryResult4", pageQueryResult4);
		resultMap.put("pageQueryResult5", pageQueryResult5);
		resultMap.put("pageQueryResult6", pageQueryResult6);

		if (searchCon != null) {
			resultMap.put("searchCon", searchCon);
		}

		return responseResult("/share/video/video", resultMap);
	}

	/**
	 * 视频列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "videolist", method = RequestMethod.GET)
	public ModelAndView videolist(@RequestParam("type") int type,
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult) {

		switch (type) {
			case 1 :
				pageQueryResult = shareInfoService.listLevelVideo(pageQueryResult,
						null);
				break;
			case 2 :
				pageQueryResult = shareInfoService.listProfessVideo("骨科",
						pageQueryResult, null);
				break;
			case 3 :
				pageQueryResult = shareInfoService.listProfessVideo("外科",
						pageQueryResult, null);
				break;
			case 4 :
				pageQueryResult = shareInfoService.listProfessVideo("内科",
						pageQueryResult, null);
				break;
			case 5 :
				pageQueryResult = shareInfoService.listProfessVideo("儿科",
						pageQueryResult, null);
				break;
			case 6 :
				pageQueryResult = shareInfoService.listProfessVideo("神经科",
						pageQueryResult, null);
				break;
			case 7 :
				pageQueryResult = shareInfoService.listProfessVideo("妇科",
						pageQueryResult, null);
				break;
			default :
				break;
		}

		// --jty--待测试 可能不需要截取字符串
		pageQueryResult = subStrShareDesc(pageQueryResult);

		return responseResult("/share/video/videolist", pageQueryResult);
	}

	/**
	 * 查询医问医答详细页面
	 * 
	 * @param shareId
	 * @return
	 */
	@RequestMapping(value = "videoDetail", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getVideoDetail(@RequestParam("id") int shareId) {
		ShareInfoBean shareInfoBean = shareInfoService.loadExtend(shareId);

		VideoInfoBean videoInfoBean = videoInfoService.findById(shareInfoBean
				.getShareId());

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("shareInfoBean", shareInfoBean);
		resultMap.put("videoInfoBean", videoInfoBean);

		return responseResult("/share/video/videodetail", resultMap);
	}

	/**
	 * 获取观点信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "point")
	public ModelAndView point(
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult,
			@RequestParam(value = "searchCon", required = false) String searchCon) {
		if ("".equals(searchCon)) {
			searchCon = null;
		}

		pageQueryResult = shareInfoService.listLevelPoint(pageQueryResult,
				searchCon);

		// --jty--//控制视频详细描述的长度 显示的详细描述不超过200
		pageQueryResult = subStrShareDesc(pageQueryResult);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("pageQueryResult", pageQueryResult);
		if (searchCon != null) {
			result.put("searchCon", searchCon);
		}

		return responseResult("/share/point/point", result);
	}

	/**
	 * 视频列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "pointlist", method = RequestMethod.GET)
	public ModelAndView pointlist(@RequestParam("type") int type,
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult) {

		switch (type) {
			case 1 :
				pageQueryResult = shareInfoService.listLevelVideo(pageQueryResult,
						null);
				break;
			case 2 :
				pageQueryResult = shareInfoService.listProfessVideo("骨科",
						pageQueryResult, null);
				break;
			case 3 :
				pageQueryResult = shareInfoService.listProfessVideo("外科",
						pageQueryResult, null);
				break;
			case 4 :
				pageQueryResult = shareInfoService.listProfessVideo("内科",
						pageQueryResult, null);
				break;
			case 5 :
				pageQueryResult = shareInfoService.listProfessVideo("儿科",
						pageQueryResult, null);
				break;
			case 6 :
				pageQueryResult = shareInfoService.listProfessVideo("神经科",
						pageQueryResult, null);
				break;
			case 7 :
				pageQueryResult = shareInfoService.listProfessVideo("妇科",
						pageQueryResult, null);
				break;
			default :
				break;
		}

		// --jty--//控制视频详细描述的长度 显示的详细描述不超过200 待测试 可能不需要
		pageQueryResult = subStrShareDesc(pageQueryResult);

		return responseResult("/share/point/pointlist", pageQueryResult);
	}

	/**
	 * 查询医问医答详细页面
	 * 
	 * @param shareId
	 * @return
	 */
	@RequestMapping(value = "pointDetail", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getPointDetail(@RequestParam("id") int shareId) {
		ShareInfoBean shareInfoBean = shareInfoService.loadExtend(shareId);

		return responseResult("/share/point/pointdetail", shareInfoBean);
	}

	/**
	 * 病例列表页
	 * 
	 * 获取病例列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "case")
	public ModelAndView caseList(
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult,
			@RequestParam(value = "searchCon", required = false) String searchCon) {

		if ("".equals(searchCon)) {
			searchCon = null;
		}

		pageQueryResult = shareInfoService.listLevelCase(pageQueryResult,
				searchCon);

		// --jty--//控制视频详细描述的长度 显示的详细描述不超过200
		pageQueryResult = subStrShareDesc(pageQueryResult);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("pageQueryResult", pageQueryResult);
		result.put("searchCon", searchCon);

		return responseResult("/share/case/case", result);
	}

	/**
	 * 查询医问医答详细页面
	 * 
	 * @param shareId
	 * @return
	 */
	@RequestMapping(value = "caseDetail", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getCaseDetail(@RequestParam("id") int shareId) {
		ShareInfoBean shareInfoBean = shareInfoService.loadExtend(shareId);

		return responseResult("/share/case/casedetail", shareInfoBean);
	}

	/**
	 * 获取观点信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "library")
	public ModelAndView libraryList(
			@ModelAttribute PageQueryResult<ShareInfoBean> pageQueryResult,
			@RequestParam(value = "searchCon", required = false) String searchCon) {
		if ("".equals(searchCon)) {
			searchCon = null;
		}

		pageQueryResult = shareInfoService.listLevelLibrary(pageQueryResult,
				searchCon);

		// --jty--//控制视频详细描述的长度 显示的详细描述不超过200
		pageQueryResult = subStrShareDesc(pageQueryResult);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("pageQueryResult", pageQueryResult);
		result.put("searchCon", searchCon);

		return responseResult("/share/library/library", result);
	}

	/**
	 * 查询医问医答详细页面
	 * 
	 * @param shareId
	 * @return
	 */
	@RequestMapping(value = "libraryDetail", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getLibraryDetail(@RequestParam("id") int shareId) {
		ShareInfoBean shareInfoBean = shareInfoService.loadExtend(shareId);

		return responseResult("/share/library/librarydetail", shareInfoBean);
	}

	/**
	 * 查询医问医答详细页面
	 * 
	 * @param shareId
	 * @return
	 */
	@RequestMapping(value = "content/{id}", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView getContent(@PathVariable("id") int shareId) {
		ShareInfoBean shareInfoBean = shareInfoService.loadExtend(shareId);

		switch (shareInfoBean.getShareType()) {
			case 1 :
				VideoInfoBean videoInfoBean = videoInfoService
						.findById(shareInfoBean.getShareId());

				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("shareInfoBean", shareInfoBean);
				resultMap.put("videoInfoBean", videoInfoBean);

				return responseResult("/share/video/videodetail", resultMap);
			case 2 :
				return responseResult("/share/point/pointdetail", shareInfoBean);
			case 3 :
				return responseResult("/share/case/casedetail", shareInfoBean);
			case 4 :
				return responseResult("/share/library/librarydetail", shareInfoBean);
			case 5 :
				return responseResult("/share/askanswer/askdetail", shareInfoBean);
			default :
				return responseResult("/error/404");
		}
	}

	@RequestMapping(value = "content", method = RequestMethod.GET)
	public ModelAndView getContentForAdmin(int shareId) {
		ShareInfoBean shareInfoBean = shareInfoService.loadExtend(shareId);
		switch (shareInfoBean.getShareType()) {
			case 1 :
				VideoInfoBean videoInfoBean = videoInfoService
						.findById(shareInfoBean.getShareId());
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("shareInfoBean", shareInfoBean);
				resultMap.put("videoInfoBean", videoInfoBean);

				return responseResult("/admin/videodetail", resultMap);// 视频
			case 2 :
				return responseResult("/admin/pointdetail", shareInfoBean);// 观点
			case 3 :
				return responseResult("/admin/casedetail", shareInfoBean);// 病例
			case 4 :
				return responseResult("/admin/librarydetail", shareInfoBean);// 文档
			case 5 :
				return responseResult("/admin/askdetail", shareInfoBean);// 提问
			default :
				return responseResult("/error/404");
		}
	}

	/**
	 * 视频新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "publishVideo", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView addVideoPage() {
		return responseResult("/share/video/videoAdd");
	}

	/**
	 * 视频新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "addVideo", method = RequestMethod.POST)
	@LoginFilter(needLogin = true)
	@ResponseBody
	public ResponseMessage addVideo(
			@ModelAttribute ShareInfoBean shareInfoBean,
			@RequestParam("fileUrl") String fileurl,
			@RequestParam(value = "callone", required = false) String callone) {
		try {
			shareInfoBean.setAccountId(SessionControl.getOpId(request));

			request.setAttribute("fileUrl", fileurl);
			request.setAttribute("callone", callone);

			shareInfoBean = shareInfoService.insertShareInfo(shareInfoBean,
					request);

			return responseAjaxResult(shareInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}

	}

	/**
	 * 新增观点页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "publishPoint", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView addPointPage() {
		return responseResult("/share/point/pointAdd");
	}

	/**
	 * 观点新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "addPoint", method = RequestMethod.POST)
	@LoginFilter(needLogin = true)
	@ResponseBody
	public ResponseMessage addPoint(
			@ModelAttribute ShareInfoBean shareInfoBean,
			@RequestParam("fileUrl") String fileurl,
			@RequestParam(value = "callone", required = false) String callone) {

		try {
			shareInfoBean.setAccountId(SessionControl.getOpId(request));

			request.setAttribute("fileUrl", fileurl);
			request.setAttribute("callone", callone);

			shareInfoBean = shareInfoService.insertShareInfo(shareInfoBean,
					request);

			return responseAjaxResult(shareInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 新增病例页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "publishCase", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView addCasePage() {
		return responseResult("/share/case/caseAdd");
	}

	/**
	 * 病例新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "addCase", method = RequestMethod.POST)
	@LoginFilter(needLogin = true)
	@ResponseBody
	public ResponseMessage addCase(@ModelAttribute ShareInfoBean shareInfoBean,
			@RequestParam("fileUrl") String fileurl,
			@ModelAttribute CaseInfoBean caseInfoBean,
			@RequestParam(value = "callone", required = false) String callone) {

		try {
			shareInfoBean.setAccountId(SessionControl.getOpId(request));

			request.setAttribute("fileUrl", fileurl);
			request.setAttribute("callone", callone);

			request.setAttribute("caseInfoBean", caseInfoBean);
			shareInfoBean = shareInfoService.insertShareInfo(shareInfoBean,
					request);

			return responseAjaxResult(shareInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 新增文库页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "publishLibrary", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView addLibraryPage() {
		return responseResult("/share/library/libraryAdd");
	}

	/**
	 * 文库新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "addLibrary", method = RequestMethod.POST)
	@LoginFilter(needLogin = true)
	@ResponseBody
	public ResponseMessage addLibrary(
			@ModelAttribute ShareInfoBean shareInfoBean,
			@RequestParam("fileUrl") String fileurl,
			@RequestParam("fileName") String fileName,
			@RequestParam(value = "callone", required = false) String callone) {

		try {
			shareInfoBean.setAccountId(SessionControl.getOpId(request));

			request.setAttribute("fileUrl", fileurl);
			request.setAttribute("callone", callone);

			request.setAttribute("fileName", fileName);
			shareInfoBean = shareInfoService.insertShareInfo(shareInfoBean,
					request);

			return responseAjaxResult(shareInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}

	/**
	 * 新增提问页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "publishQuestion", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView addQuestionPage() {
		return responseResult("/share/askanswer/askAnswerAdd");
	}

	/**
	 * 提问新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "addQuestion", method = RequestMethod.POST)
	@LoginFilter(needLogin = true)
	@ResponseBody
	public ResponseMessage addQuestion(
			@ModelAttribute ShareInfoBean shareInfoBean,
			@RequestParam("fileUrl") String fileurl,
			@ModelAttribute QuestionInfoBean questionInfoBean,
			@RequestParam(value = "callone", required = false) String callone) {

		try {
			shareInfoBean.setAccountId(SessionControl.getOpId(request));

			request.setAttribute("fileUrl", fileurl);
			request.setAttribute("callone", callone);

			request.setAttribute("questionInfoBean", questionInfoBean);
			shareInfoBean = shareInfoService.insertShareInfo(shareInfoBean,
					request);

			return responseAjaxResult(shareInfoBean);
		} catch (Exception e) {
			return responseErrorResult(e);
		}
	}
}