package com.group.renshi.service.share;

import java.util.List;

import com.group.renshi.bean.share.AttachInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AttachInfoService.java,v 0.1 2015-06-11 下午10:49:30 Exp $
 */
public interface AttachInfoService {
	/**
	 * 插入对象
	 * 
	 * @param attachInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
	AttachInfoBean insertAttachInfo(AttachInfoBean attachInfoBean);

	/**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
	void deleteAttachInfo(int id);

	/**
	 * 更新对象
	 * 
	 * @param attachInfoBean  需要更新的实体对象
	 */
	void updateAttachInfo(AttachInfoBean attachInfoBean);

	/**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
	AttachInfoBean findById(int id);

	/**
	 * 获取列表数据
	 * 
	 * @param attachInfoBean  实体对象
	 * @return   返回列表对象
	 */
	List<AttachInfoBean> listAttachInfo(AttachInfoBean attachInfoBean);

	/**
	 * 获取分页数据
	 * 
	 * @param attachInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<AttachInfoBean> pageAttachInfo(AttachInfoBean attachInfoBean,
			PageQueryResult<AttachInfoBean> pageQueryResult);
}