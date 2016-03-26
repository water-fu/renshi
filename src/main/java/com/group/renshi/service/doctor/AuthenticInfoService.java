package com.group.renshi.service.doctor;

import java.util.List;

import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AuthenticInfoService.java,v 0.1 2015-05-25 下午09:07:32 Exp $
 */
public interface AuthenticInfoService {
	/**
	 * 插入对象
	 * 
	 * @param authenticInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	AuthenticInfoBean insertAuthenticInfo(AuthenticInfoBean authenticInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteAuthenticInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param authenticInfoBean  需要更新的实体对象
	 */
	void updateAuthenticInfo(AuthenticInfoBean authenticInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	AuthenticInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param authenticInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<AuthenticInfoBean> listAuthenticInfo(AuthenticInfoBean authenticInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param authenticInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<AuthenticInfoBean> pageAuthenticInfo(AuthenticInfoBean authenticInfoBean,
			PageQueryResult<AuthenticInfoBean> pageQueryResult);
}