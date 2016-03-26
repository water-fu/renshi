package com.group.renshi.service.doctor.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.doctor.MeetingInfoBean;
import com.group.renshi.service.doctor.MeetingInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MeetingInfoServiceImpl.java,v 0.1 2015-06-17 下午11:18:04 Exp $
 */
@Service("meetingInfoService")
@Transactional
public class MeetingInfoServiceImpl extends ServiceSupport implements MeetingInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.doctor.MeetingInfoService#insertMeetingInfo(com.group.renshi.bean.doctor.MeetingInfoBean)
	 */
	@Override
	public MeetingInfoBean insertMeetingInfo(MeetingInfoBean meetingInfoBean) {
		meetingInfoDao.insert(meetingInfoBean);
		return meetingInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.doctor.MeetingInfoService#deleteMeetingInfo(int)
	 */
	@Override
	public void deleteMeetingInfo(int id) {
		meetingInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.doctor.MeetingInfoService#updateMeetingInfo(com.group.renshi.bean.doctor.MeetingInfoBean)
	 */
	@Override
	public void updateMeetingInfo(MeetingInfoBean meetingInfoBean) {
		MeetingInfoBean meetingInfoBeanData = meetingInfoDao.load(meetingInfoBean.getMeetingId());

		meetingInfoDao.update(meetingInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.doctor.MeetingInfoService#findById(int)
	 */
	@Override
	public MeetingInfoBean findById(int id) {
		return meetingInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.doctor.MeetingInfoService#listMeetingInfo(com.group.renshi.bean.doctor.MeetingInfoBean)
	 */
	@Override
	public List<MeetingInfoBean> listMeetingInfo(MeetingInfoBean meetingInfoBean) {
		List<MeetingInfoBean> meetingInfoList = meetingInfoDao.listData(meetingInfoBean);
		return meetingInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.doctor.MeetingInfoService#pageMeetingInfo(com.group.renshi.bean.doctor.MeetingInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<MeetingInfoBean> pageMeetingInfo(MeetingInfoBean meetingInfoBean,
			PageQueryResult<MeetingInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(meetingInfoDao, meetingInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}