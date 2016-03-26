package com.group.renshi.action.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: HomeController.java,v 0.1 2015-6-2 下午8:05:48 Exp $
 */
@Controller
@Scope("prototype")
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "index";
	}
}
