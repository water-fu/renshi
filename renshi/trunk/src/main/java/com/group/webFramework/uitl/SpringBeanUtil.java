package com.group.webFramework.uitl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import com.group.webFramework.exception.ApplicationException;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: SpringBeanUtil.java,v 0.1 2015-5-19 下午2:55:17 Exp $
 */
@Repository
public class SpringBeanUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/** 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext ac) throws ApplicationException {
		SpringBeanUtil.applicationContext = ac;
	}

	public static Object getSpringBean(String beanName) {
		return applicationContext.getBean(beanName);
	}
}
