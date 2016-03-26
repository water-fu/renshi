package com.group.webFramework.aspect;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.group.webFramework.common.BaseEntity;
import com.group.webFramework.entity.UserDetails;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.SessionControl;
import com.group.webFramework.uitl.SysContext;

/**
 * 总体说明
 * 	Dao执行切面
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: ServiceExecAspect.java,v 0.1 2015-5-19 上午9:58:06 Exp $
 */
@Aspect
public class DaoExecAspect {

	private static Logger logger = LoggerFactory.getLogger(DaoExecAspect.class);

	/**
	 * 执行insert前缀之前
	 * 
	 * @param baseEntity
	 * @throws ApplicationException
	 */
	@Before("execution(public * com.group.renshi.dao..*Dao.insert*(..)) &&  args(baseEntity,..)")
	public void beforeExecInsertInService(BaseEntity baseEntity) throws ApplicationException {
		logger.debug("enter beforeExecInsertInDao");
		UserDetails userDetails = SessionControl.getCurUserDetail(SysContext.getRequest());
		if (userDetails != null) {
			baseEntity.setCreateUser(userDetails.getAccountInfoBean().getAccountId());
			baseEntity.setUpdateUser(userDetails.getAccountInfoBean().getAccountId());
		}
		baseEntity.setCreateDate(new Date());
		baseEntity.setUpdateDate(new Date());
	}

	/**
	 * 执行update前缀之前
	 * 
	 * @param baseEntity
	 * @throws ApplicationException
	 */
	@Before("execution(public * com.group.renshi.dao..*Dao.update*(..)) &&  args(baseEntity,..)")
	public void beforeExecUpdateInService(BaseEntity baseEntity) throws ApplicationException {
		logger.debug("enter beforeExecUpdateInDao");
		UserDetails userDetails = SessionControl.getCurUserDetail(SysContext.getRequest());
		if (userDetails != null) {
			baseEntity.setUpdateUser(userDetails.getAccountInfoBean().getAccountId());
		}
		baseEntity.setUpdateDate(new Date());
	}
}