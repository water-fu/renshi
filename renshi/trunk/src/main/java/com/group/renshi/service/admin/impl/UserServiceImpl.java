package com.group.renshi.service.admin.impl;

import com.group.renshi.bean.admin.UserBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.admin.UserService;
import com.group.webFramework.common.ServiceSupport;
import com.group.webFramework.entity.AdminDetails;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.SessionControl;
import com.group.webFramework.uitl.encrypt.EncryptFactory;
import com.group.webFramework.uitl.encrypt.IEncrypt;
import com.group.webFramework.uitl.encrypt.MD5Encrypt;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 总体说明
 * <p>具体说明</p>
 * @author Administrator
 * @version $Id: UserServiceImpl.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends ServiceSupport implements UserService {

	private static final Logger log = Logger.getLogger(UserServiceImpl.class);

	/**
	 * 插入对象
	 * @see com.group.renshi.service.admin.UserService#insertUser(com.group.renshi.bean.admin.UserBean)
	 */
	@Override
	public UserBean insertUser(UserBean userBean) {
		userDao.insert(userBean);
		return userBean;
	}

	/**
	 * 删除对象
	 * @see com.group.renshi.service.admin.UserService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int id) {
		userDao.delete(id);
	}

	/**
	 * 更新对象
	 */
	@Override
	public void updateUser(UserBean userBean) {
		UserBean userBeanData = userDao.load(userBean.getUserId());
		if(null != userBean.getLoginAccount()){
			userBeanData.setLoginAccount(userBean.getLoginAccount());
		}
		if(null != userBean.getEmail()){
			userBeanData.setEmail(userBean.getEmail());
		}
		if(null != userBean.getPhone()){
			userBeanData.setPhone(userBean.getPhone());
		}
		if(-1 != userBean.getStatus()){
			userBeanData.setStatus(userBean.getStatus());
		}

		userDao.update(userBeanData);
	}

	/**
	 * 根据主键获取对象
	 */
	@Override
	public UserBean findById(int id) {
		return userDao.load(id);
	}

	/**
	 * 获取列表数据
	 */
	@Override
	public List<UserBean> listUser(UserBean userBean) {
		List<UserBean> userList = userDao.listData(userBean);
		return userList;
	}

	/**
	 * 获取分页数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageQueryResult<UserBean> pageUser(UserBean userBean, PageQueryResult<UserBean> pageQueryResult) {
		pageQueryResult = this.pageDataUtil(userDao, userBean, pageQueryResult);
		return pageQueryResult;
	}



/*	protected PageQueryResult pageSubAccounts(BaseDao baseDao,
										   BaseEntity baseEntity, PageQueryResult pageQueryResult,
										   Map<String, Object>... map) {
		// 获取具体javaBean的类名,并且首字母变小写
		String entityName = toFirstCharLower(baseEntity.getClass().getSimpleName());
		String pageName = toFirstCharLower(pageQueryResult.getClass().getSimpleName());
		// 封装分页查询参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 自定义param参数，可选参数
		if (null != map) {
			for (int i = 0; i < map.length; i++) {
				paramMap.putAll(map[i]);
			}
		}
		paramMap.put(entityName, baseEntity);
		paramMap.put(pageName, pageQueryResult);
		// 查询总记录数
		int totalCount = userDao.countPageSubAccounts(paramMap);
		List userList = new ArrayList();
		// 数量大于0,再进行查询数据
		if (totalCount > 0) {
			// 查询数据
			userList = userDao.pageSubAccounts(paramMap);
		}
		// 设置分页查询结果
		pageQueryResult.setList(userList);
		pageQueryResult.setTotalCount(totalCount);
		return pageQueryResult;
	}*/


	/**
	 * 后台用户登录
	 * @param userBean
	 * @return
	 */
	@Override
	public UserBean login(UserBean userBean, HttpServletRequest request){

		//FIXME 代理商审核通过后才能登录后台系统

	//1、判断账号是否注册
		UserBean reqBean = new UserBean();
		reqBean.setLoginAccount(userBean.getLoginAccount());
		List<UserBean> list = userDao.listData(reqBean);
		if (CollectionUtils.isEmpty(list)) {
			throw new ApplicationException("您输入的账号不存在!");
		}

	//2、账号或密码错误
		UserBean respBean = list.get(0);
		IEncrypt encrypt = EncryptFactory.getInstance(MD5Encrypt.class.getSimpleName());
		String password = encrypt.encodePassword(userBean.getLoginPassword(), SystemConstantType.PASS_SALT);
		if (!password.equals(respBean.getLoginPassword())) {
			throw new ApplicationException("您输入的账号 密码错误!");
		}
		if(respBean.getUserType().equals("2") && respBean.getStatus() != 2){
			throw new ApplicationException("该代理商帐号未认证通过，不能登录!");
		}

	//3、保存session
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setUserBean(respBean);
		SessionControl.setAttribute(request, SystemConstantType.ADMIN_DETAILS, adminDetails);

		return respBean;
	}


	@Override
	public void changePassword(int userId, String oldPassword, String password) {
		// 密码用MD5加密
		IEncrypt iEncrypt = EncryptFactory.getInstance(MD5Encrypt.class.getSimpleName());
		oldPassword = iEncrypt.encodePassword(oldPassword, SystemConstantType.PASS_SALT);

		UserBean userBean = userDao.load(userId);
		if (!userBean.getLoginPassword().equals(oldPassword)) {
			throw new ApplicationException("旧密码填写错误");
		}

		password = iEncrypt.encodePassword(password, SystemConstantType.PASS_SALT);
		userBean.setLoginPassword(password);
		userDao.update(userBean);
	}

}