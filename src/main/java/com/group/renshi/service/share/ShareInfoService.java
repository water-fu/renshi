package com.group.renshi.service.share;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.group.renshi.bean.share.AttachInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 * 
 * <p>
 * 具体说明
 * </p>
 * 
 * @author Administrator
 * @version $Id: ShareInfoService.java,v 0.1 2015-06-09 下午02:11:11 Exp $
 */
public interface ShareInfoService {
	/**
	 * 插入对象
	 * 
	 * @param shareInfoBean
	 *            需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	ShareInfoBean insertShareInfo(ShareInfoBean shareInfoBean,
			HttpServletRequest request);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键编号
	 */
	void deleteShareInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param shareInfoBean
	 *            需要更新的实体对象
	 */
	void updateShareInfo(ShareInfoBean shareInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id
	 *            主键编号
	 * @return 返回实体对象
	 */
	ShareInfoBean findById(int id);

	public ShareInfoBean loadExtend(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param shareInfoBean
	 *            实体对象
	 * @return 返回列表对象
	 */
	List<ShareInfoBean> listShareInfo(ShareInfoBean shareInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param shareInfoBean
	 *            实体对象
	 * @param pageQueryResult
	 *            分页对象
	 * @return 返回分页对象
	 */
	PageQueryResult<ShareInfoBean> pageShareInfo(ShareInfoBean shareInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchType,
			HttpServletRequest request);

	/**
	 * 获取所有待审核的医生作品数据
	 * 
	 * @param shareInfoBean
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> pageShareInfo(ShareInfoBean shareInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 获取热门分享
	 * 
	 * @param accountId
	 * @return
	 */
	List<ShareInfoBean> getHotList(int accountId);

	/**
	 * 获取分享附件
	 * 
	 * @param shareId
	 * @return
	 */
	List<AttachInfoBean> getAttachInfoList(int shareId);

	/**
	 * 获取热门医问
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> getNewAskAnswer(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon);

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> getHotAskAnswer(
			PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> getNoAskAnswer(
			PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 获取推荐视屏
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> listLevelVideo(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon);

	/**
	 * 根据科室查询视频
	 * 
	 * @param string
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> listProfessVideo(String string,
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon);

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> listLevelPoint(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon);

	/**
	 * 根据科室查询视频
	 * 
	 * @param string
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> listProfessPoint(String string,
			PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> listLevelCase(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon);

	/**
	 * 
	 * @param pageQueryResult
	 * @return
	 */
	PageQueryResult<ShareInfoBean> listLevelLibrary(
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchCon);

	/**
	 * 
	 * @return
	 */
	PageQueryResult<ShareInfoBean> loadReloadme(int accountId,
			PageQueryResult<ShareInfoBean> pageQueryResult);

	/**
	 * 
	 * @param shareInfoBean
	 * @param pageQueryResult
	 * @param searchType
	 * @param sqlDate
	 * @param request
	 * @return
	 */
	PageQueryResult<ShareInfoBean> pageShareInfoWithTime(
			ShareInfoBean shareInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult, String searchType,
			Date sqlDate, HttpServletRequest request);

	/**
	 * 根据科室获取你可能感兴趣的视频
	 * 
	 * @param belongDept
	 * @param belongDept2
	 * @param searchType
	 * @return
	 */
	List<ShareInfoBean> getInterestVList(// String searchType,
			String shareType, String belongDept);
}