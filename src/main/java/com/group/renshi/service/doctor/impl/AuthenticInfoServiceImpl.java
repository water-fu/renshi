package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.renshi.service.doctor.AuthenticInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AuthenticInfoServiceImpl.java,v 0.1 2015-05-25 下午09:07:32 Exp $
 */
@Service("authenticInfoService")
@Transactional
public class AuthenticInfoServiceImpl extends ServiceSupport implements AuthenticInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.doctor.AuthenticInfoService#insertAuthenticInfo(com.group.renshi.bean.doctor.AuthenticInfoBean)
	 */
	@Override
	public AuthenticInfoBean insertAuthenticInfo(AuthenticInfoBean authenticInfoBean) {
		authenticInfoDao.insert(authenticInfoBean);
		return authenticInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.doctor.AuthenticInfoService#deleteAuthenticInfo(int)
	 */
	@Override
	public void deleteAuthenticInfo(int id) {
		authenticInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.doctor.AuthenticInfoService#updateAuthenticInfo(com.group.renshi.bean.doctor.AuthenticInfoBean)
	 */
	@Override
	public void updateAuthenticInfo(AuthenticInfoBean authenticInfoBean) {
		AuthenticInfoBean authenticInfoBeanData = authenticInfoDao.load(authenticInfoBean
				.getAccountId());

		authenticInfoDao.update(authenticInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.doctor.AuthenticInfoService#findById(int)
	 */
	@Override
	public AuthenticInfoBean findById(int id) {
		return authenticInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.doctor.AuthenticInfoService#listAuthenticInfo(com.group.renshi.bean.doctor.AuthenticInfoBean)
	 */
	@Override
	public List<AuthenticInfoBean> listAuthenticInfo(AuthenticInfoBean authenticInfoBean) {
		List<AuthenticInfoBean> authenticInfoList = authenticInfoDao.listData(authenticInfoBean);
		return authenticInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.doctor.AuthenticInfoService#pageAuthenticInfo(com.group.renshi.bean.doctor.AuthenticInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<AuthenticInfoBean> pageAuthenticInfo(
			AuthenticInfoBean authenticInfoBean, PageQueryResult<AuthenticInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(authenticInfoDao, authenticInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}