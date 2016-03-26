package com.group.renshi.service.admin;

import com.group.renshi.bean.admin.UserBean;
import com.group.webFramework.uitl.PageQueryResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: UserService.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
public interface UserService
{
    /**
     * 插入对象
     *
     * @param userBean  需要插入的实体对象
     * @return 返回插入后带自增长主键的对象
     */
    UserBean insertUser(UserBean userBean);

    /**
     * 根据主键删除
     *
     * @param id  主键编号
     */
    void deleteUser(int id);

    /**
     * 更新对象
     *
     * @param userBean  需要更新的实体对象
     */
    void updateUser(UserBean userBean);

    /**
     * 根据主键获取对象
     *
     * @param id  主键编号
     * @return  返回实体对象
     */
    UserBean findById(int id);

    /**
     * 获取列表数据
     *
     * @param userBean  实体对象
     * @return   返回列表对象
     */
    List<UserBean> listUser(UserBean userBean);

    /**
     * 获取分页数据
     *
     * @param userBean  实体对象
     * @param pageQueryResult   分页对象
     * @return  返回分页对象
     */
    PageQueryResult<UserBean> pageUser(UserBean userBean, PageQueryResult<UserBean> pageQueryResult);


    /**
     * 后台用户登录
     * @param userBean
     * @return
     */
    public UserBean login(UserBean userBean, HttpServletRequest request);


    public void changePassword(int userId, String oldPassword, String password);
}