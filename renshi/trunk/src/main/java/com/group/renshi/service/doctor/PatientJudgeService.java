package com.group.renshi.service.doctor;

import java.util.List;

import com.group.renshi.bean.doctor.PatientJudgeBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PatientJudgeService.java,v 0.1 2015-06-17 下午11:08:21 Exp $
 */
public interface PatientJudgeService {
	/**
	 * 插入对象
	 * 
	 * @param patientJudgeBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	PatientJudgeBean insertPatientJudge(PatientJudgeBean patientJudgeBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deletePatientJudge(int id);

	/**
	 * 更新对象
	 * 
	 * @param patientJudgeBean  需要更新的实体对象
	 */
	void updatePatientJudge(PatientJudgeBean patientJudgeBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	PatientJudgeBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param patientJudgeBean  实体对象
	 * @return   返回列表对象
	 */
	List<PatientJudgeBean> listPatientJudge(PatientJudgeBean patientJudgeBean);

	/**
	 * 获取分页数据
	 * 
	 * @param patientJudgeBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<PatientJudgeBean> pagePatientJudge(PatientJudgeBean patientJudgeBean,
			PageQueryResult<PatientJudgeBean> pageQueryResult);
}