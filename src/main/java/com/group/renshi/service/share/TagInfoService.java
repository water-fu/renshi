package com.group.renshi.service.share;

import java.util.List;

import com.group.renshi.bean.share.TagInfoBean;
import com.group.webFramework.uitl.PageQueryResult;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: TagInfoService.java,v 0.1 2015-07-03 下午08:32:29 Exp $
 */
public interface TagInfoService
{
	/**
	 * 插入对象
	 * 
	 * @param tagInfoBean  需要插入的实体对象
	 * @return 返回插入后带自增长主键的对象
	 */
    TagInfoBean insertTagInfo(TagInfoBean tagInfoBean);
    
    /**
	 * 根据主键删除
	 * 
	 * @param id  主键编号
	 */
    void deleteTagInfo(int id);
    
    /**
	 * 更新对象
	 * 
	 * @param tagInfoBean  需要更新的实体对象
	 */
    void updateTagInfo(TagInfoBean tagInfoBean);
    
    /**
	 * 根据主键获取对象
	 * 
	 * @param id  主键编号
	 * @return  返回实体对象
	 */
    TagInfoBean findById(int id);
    
    /**
	 * 获取列表数据
	 * 
	 * @param tagInfoBean  实体对象
	 * @return   返回列表对象
	 */
    List<TagInfoBean> listTagInfo(TagInfoBean tagInfoBean);
    
    /**
	 * 获取分页数据
	 * 
	 * @param tagInfoBean  实体对象
	 * @param pageQueryResult   分页对象
	 * @return  返回分页对象
	 */
	PageQueryResult<TagInfoBean> pageTagInfo(TagInfoBean tagInfoBean, PageQueryResult<TagInfoBean> pageQueryResult);
}