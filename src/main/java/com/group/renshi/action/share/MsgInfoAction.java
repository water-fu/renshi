package com.group.renshi.action.share;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.share.MsgContentBean;
import com.group.renshi.bean.share.MsgInfoBean;
import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.service.doctor.UserInfoService;
import com.group.renshi.service.share.MsgContentService;
import com.group.renshi.service.share.MsgInfoService;
import com.group.renshi.service.share.PersonInfoService;
import com.group.renshi.service.system.AccountInfoService;
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
 * @version $Id: MsgInfoAction.java,v 0.1 2015-07-27 ����09:31:12 Exp $
 */
@Controller
@RequestMapping("/blog")
@Scope("prototype")
public class MsgInfoAction extends BaseController {

	@Resource
	private MsgInfoService msgInfoService;

	@Resource
	private PersonInfoService personInfoService;

	@Resource
	private MsgContentService msgContentService;

	@Resource
	private UserInfoService userInfoService;

	@Resource
	private AccountInfoService accountInfoService;

	/**
	 * 点击私信
	 * 
	 * @return
	 */
	@RequestMapping(value = "addMsg", method = RequestMethod.POST)
	@LoginFilter(needLogin = true)
	@ResponseBody
	public ResponseMessage addMsg(@ModelAttribute MsgInfoBean msgInfoBean) {
		msgInfoBean.setAccountId(SessionControl.getOpId(request));

		List<MsgInfoBean> list = msgInfoService.listMsgInfo(msgInfoBean);

		MsgInfoBean msgInfoBeanCond = new MsgInfoBean();
		msgInfoBeanCond.setAccountedId(SessionControl.getOpId(request));
		msgInfoBeanCond.setAccountId(msgInfoBean.getAccountedId());

		List<MsgInfoBean> list2 = msgInfoService.listMsgInfo(msgInfoBeanCond);
		if (list.isEmpty()) {
			if (list2.isEmpty()) {
				msgInfoBean.setMsgContent("开始对话");
				msgInfoBean = msgInfoService.insertMsgInfo(msgInfoBean);
			} else {
				msgInfoBean = list2.get(0);
			}
		} else {
			msgInfoBean = list.get(0);
		}

		return responseAjaxResult(msgInfoBean);
	}

	/**
	 * 私信列表
	 * 
	 * @param accountId
	 * @param pageQueryResult
	 * @return
	 */
	@RequestMapping(value = "{accountId}/msgList", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView msgList(@PathVariable("accountId") int accountId,
			@ModelAttribute PageQueryResult<MsgInfoBean> pageQueryResult) {

		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(accountId);

		MsgInfoBean msgInfoBean = new MsgInfoBean();
		msgInfoBean.setAccountId(accountId);

		pageQueryResult = msgInfoService.pageMsgInfo(msgInfoBean,
				pageQueryResult);

		return responseResult("share/person/msgList", pageQueryResult,
				personInfoBean);
	}

	/**
	 * 私信对话框
	 * 
	 * @return
	 */
	@RequestMapping(value = "msgDialog", method = RequestMethod.GET)
	@LoginFilter(needLogin = true)
	public ModelAndView msgDialog(@ModelAttribute MsgContentBean msgContentBean) {
		List<MsgContentBean> list = msgContentService
				.listMsgContent(msgContentBean);

		Collections.sort(list, new Comparator<MsgContentBean>() {

			@Override
			public int compare(MsgContentBean o1, MsgContentBean o2) {
				if (o1.getContentId() > o2.getContentId()) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		MsgInfoBean msgInfoBean = msgInfoService.findById(msgContentBean
				.getMsgId());

		UserInfoBean userInfoBean = new UserInfoBean();
		AccountInfoBean accountInfoBean = new AccountInfoBean();
		if (msgInfoBean.getAccountedId() == SessionControl.getOpId(request)) {
			userInfoBean = userInfoService.findById(msgInfoBean.getAccountId());
			accountInfoBean = accountInfoService.findById(msgInfoBean
					.getAccountId());
		} else {
			userInfoBean = userInfoService.findById(msgInfoBean
					.getAccountedId());
			accountInfoBean = accountInfoService.findById(msgInfoBean
					.getAccountedId());
		}

		PersonInfoBean personInfoBean = personInfoService
				.findByAccountId(SessionControl.getOpId(request));

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", list);
		resultMap.put("personInfoBean", personInfoBean);
		resultMap.put("msgInfoBean", msgInfoBean);
		resultMap.put("userInfoBean", userInfoBean);
		resultMap.put("accountInfoBean", accountInfoBean);

		return responseResult("share/person/messageDialog", resultMap);
	}

	@RequestMapping(value = "addMsgContent", method = RequestMethod.POST)
	@ResponseBody
	@LoginFilter(needLogin = true)
	public ResponseMessage addMsgContent(
			@ModelAttribute MsgContentBean msgContentBean) {
		msgContentBean.setSendDate(new Date());

		msgContentService.insertMsgContent(msgContentBean);

		return responseAjaxResult("");
	}
}