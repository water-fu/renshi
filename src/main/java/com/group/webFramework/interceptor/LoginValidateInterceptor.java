package com.group.webFramework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.webFramework.annotation.LoginFilter;
import com.group.webFramework.entity.UserDetails;
import com.group.webFramework.uitl.SessionControl;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: LoginValidateInterceptor.java,v 0.1 2015-5-20 下午5:11:21 Exp $
 */
public class LoginValidateInterceptor extends HandlerInterceptorAdapter {

	/**
	 * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
	 * SpringMVC中的Interceptor拦截器是链式的，可以同时存在
	 * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行
	 * ，而且所有的Interceptor中的preHandle方法都会在
	 * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的
	 * ，这种中断方式是令preHandle的返 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
	 * 
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;

			String already = request.getParameter("already");
			if (null != already) {
				if (1 == Integer.valueOf(already))
					return true;
			}
			LoginFilter loginFilter = method
					.getMethodAnnotation(LoginFilter.class);
			// 如果没有@LoginFilter注解则跳过拦截
			// 判断方法上注解的LoginFilter值，如果否则不拦截
			// 判断Session中用户是否存在
			UserDetails userDetails = SessionControl.getCurUserDetail(request);

			if (null == userDetails || null == userDetails.getAccountInfoBean()) {

				if (loginFilter == null || !loginFilter.needLogin()) {
					return true;
				}

				// 如果没有登录,则请求转发到登录页面
				request.getRequestDispatcher(
						"/WEB-INF/pages/system/accountInfo/login.jsp").forward(
						request, response);
				return false;
			} else {
				// 如果是认证的页面则不需要验证
				String[] path = new String[] { "/doctor/baseInfo",
						"/doctor/authInfo", "/doctor/approve",
						"/proxy/authInfo", "/proxy/toAuthInfo",
						"/proxy/toApprove", "/common/ajaxFileUpload",
						"/common/showImage", "/doctor/getDeptInfo",
						"/system/logout", "/", "/system/loginPage" };
				String requestPath = request.getServletPath();
				for (int i = 0; i < path.length; i++) {
					if (requestPath.equalsIgnoreCase(path[i])) {
						return true;
					}

					if (requestPath.indexOf("/admin") > 0) {
						return true;
					}
				}

				AccountInfoBean accountInfoBean = userDetails
						.getAccountInfoBean();
				// 如果登录了,未激活的，跳转到激活页面
				if (accountInfoBean.getActiveType() == SystemConstantType.ACTIVE_TYPE_NO) {
					response.sendRedirect(request.getContextPath()
							+ "/system/activePage?id="
							+ accountInfoBean.getAccountId() + "&already=1");//
					return false;
				}

				// 认证步骤
				switch (accountInfoBean.getAccountStatus()) {
				// 未认证，跳转到第一步
				case SystemConstantType.ACCOUNT_STATUS_ZERO:
					if ("/doctor/toBaseInfo".equals(requestPath)) {
						break;
					}
					response.sendRedirect(request.getContextPath()
							+ "/doctor/toBaseInfo?id="
							+ accountInfoBean.getAccountId());
					return false;
					// 第一步已认证，跳转到第二步
				case SystemConstantType.ACCOUNT_STATUS_FIRST:
					if ("/doctor/toAuthInfo".equals(requestPath)) {
						break;
					}
					response.sendRedirect(request.getContextPath()
							+ "/doctor/toAuthInfo?id="
							+ accountInfoBean.getAccountId());
					return false;
					// 第二步已认证，跳转到第三步
				case SystemConstantType.ACCOUNT_STATUS_SECOND:
					if ("/doctor/toApprove".equals(requestPath)) {
						break;
					}
					response.sendRedirect(request.getContextPath()
							+ "/doctor/toApprove?id="
							+ accountInfoBean.getAccountId());
					return false;
				case SystemConstantType.ACCOUNT_STATUS_THIRD:
					if ("/doctor/toApprove".equals(requestPath)) {
						response.sendRedirect(request.getContextPath()
								+ "/blog/" + accountInfoBean.getAccountId());
						return false;
					}
					break;
				}
			}
			return true;
		} else if (handler instanceof ResourceHttpRequestHandler) { // 如果是资源文件则返回true
			return true;
		}
		return false;
	}
}
