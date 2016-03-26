package com.group.webFramework.uitl;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: StringUtil.java,v 0.1 2015-6-3 上午10:35:20 Exp $
 */
public class StringUtil {

	/**
	 * 首字母小写
	 * 
	 * @param className
	 * @return
	 */
	public static String getFirstLowName(String name) {
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append(name.substring(0, 1).toLowerCase()).append(name.substring(1));

		return sbBuffer.toString();
	}
}
