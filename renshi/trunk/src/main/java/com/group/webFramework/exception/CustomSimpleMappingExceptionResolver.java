package com.group.webFramework.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.group.webFramework.uitl.ResponseMessage;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: CustomSimpleMappingExceptionResolver.java,v 0.1 2015-5-20 下午3:24:24 Exp $
 */
public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	private static Logger logger = LoggerFactory
			.getLogger(CustomSimpleMappingExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		logger.error(ex.getMessage(), ex);

		// Expose ModelAndView for chosen error view.
		String viewName = determineViewName(ex, request);

		if (viewName != null) {
			// JSON格式返回
			if (request.getHeader("x-requested-with") != null) {

				try {
					// 设置返回编码
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter writer = response.getWriter();

					ResponseMessage responseMessage = new ResponseMessage();
					responseMessage.setCode(ResponseMessage.FAILE);

					// 判断是否是自定义异常
					if (ex instanceof ApplicationException) {
						responseMessage.setMsg(ex.getMessage());
					} else {
						responseMessage.setMsg("系统异常，请联系系统管理员");
					}
					// 输出JSON字符串
					ObjectMapper objectMapper = new ObjectMapper();
					writer.write(objectMapper.writeValueAsString(responseMessage));

					writer.flush();
				} catch (IOException e) {
					return getModelAndView(viewName, ex, request);
				}

				return null;

			} else { // JSP格式返回

				// 如果不是异步请求  
				// Apply HTTP status code for error views, if specified.  
				// Only apply it if we're processing a top-level request.

				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null) {
					applyStatusCodeIfPossible(request, response, statusCode);
				}

				// 抛往前台的异常进行封装
				ApplicationException exception = new ApplicationException(ex);

				return getModelAndView(viewName, exception, request);
			}
		} else {
			return null;
		}
	}
}
