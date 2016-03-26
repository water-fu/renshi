package com.group.renshi.service.admin.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.admin.AgentDoctorRelationBean;
import com.group.renshi.service.admin.AgentDoctorRelationService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AgentDoctorRelationServiceImpl.java,v 0.1 2015-07-27 下午09:28:49 Exp $
 */
@Service("AgentDoctorRelationService")
@Transactional
public class AgentDoctorRelationServiceImpl extends ServiceSupport implements AgentDoctorRelationService {
	/**
	 * 插入对象
	 */
	@Override
	public AgentDoctorRelationBean insertDoctorRelation(AgentDoctorRelationBean AgentDoctorRelationBean) {
		agentDoctorRelationDao.insert(AgentDoctorRelationBean);
		return AgentDoctorRelationBean;
	}

	/**
	 * 删除对象
	 */
	@Override
	public void deleteDoctorRelation(int id) {
		agentDoctorRelationDao.delete(id);
	}

	/**
	 * 更新对象
	 */
	@Override
	public void updateDoctorRelation(AgentDoctorRelationBean AgentDoctorRelationBean) {
		AgentDoctorRelationBean AgentDoctorRelationBeanData = agentDoctorRelationDao.load(AgentDoctorRelationBean.getId());

		agentDoctorRelationDao.update(AgentDoctorRelationBeanData);
	}

	/**
	 * 根据主键获取对象
	 */
	@Override
	public AgentDoctorRelationBean findById(int id) {
		return agentDoctorRelationDao.load(id);
	}

	/**
	 * 获取列表数据
	 */
	@Override
	public List<AgentDoctorRelationBean> listDoctorRelation(AgentDoctorRelationBean AgentDoctorRelationBean) {
		List<AgentDoctorRelationBean> doctorRelationList = agentDoctorRelationDao.listData(AgentDoctorRelationBean);
		return doctorRelationList;
	}

	/**
	 * 获取分页数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<AgentDoctorRelationBean> pageDoctorRelation(AgentDoctorRelationBean AgentDoctorRelationBean, PageQueryResult<AgentDoctorRelationBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(agentDoctorRelationDao, AgentDoctorRelationBean, pageQueryResult);

		return pageQueryResult;
	}
}