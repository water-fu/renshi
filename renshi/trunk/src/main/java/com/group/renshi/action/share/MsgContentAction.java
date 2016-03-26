package com.group.renshi.action.share;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group.webFramework.common.BaseController;
import com.group.renshi.bean.share.MsgContentBean;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MsgContentAction.java,v 0.1 2015-07-27 ����09:31:12 Exp $
 */
@Controller
@RequestMapping("/share")
@Scope("prototype")
public class MsgContentAction extends BaseController {
	
}