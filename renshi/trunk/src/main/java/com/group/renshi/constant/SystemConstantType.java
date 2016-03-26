package com.group.renshi.constant;

/**
 * 总体说明 系统常量类
 *
 * <p>
 * 具体说明
 * </p>
 *
 * @author Administrator
 * @version $Id: SystemConstantType.java,v 0.1 2015-5-19 上午9:38:50 Exp $
 */
public class SystemConstantType {

	/**
	 * 加密钥匙
	 */
	public static final String PASS_SALT = "renshi";

	/**
	 * 存在session中的用户信息key
	 */
	public static final String USER_DETAILS = "USER_DETAILS";

	/**
	 * 存在session中的用户信息key
	 */
	public static final String ADMIN_DETAILS = "ADMIN_DETAILS";

	/**
	 * 验证码
	 */
	public static final String CHECK_CODE = "checkCode";

	/**
	 * 注册邮件模版名称
	 */
	public static final String REGISTER_MAIL = "registerMail.html";

	/**
	 * 忘记密码邮件模版名称
	 */
	public static final String FORGET_MAIL = "forgetMail.html";

	/**
	 * 重置绑定邮箱模板
	 */
	public static final String RESET_MAIL = "resetMail.html";
	// 文件上传存储路径

	/**
	 * 头像上传存储路径
	 */
	public static final String HEAD_PATH = "headPath";

	/**
	 * 身份证上传存储路径
	 */
	public static final String ID_CARD = "idCardPath";

	/**
	 * 认证证书存储路径
	 */
	public static final String CRETIFICATE_PATH = "cretificatePath";

	/**
	 * 视频上传存储路径
	 */
	public static final String VIDEO_PATH = "videoPath";

	/**
	 * 观点上传存储路径
	 */
	public static final String POINT_PATH = "pointPath";

	/**
	 * 病例上传存储路径
	 */
	public static final String CASE_PATH = "casePath";

	/**
	 * 文档上传存储路径
	 */
	public static final String LIBRARY_PATH = "libraryPath";

	/**
	 * 医问上传存储路径
	 */
	public static final String QUESTION_PATH = "questionPath";

	// 注册方式

	/**
	 * 手机
	 */
	public static final int REGISTER_TYPE_PHONE = 1;

	/**
	 * 邮箱
	 */
	public static final int REGISTER_TYPE_MAIL = 2;

	/**
	 * 其他
	 */
	public static final int REGISTER_TYPE_OTHER = 3;

	// 账号类型

	/**
	 * 医生
	 */
	public static final int ACCOUNT_TYPE_DOCTOR = 1;

	/**
	 * 代理商
	 */
	public static final int ACCOUNT_TYPE_AGENT = 2;

	// 认证状态

	/**
	 * 未认证
	 */
	public static final int ACCOUNT_STATUS_ZERO = 0;

	/**
	 * 第一步
	 */
	public static final int ACCOUNT_STATUS_FIRST = 1;

	/**
	 * 第二步
	 */
	public static final int ACCOUNT_STATUS_SECOND = 2;

	/**
	 * 第三步
	 */
	public static final int ACCOUNT_STATUS_THIRD = 3;

	/**
	 * 第四步,完成
	 */
	public static final int ACCOUNT_STATUS_FORTH = 4;

	// 激活状态

	/**
	 * 未激活
	 */
	public static final int ACTIVE_TYPE_NO = 0;

	/**
	 * 激活
	 */
	public static final int ACTIVE_TYPE_YES = 1;

	// 校验类型

	/**
	 * 注册邮件
	 */
	public static final int VALID_TYPE_REGISTER = 1;

	/**
	 * 忘记密码
	 */
	public static final int VALID_TYPE_FORGETPASS = 2;

	/**
	 * 重置绑定邮箱
	 */
	public static final int VALID_TYPE_RESTMAIL = 3;

	// 校验码是否使用

	/**
	 * 未使用
	 */
	public static final int VALID_BOOL_UNUSE = 0;

	/**
	 * 使用
	 */
	public static final int VALID_BOOL_USED = 1;

	// 用户空间状态

	/**
	 * 开通
	 */
	public static final int PERSON_STATUS_OPEN = 1;

	/**
	 * 关闭
	 */
	public static final int PERSON_STATUS_CLOSE = 0;

	// 关注类型

	/**
	 * 单向关注，即我关注他，或他关注我
	 */
	public static final int FOLLOW_TYPE_ONE = 1;

	/**
	 * 双向关注，即相互关注
	 */
	public static final int FOLLOW_TYPE_TWO = 2;

	// 职位级别

	/**
	 * 住院医师级别
	 */
	public static int PROFESS_LEVEL_WORK_ONE = 1;

	/**
	 * 主治医生级别
	 */
	public static int PROFESS_LEVEL_WORK_TWO = 2;

	/**
	 * 副主任医师
	 */
	public static int PROFESS_LEVEL_WORK_THREE = 3;

	/**
	 * 主任医师
	 */
	public static int PROFESS_LEVEL_WORK_FOURTH = 4;

	// 评论类型

	/**
	 * 回复分享
	 */
	public static int DISCUSS_TYPE_SHARE = 1;

	/**
	 * 回复评论
	 */
	public static int DISCUSS_TYPE_DISCUSS = 2;

	/**
	 * 回复赞
	 */
	public static int DISCUSS_TYPE_PRAISE = 3;

	// 代理商身份

	/**
	 * 公司
	 */
	public static int PROXY_TYPE_COMPANY = 1;

	/**
	 * 个人
	 */
	public static int PROXY_TYPE_PERSON = 2;

	/**
	 * @author CJH 搜索类型
	 */
	public static Integer FANS = 1;// 粉丝搜索

	public static Integer CONCERN = 2;// 搜索关注
}
