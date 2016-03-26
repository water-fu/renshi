package com.group.renshi.dao.doctor;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.webFramework.common.BaseDao;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: UserInfoDao.java,v 0.1 2015-05-25 下午09:07:32 Exp $
 */
public interface UserInfoDao extends BaseDao<UserInfoBean> {

	public List<UserInfoBean> QueryKnowBeanList(@Param("belongDept") String belongDept,
			@Param("belongHospital") String belongHospital, @Param("liveTown") String liveTown,
			@Param("schoolName") String schoolName, @Param("accountId") int accountId,
			@Param("pageQueryResult") PageQueryResult<UserInfoBean> pageQueryResult);

	public List<UserInfoBean> QueryHelpBeanList(@Param("belongDept") String belongDept,
			@Param("professLevel") int professLevel, @Param("accountId") int accountId,
			@Param("pageQueryResult") PageQueryResult<UserInfoBean> pageQueryResult);

}
