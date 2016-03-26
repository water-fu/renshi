package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.PatientJudgeBean;
import com.group.renshi.service.doctor.PatientJudgeService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PatientJudgeServiceImpl.java,v 0.1 2015-06-17 下午11:08:21 Exp $
 */
@Service("patientJudgeService")
@Transactional
public class PatientJudgeServiceImpl extends ServiceSupport implements PatientJudgeService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.doctor.PatientJudgeService#insertPatientJudge(com.group.renshi.bean.doctor.PatientJudgeBean)
	 */
	@Override
	public PatientJudgeBean insertPatientJudge(PatientJudgeBean patientJudgeBean) {
		patientJudgeDao.insert(patientJudgeBean);
		return patientJudgeBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.doctor.PatientJudgeService#deletePatientJudge(int)
	 */
	@Override
	public void deletePatientJudge(int id) {
		patientJudgeDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.doctor.PatientJudgeService#updatePatientJudge(com.group.renshi.bean.doctor.PatientJudgeBean)
	 */
	@Override
	public void updatePatientJudge(PatientJudgeBean patientJudgeBean) {
		PatientJudgeBean patientJudgeBeanData = patientJudgeDao.load(patientJudgeBean
				.getPatientId());

		patientJudgeDao.update(patientJudgeBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.doctor.PatientJudgeService#findById(int)
	 */
	@Override
	public PatientJudgeBean findById(int id) {
		return patientJudgeDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.doctor.PatientJudgeService#listPatientJudge(com.group.renshi.bean.doctor.PatientJudgeBean)
	 */
	@Override
	public List<PatientJudgeBean> listPatientJudge(PatientJudgeBean patientJudgeBean) {
		List<PatientJudgeBean> patientJudgeList = patientJudgeDao.listData(patientJudgeBean);
		return patientJudgeList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.doctor.PatientJudgeService#pagePatientJudge(com.group.renshi.bean.doctor.PatientJudgeBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<PatientJudgeBean> pagePatientJudge(PatientJudgeBean patientJudgeBean,
			PageQueryResult<PatientJudgeBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(patientJudgeDao, patientJudgeBean, pageQueryResult);

		return pageQueryResult;
	}
}