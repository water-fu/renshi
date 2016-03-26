package com.group.renshi.service.share;

import java.util.List;

import com.group.renshi.bean.share.PraiseInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: PraiseInfoService.java,v 0.1 2015-06-23 下午08:20:07 Exp $
 */
public interface PraiseInfoService {
	/**
	 * 插入对象
	 * 
	 * @param praiseInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	PraiseInfoBean insertPraiseInfo(PraiseInfoBean praiseInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deletePraiseInfo(PraiseInfoBean praiseInfoBean);

	/**
	 * 更新对象
	 * 
	 * @param praiseInfoBean  需要更新的实体对象
	 */
	void updatePraiseInfo(PraiseInfoBean praiseInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	PraiseInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param praiseInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<PraiseInfoBean> listPraiseInfo(PraiseInfoBean praiseInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param praiseInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<ShareInfoBean> pagePraiseInfo(PraiseInfoBean praiseInfoBean,
			PageQueryResult<ShareInfoBean> pageQueryResult);
}