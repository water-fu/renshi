package com.group.renshi.action.admin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group.webFramework.common.BaseController;
import com.group.renshi.bean.admin.PermissionBean;
import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PermissionAction.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
@Controller
@RequestMapping("/admin")
@Scope("prototype")
public class PermissionAction extends BaseController {

}