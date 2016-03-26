package com.group.renshi.service.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.bean.system.ValidMailBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: ValidMailService.java,v 0.1 2015-05-24 下午03:56:53 Exp $
 */
public interface ValidMailService {
	/**
	 * 邮件激活
	 * 
	 * @return
	 */
	AccountInfoBean check(String keyAes, HttpServletRequest request);

	/**
	 * 插入对象
	 * 
	 * @param validMailBean
	 *            需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	ValidMailBean insertValidMail(ValidMailBean validMailBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键编号
	 */
	void deleteValidMail(int id);

	/**
	 * 更新对象
	 * 
	 * @param validMailBean
	 *            需要更新的实体对象
	 */
	void updateValidMail(ValidMailBean validMailBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id
	 *            主键编号
	 * @return 返回实体对象
	 */
	ValidMailBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param validMailBean
	 *            实体对象
	 * @return 返回列表对象
	 */
	List<ValidMailBean> listValidMail(ValidMailBean validMailBean);

	/**
	 * 获取分页数据
	 * 
	 * @param validMailBean
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @return 返回分页对象
	 */
	PageQueryResult<ValidMailBean> pageValidMail(ValidMailBean validMailBean,
			PageQueryResult<ValidMailBean> pageQueryResult);

	/**
	 * 忘记密码
	 * 
	 * @param key
	 * @return
	 */
	AccountInfoBean forgetMail(String key);

	/**
	 * 重置邮箱
	 * 
	 * @author CJH
	 * @param key
	 * @param newMail
	 *            新邮箱
	 * @return
	 */
	AccountInfoBean resetMail(String key, String newMail);
}