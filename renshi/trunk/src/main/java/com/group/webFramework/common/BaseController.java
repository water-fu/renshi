package com.group.webFramework.common;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.ResponseMessage;
import com.group.webFramework.uitl.StringUtil;

/**
 * 总体说明 所有Action的父类
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: BaseController.java,v 0.1 2015-5-20 下午3:17:46 Exp $
 */
public class BaseController {

	private Logger logger = LoggerFactory.getLogger(BaseController.class);

	protected HttpServletRequest request;

	/**
	 * Controller返回类
	 * 
	 * @param result
	 * @return
	 */
	protected ModelAndView responseResult(String result, Object... objects) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(result);

		if (null != objects && objects.length > 0) {
			for (Object object : objects) {
				modelAndView.addObject(StringUtil.getFirstLowName(object
						.getClass().getSimpleName()), object);
			}
		}

		return modelAndView;
	}

	/**
	 * Controller返回类
	 * 
	 * @param result
	 * @return
	 */
	protected ModelAndView responseResult(String result, Map<String, Object> map) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(result);

		for (Entry<String, Object> entry : map.entrySet()) {
			modelAndView.addObject(entry.getKey(), entry.getValue());
		}

		return modelAndView;
	}

	/**
	 * Ajax返回JSON对象
	 * 
	 * @param object
	 */
	protected ResponseMessage responseAjaxResult(Object object) {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setObj(object);

		return responseMessage;
	}

	/**
	 * Ajax错误返回JSON对象
	 * 
	 * @param object
	 */
	protected ResponseMessage responseErrorResult(Exception e) {
		logger.error(e.getMessage(), e);

		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setCode(0);
		if (e instanceof ApplicationException) {
			responseMessage.setMsg(e.getMessage());
		} else {
			responseMessage.setMsg("系统错误，请联系系统管理员");
		}

		return responseMessage;
	}

	/**
	 * Ajax返回JSON使用HTML格式返回
	 * 
	 * @param object
	 */
	protected void responseHtmlResult(HttpServletResponse response,
			Object object) {
		ResponseMessage responseMessage = responseAjaxResult(object);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter;
		try {
			printWriter = response.getWriter();
			ObjectMapper objectMapper = new ObjectMapper();
			printWriter.write(objectMapper.writeValueAsString(responseMessage));
		} catch (Exception e) {
			throw new ApplicationException("AJAX返回异常");
		}

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	@Resource
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
