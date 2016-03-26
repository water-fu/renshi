package com.group.renshi.dao.share;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.group.renshi.bean.share.ShareInfoBean;
import com.group.webFramework.common.BaseDao;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: ShareInfoDao.java,v 0.1 2015-06-09 下午02:11:11 Exp $
 */
public interface ShareInfoDao extends BaseDao<ShareInfoBean> {

	/**
	 * 获取热门微博
	 * 
	 * @param accountId
	 * @return
	 */
	List<ShareInfoBean> getHotList(int accountId);

	/**
	 * 
	 * @return
	 */
	int countNewAskAnswer(@Param("searchCon") String searchCon);

	/**
	 * 
	 * @return
	 */
	List<ShareInfoBean> listNewAskAnswer(
			@Param("pageQueryResult") PageQueryResult<ShareInfoBean> pageQueryResult,
			@Param("searchCon") String searchCOn);

	/**
	 * 
	 * @return
	 */
	int countHotAskAnswer();

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	List<ShareInfoBean> listHotAskAnswer(
			@Param("pageQueryResult") PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 
	 * @return
	 */
	int countNoAskAnswer();

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	List<ShareInfoBean> listNoAskAnswer(
			@Param("pageQueryResult") PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 
	 * @param id
	 * @return
	 */
	ShareInfoBean loadExtend(@Param("id") int id);

	/**
	 * 
	 * @return
	 */
	int countLevelVideo(@Param("type") int type,
			@Param("searchCon") String searchCon);

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	List<ShareInfoBean> listLevelVideo(
			@Param("type") int type,
			@Param("pageQueryResult") PageQueryResult<ShareInfoBean> pageQueryResult,
			@Param("searchCon") String searchCon);

	/**
	 * 
	 * @param profess
	 * @return
	 */
	int countProfessVideo(@Param("profess") String profess,
			@Param("type") int type, @Param("searchCon") String searchCon);

	/**
	 * 
	 * @param profess
	 * @param pageQueryResult
	 * @return
	 */
	List<ShareInfoBean> listProfessVideo(
			@Param("profess") String profess,
			@Param("type") int type,
			@Param("pageQueryResult") PageQueryResult<ShareInfoBean> pageQueryResult,
			@Param("searchCon") String searchCon);

	/**
	 * 获取待审核医生作品数据
	 * 
	 * @param map
	 * @return
	 */
	public List<ShareInfoBean> pageDocProductions(Map<String, Object> map);

	public int countPageDocProductions(Map<String, Object> map);

	/**
	 * 
	 * @param accountId
	 * @return
	 */
	int countRelateme(@Param("accountId") int accountId);

	/**
	 * 
	 * @param accountId
	 * @param pageQueryResult
	 * @return
	 */
	List<ShareInfoBean> listReloateme(
			@Param("accountId") int accountId,
			@Param("pageQueryResult") PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	List<ShareInfoBean> getInterestVlist(Map<String, Object> paramMap);

}
