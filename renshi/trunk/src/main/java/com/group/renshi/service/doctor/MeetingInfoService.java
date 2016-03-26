package com.group.renshi.service.doctor;

import java.util.List;

import com.group.renshi.bean.doctor.MeetingInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: MeetingInfoService.java,v 0.1 2015-06-17 下午11:18:04 Exp $
 */
public interface MeetingInfoService {
	/**
	 * 插入对象
	 * 
	 * @param meetingInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	MeetingInfoBean insertMeetingInfo(MeetingInfoBean meetingInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteMeetingInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param meetingInfoBean  需要更新的实体对象
	 */
	void updateMeetingInfo(MeetingInfoBean meetingInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	MeetingInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param meetingInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<MeetingInfoBean> listMeetingInfo(MeetingInfoBean meetingInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param meetingInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<MeetingInfoBean> pageMeetingInfo(MeetingInfoBean meetingInfoBean,
			PageQueryResult<MeetingInfoBean> pageQueryResult);
}