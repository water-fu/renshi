package com.group.webFramework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.webFramework.uitl.SysContext;

/**
 * 总体说明
 * 	校验是否登录过滤器
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AccessFilter.java,v 0.1 2015-5-19 上午9:39:18 Exp $
 */
public class LoginAccessFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse,
			FilterChain filterchain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;

		//把request和response存放在threadlocal变量中
		SysContext.setRequest(request);
		SysContext.setResponse(response);

		filterchain.doFilter(servletrequest, servletresponse);
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
	}
}
