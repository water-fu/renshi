package com.group.renshi.service.share.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.renshi.bean.share.AttachInfoBean;
import com.group.renshi.service.share.AttachInfoService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: AttachInfoServiceImpl.java,v 0.1 2015-06-11 下午10:49:30 Exp $
 */
@Service("attachInfoService")
@Transactional
public class AttachInfoServiceImpl extends ServiceSupport implements AttachInfoService {
	/**
	 * 插入对象
	 * @see com.group.renshi.service.share.AttachInfoService#insertAttachInfo(com.group.renshi.bean.share.AttachInfoBean)
	 */
	@Override
	public AttachInfoBean insertAttachInfo(AttachInfoBean attachInfoBean) {
		attachInfoDao.insert(attachInfoBean);
		return attachInfoBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.share.AttachInfoService#deleteAttachInfo(int)
	 */
	@Override
	public void deleteAttachInfo(int id) {
		attachInfoDao.delete(id);
	}

	/**
	 * 更新对象
	 * @see com.group.renshi.service.share.AttachInfoService#updateAttachInfo(com.group.renshi.bean.share.AttachInfoBean)
	 */
	@Override
	public void updateAttachInfo(AttachInfoBean attachInfoBean) {
		AttachInfoBean attachInfoBeanData = attachInfoDao.load(attachInfoBean.getAttachId());

		attachInfoDao.update(attachInfoBeanData);
	}

	/**
	 * 根据主键获取对象
	 * @see com.group.renshi.service.share.AttachInfoService#findById(int)
	 */
	@Override
	public AttachInfoBean findById(int id) {
		return attachInfoDao.load(id);
	}

	/**
	 * 获取列表数据
	 * @see com.group.renshi.service.share.AttachInfoService#listAttachInfo(com.group.renshi.bean.share.AttachInfoBean)
	 */
	@Override
	public List<AttachInfoBean> listAttachInfo(AttachInfoBean attachInfoBean) {
		List<AttachInfoBean> attachInfoList = attachInfoDao.listData(attachInfoBean);
		return attachInfoList;
	}

	/**
	 * 获取分页数据
	 * @see com.group.renshi.service.share.AttachInfoService#pageAttachInfo(com.group.renshi.bean.share.AttachInfoBean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<AttachInfoBean> pageAttachInfo(AttachInfoBean attachInfoBean,
			PageQueryResult<AttachInfoBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(attachInfoDao, attachInfoBean, pageQueryResult);

		return pageQueryResult;
	}
}