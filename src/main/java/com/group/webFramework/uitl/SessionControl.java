package com.group.webFramework.uitl;

import javax.servlet.http.HttpServletRequest;

import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.webFramework.entity.AdminDetails;
import com.group.webFramework.entity.UserDetails;

/**
 * 总体说明
 * 	用户Session操作类
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: SessionControl.java,v 0.1 2015-5-19 上午9:50:28 Exp $
 */
public class SessionControl {

	/**
	 * 根据把值赋给session相应名称的属性
	 */
	public static void setAttribute(HttpServletRequest request, String strName, Object oValue) {
		setAttribute(request, strName, oValue, true);// 默认情况下是从session取，以兼容原有代码
	}

	/**
	 * 根据把值赋给session或者attribute相应名称的属性,提供为原来将变量放入session向attribute的平滑过度
	 */
	public static void setAttribute(HttpServletRequest request, String strName, Object oValue,
			boolean fromSession) {
		removeAttribute(request, strName, fromSession);
		if (fromSession) {
			request.getSession().setAttribute(strName, oValue);
		} else {
			request.setAttribute(strName, oValue);
		}
	}

	/**
	 * 从session中相应名称的属性删除
	 */
	public static void removeAttribute(HttpServletRequest request, String strName) {
		removeAttribute(request, strName, true);
	}

	/**
	 * *从session或attribute中相应名称的属性删除
	 */
	public static void removeAttribute(HttpServletRequest request, String strName,
			boolean fromSession) {
		if (fromSession) {
			request.getSession().removeAttribute(strName);
		} else {
			request.removeAttribute(strName);
		}
	}

	/**
	 * 根据名称得到session中相应属性值
	 */
	public static Object getAttribute(HttpServletRequest request, String strName) {
		return getAttribute(request, strName, true);
	}

	public static Object getAttribute(HttpServletRequest request, String strName,
			boolean fromSession) {
		if (fromSession) {
			if (request.getSession() == null) {
				return null;
			}
			return request.getSession().getAttribute(strName);
		} else {
			return request.getAttribute(strName);
		}
	}

	public static UserDetails getCurUserDetail(HttpServletRequest request) {
		return (UserDetails) getAttribute(request, SystemConstantType.USER_DETAILS, true);
	}

	public static AdminDetails getCurAdminDetail(HttpServletRequest request) {
		return (AdminDetails) getAttribute(request, SystemConstantType.ADMIN_DETAILS, true);
	}


	/**
	 * 获取当前登录用户账户信息
	 * 
	 * @param request
	 * @return
	 */
	public static AccountInfoBean getOperInfo(HttpServletRequest request) {
		return getCurUserDetail(request).getAccountInfoBean();
	}

	/**
	 * 获取当前登录用户账户编号
	 * 
	 * @param request
	 * @return
	 */
	public static int getOpId(HttpServletRequest request) {
		return getOperInfo(request).getAccountId();
	}
}
