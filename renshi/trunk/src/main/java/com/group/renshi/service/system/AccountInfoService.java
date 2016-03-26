package com.group.renshi.service.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.group.renshi.bean.system.AccountInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: AccountInfoService.java,v 0.1 2015-05-22 下午02:29:01 Exp $
 */
public interface AccountInfoService {
	/**
	 * 插入对象
	 * 
	 * @param accountInfoBean
	 *            需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	AccountInfoBean insertAccountInfo(HttpServletRequest request,
			AccountInfoBean accountInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键编号
	 */
	void deleteAccountInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param accountInfoBean
	 *            需要更新的实体对象
	 */
	void updateAccountInfo(AccountInfoBean accountInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id
	 *            主键编号
	 * @return 返回实体对象
	 */
	AccountInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param accountInfoBean
	 *            实体对象
	 * @return 返回列表对象
	 */
	List<AccountInfoBean> listAccountInfo(AccountInfoBean accountInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param accountInfoBean
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @return 返回分页对象
	 */
	PageQueryResult<AccountInfoBean> pageAccountInfo(
			AccountInfoBean accountInfoBean,
			PageQueryResult<AccountInfoBean> pageQueryResult);

	/**
	 * 根据用户名校验用户名是否重复
	 * 
	 * @param accountName
	 * @return
	 */
	boolean validateAccountName(String loginAccount);

	/**
	 * 登录
	 * 
	 * @param accountInfoBean
	 * @return
	 */
	AccountInfoBean login(HttpServletRequest request,
			AccountInfoBean accountInfoBean);

	/**
	 * 确认账号
	 * 
	 * @param accountName
	 * @return
	 */
	AccountInfoBean confirmAccount(String accountName);

	/**
	 * 忘记密码发送确认邮件
	 * 
	 * @param accountId
	 */
	void sendValidateMail(HttpServletRequest request, int accountId);

	/**
	 * 重置密码
	 * 
	 * @param accountInfoBean
	 * @return
	 */
	AccountInfoBean resetPwd(HttpServletRequest request,
			AccountInfoBean accountInfoBean, String key);

	/**
	 * 管理员审批
	 * 
	 * @param accountId
	 * @return
	 */
	AccountInfoBean approve(HttpServletRequest request, int accountId);

	/**
	 * 医生账户审批（仅后台调用）
	 * 
	 * @param accountId
	 * @return
	 */
	AccountInfoBean approve(int accountId);

	/**
	 * 
	 * @param oldPassword
	 * @param password
	 */
	void changePassword(int accountId, String oldPassword, String password);

	/**
	 * 
	 * @param request
	 */
	void sendRegisterMail(HttpServletRequest request);

	/**
	 * @author CJH 发送重新绑定邮箱邮件
	 * @param request
	 */
	void sendResetMailMail(String newMail, HttpServletRequest request);
}