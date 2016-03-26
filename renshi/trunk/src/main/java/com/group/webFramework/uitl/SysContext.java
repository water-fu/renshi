package com.group.webFramework.uitl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 总体说明
 * 	封装线程Request和Response对象
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: SysContext.java,v 0.1 2015-5-19 上午9:51:12 Exp $
 */
public class SysContext {
	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

	public static HttpServletRequest getRequest() {
		return requestLocal.get();
	}

	public static HttpServletResponse getResponse() {
		return responseLocal.get();
	}

	public static void setRequest(HttpServletRequest request) {
		requestLocal.set(request);
	}

	public static void setResponse(HttpServletResponse response) {
		responseLocal.set(response);
	}
}
