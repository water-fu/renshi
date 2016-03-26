package com.group.renshi.service.share.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.share.PersonInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.share.PersonInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: PersonInfoServiceImpl.java,v 0.1 2015-06-09 下午08:53:43 Exp $
 */
@Service("personInfoService")
@Transactional
public class PersonInfoServiceImpl extends ServiceSupport implements
		PersonInfoService {
	/**
	 * 插入对象
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#insertPersonInfo(com.group.renshi.bean.share.PersonInfoBean)
	 */
	@Override
	public PersonInfoBean insertPersonInfo(PersonInfoBean personInfoBean) {
		personInfoDao.insert(personInfoBean);
		return personInfoBean;
	}

	/**
	 * 删除对象
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#deletePersonInfo(int)
	 */
	@Override
	public void deletePersonInfo(int id) {
		personInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#updatePersonInfo(com.group.renshi.bean.share.PersonInfoBean)
	 */
	@Override
	public void updatePersonInfo(PersonInfoBean personInfoBean) {
		PersonInfoBean personInfoBeanData = personInfoDao.load(personInfoBean
				.getPersonId());

		personInfoDao.update(personInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#findById(int)
	 */
	@Override
	public PersonInfoBean findById(int id) {
		return personInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#listPersonInfo(com.group.renshi.bean.share.PersonInfoBean)
	 */
	@Override
	public List<PersonInfoBean> listPersonInfo(PersonInfoBean personInfoBean) {
		List<PersonInfoBean> personInfoList = personInfoDao
				.listData(personInfoBean);
		return personInfoList;
	}

	/**
	 * 获取分页数据
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#pagePersonInfo(com.group.renshi.bean.share.PersonInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<PersonInfoBean> pagePersonInfo(
			PersonInfoBean personInfoBean,
			PageQueryResult<PersonInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(personInfoDao, personInfoBean,
				pageQueryResult);

		return pageQueryResult;
	}

	/**
	 * 根据accountId获取个人空间信息
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#findByAccountId(int)
	 */
	@Override
	public PersonInfoBean findByAccountId(int accountId) {
		PersonInfoBean personInfoBeanCond = new PersonInfoBean();
		personInfoBeanCond.setAccountId(accountId);

		List<PersonInfoBean> list = personInfoDao.listData(personInfoBeanCond);
		PersonInfoBean personInfoBeanData = list.get(0);

		return personInfoBeanData;
	}

	/**
	 * 个人空间流量数量+1
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#updateBrowerNum(com.group.renshi.bean.share.PersonInfoBean)
	 */
	@Override
	public void updateBrowerNum(PersonInfoBean personInfoBean) {
		PersonInfoBean personInfoBeanCond = new PersonInfoBean();
		personInfoBeanCond.setAccountId(personInfoBean.getAccountId());

		List<PersonInfoBean> list = personInfoDao.listData(personInfoBeanCond);
		PersonInfoBean personInfoBeanData = list.get(0);

		personInfoBeanData.setBrowerNum(personInfoBeanData.getBrowerNum() + 1);
		personInfoDao.update(personInfoBeanData);
	}

	/**
	 * 获取最权威医生列表
	 * 
	 * @see com.group.renshi.service.share.PersonInfoService#findMostAnswer()
	 */
	@Override
	public List<PersonInfoBean> findMostAnswer() {
		List<PersonInfoBean> personInfoList = personInfoDao.findMostAnswer();
		return personInfoList;
	}

	/**
	 * @see com.group.renshi.service.share.PersonInfoService#openSpace(int)
	 */
	@Override
	public void openSpace(int id) {
		PersonInfoBean personInfoBean = personInfoDao.load(id);

		personInfoBean.setPersonStatus(SystemConstantType.PERSON_STATUS_OPEN);

		personInfoDao.update(personInfoBean);
	}

	/**
	 * @see com.group.renshi.service.share.PersonInfoService#closeSpace(int)
	 */
	@Override
	public void closeSpace(int id) {
		PersonInfoBean personInfoBean = personInfoDao.load(id);

		personInfoBean.setPersonStatus(SystemConstantType.PERSON_STATUS_CLOSE);

		personInfoDao.update(personInfoBean);
	}

	/**
	 * @see com.group.renshi.service.share.PersonInfoService#findMostPerson(java.lang.String)
	 */
	@Override
	public List<PersonInfoBean> findMostPerson(String shareType) {
		List<PersonInfoBean> personInfoList = personInfoDao.findMostPerson(shareType);
		return personInfoList;
	}
}