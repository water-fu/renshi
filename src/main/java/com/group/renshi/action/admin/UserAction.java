package com.group.renshi.action.admin;

import com.group.renshi.bean.admin.UserBean;
import com.group.renshi.bean.doctor.AuthenticInfoBean;
import com.group.renshi.bean.doctor.UserInfoBean;
import com.group.renshi.bean.share.ShareInfoBean;
import com.group.renshi.bean.system.AccountInfoBean;
import com.group.renshi.bean.system.AreaInfoBean;
import com.group.renshi.bean.system.DeptInfoBean;
import com.group.renshi.bean.system.HospitalInfoBean;
import com.group.renshi.constant.SystemConstantType;
import com.group.renshi.service.admin.UserService;
import com.group.renshi.service.doctor.AuthenticInfoService;
import com.group.renshi.service.doctor.UserInfoService;
import com.group.renshi.service.share.ShareInfoService;
import com.group.renshi.service.system.AccountInfoService;
import com.group.renshi.service.system.AreaInfoService;
import com.group.renshi.service.system.DeptInfoService;
import com.group.renshi.service.system.HospitalInfoService;
import com.group.webFramework.entity.AdminDetails;
import com.group.webFramework.exception.ApplicationException;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.ResponseMessage;
import com.group.webFramework.uitl.SessionControl;
import com.group.webFramework.uitl.encrypt.EncryptFactory;
import com.group.webFramework.uitl.encrypt.IEncrypt;
import com.group.webFramework.uitl.encrypt.MD5Encrypt;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.group.webFramework.common.BaseController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 总体说明
 *
 * <p>具体说明</p>
 *
 * @author Administrator
 * @version $Id: UserAction.java,v 0.1 2015-07-03 下午02:05:39 Exp $
 */
@Controller
@RequestMapping("/admin")
@Scope("prototype")
public class UserAction extends BaseController {

    private static final Logger log = Logger.getLogger(UserAction.class);

    @Resource
    private AccountInfoService accountInfoService;
    @Resource
    private ShareInfoService shareInfoService;
    @Resource
    private UserService userService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private AuthenticInfoService authenticInfoService;
    @Resource
    private AreaInfoService areaInfoService;
    @Resource
    private HospitalInfoService hospitalInfoService;
    @Resource
    private DeptInfoService deptInfoService;


    /**
     * 后台管理首页
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView adminLogin() {
        return responseResult("/admin/adminLogin");
    }

    @RequestMapping(value = "/manage",method = RequestMethod.GET)
    public ModelAndView adminManageHome() {
        AdminDetails adminDetails = SessionControl.getCurAdminDetail(request);
        Map<String,Object> map = new HashMap<String, Object>();
        if(null == adminDetails){
            log.info("Session过期，用户需重新登录。");
            return responseResult("redirect:/admin");
        }
        map.put("userBean", adminDetails.getUserBean());
        return responseResult("/admin/adminManage", map);//将用户信息返回到后台管理页面
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage login(@ModelAttribute UserBean userBean) {
        userBean = userService.login(userBean, request);
        return responseAjaxResult(userBean);
    }


    //获取所有待审核的医生数据
    @RequestMapping(value = "/getApproveInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getApproveInfo(int page, int rows) {
        AccountInfoBean reqBean = new AccountInfoBean();
        reqBean.setAccountStatus(SystemConstantType.ACCOUNT_STATUS_SECOND);
        PageQueryResult<AccountInfoBean> pageQueryResult = new PageQueryResult<AccountInfoBean>();
        pageQueryResult.setPageNo(page);
        pageQueryResult.setPageSize(rows);
        pageQueryResult = accountInfoService.pageAccountInfo(reqBean, pageQueryResult);
        List<AccountInfoBean> accountInfoList = pageQueryResult.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",pageQueryResult.getTotalCount());
        map.put("rows",accountInfoList);
        return map;
    }


    @RequestMapping(value = "/accountApprove", method = RequestMethod.POST)
    @ResponseBody
    public String accountApprove(@RequestParam(value = "accountIds[]") int[] accountIds){
        String flag = "false";
        try{
            if(accountIds.length > 0){
                for(int accountId : accountIds){
                    accountInfoService.approve(accountId);
                }
            }
            flag = "true";
        }catch (Exception e){
            log.error("医生账户审核失败!");
            e.printStackTrace();
        }
        return flag;
    }

    //获取所有待审核的医生作品数据
    @RequestMapping(value = "/getDocProduction", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDocProduction(int page, int rows) {
        ShareInfoBean reqBean = new ShareInfoBean();
        reqBean.setShareStatus(0);//未审核通过
        PageQueryResult<ShareInfoBean> pageQueryResult = new PageQueryResult<ShareInfoBean>();
        pageQueryResult.setPageNo(page);
        pageQueryResult.setPageSize(rows);
        pageQueryResult = shareInfoService.pageShareInfo(reqBean, pageQueryResult);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total", pageQueryResult.getTotalCount());
        map.put("rows", pageQueryResult.getList());
        return map;
    }

    @RequestMapping(value = "/productionApprove", method = RequestMethod.POST)
    @ResponseBody
    public String productionApprove(@RequestParam(value = "shareIds[]") int[] shareIds){
        String flag = "false";
        try{
            if(shareIds.length > 0){
                ShareInfoBean reqBean = new ShareInfoBean();
                for(int shareId : shareIds){
                    reqBean.setShareId(shareId);
                    shareInfoService.updateShareInfo(reqBean);
                }
            }
            flag = "true";
        }catch (Exception e){
            log.error("医生作品审核失败!");
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "/getAccountDetailInfo", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAccountDetailInfo(int accountId) {
        UserInfoBean userInfoBean = userInfoService.findById(accountId);
        AuthenticInfoBean authenticInfoBean = authenticInfoService.findById(accountId);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userInfoBean",userInfoBean);
        map.put("authenticInfoBean",authenticInfoBean);
        return responseResult("/admin/accountDetailInfo", map);
    }

    /**===============================地域信息维护===============================**/

    @RequestMapping(value = "/getAreaInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAreaInfo(int page, int rows) {
        AreaInfoBean reqBean = new AreaInfoBean();
        PageQueryResult<AreaInfoBean> pageQueryResult = new PageQueryResult<AreaInfoBean>();
        pageQueryResult.setPageNo(page);
        pageQueryResult.setPageSize(rows);
        pageQueryResult = areaInfoService.pageAreaInfo(reqBean, pageQueryResult);
        List<AreaInfoBean> accountInfoList = pageQueryResult.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",pageQueryResult.getTotalCount());
        map.put("rows", accountInfoList);
        return map;
    }

    @RequestMapping(value = "/addAreaInfo", method = RequestMethod.POST)
    @ResponseBody
    public void addAreaInfo(AreaInfoBean areaInfoBean){
        areaInfoService.insertAreaInfo(areaInfoBean);
    }

    @RequestMapping(value = "/updateAreaInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateAreaInfo(AreaInfoBean areaInfoBean){
        areaInfoService.updateAreaInfo(areaInfoBean);
    }

    @RequestMapping(value = "/deleteAreaInfo", method = RequestMethod.POST)
    @ResponseBody
    public void deleteAreaInfo(int areaId){
        areaInfoService.deleteAreaInfo(areaId);
    }


    /**===============================医院信息维护===============================**/

    @RequestMapping(value = "/getHospitalInfo", method = RequestMethod.GET)
         @ResponseBody
         public Map<String,Object> getHospitalInfo(int page, int rows) {
        HospitalInfoBean reqBean = new HospitalInfoBean();
        PageQueryResult<HospitalInfoBean> pageQueryResult = new PageQueryResult<HospitalInfoBean>();
        pageQueryResult.setPageNo(page);
        pageQueryResult.setPageSize(rows);
        pageQueryResult = hospitalInfoService.pageHospitalInfo(reqBean, pageQueryResult);
        List<HospitalInfoBean> hospitalInfoList = pageQueryResult.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",pageQueryResult.getTotalCount());
        map.put("rows", hospitalInfoList);
        return map;
    }

    @RequestMapping(value = "/addHospitalInfo", method = RequestMethod.POST)
    @ResponseBody
    public void addHospitalInfo(HospitalInfoBean hospitalInfoBean){
        hospitalInfoService.insertHospitalInfo(hospitalInfoBean);
    }

    @RequestMapping(value = "/updateHospitalInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateHospitalInfo(HospitalInfoBean hospitalInfoBean){
        hospitalInfoService.updateHospitalInfo(hospitalInfoBean);
    }

    @RequestMapping(value = "/deleteHospitalInfo", method = RequestMethod.POST)
    @ResponseBody
    public void deleteHospitalInfo(int hospitalId){
        hospitalInfoService.deleteHospitalInfo(hospitalId);
    }


    /**===============================科室信息维护===============================**/
    @RequestMapping(value = "/getDeptInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDeptInfo(int page, int rows) {
        DeptInfoBean reqBean = new DeptInfoBean();
        PageQueryResult<DeptInfoBean> pageQueryResult = new PageQueryResult<DeptInfoBean>();
        pageQueryResult.setPageNo(page);
        pageQueryResult.setPageSize(rows);
        pageQueryResult = deptInfoService.pageDeptInfo(reqBean, pageQueryResult);
        List<DeptInfoBean> deptInfoList = pageQueryResult.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",pageQueryResult.getTotalCount());
        map.put("rows", deptInfoList);
        return map;
    }

    @RequestMapping(value = "/addDeptInfo", method = RequestMethod.POST)
    @ResponseBody
    public void addDeptInfo(DeptInfoBean deptInfoBean){
        deptInfoService.insertDeptInfo(deptInfoBean);
    }

    @RequestMapping(value = "/updateDeptInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateDeptInfo(DeptInfoBean deptInfoBean){
        deptInfoService.updateDeptInfo(deptInfoBean);
    }

    @RequestMapping(value = "/deleteDeptInfo", method = RequestMethod.POST)
    @ResponseBody
    public void deleteDeptInfo(int deptId){
        deptInfoService.deleteDeptInfo(deptId);
    }


    /**
     * =====================代理商子账号管理=====================
     */
    //代理商可以查看修改新增自己的子账号
    //userId为代理商用户编号
    @RequestMapping(value = "/getAgentSubAccountInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAgentSubAccountInfo(int page, int rows) {
        AdminDetails adminDetails = SessionControl.getCurAdminDetail(request);
        UserBean curUser = adminDetails.getUserBean();
        if(curUser.getUserType() == null && !"2".equals(curUser.getUserType())){//2为代理商
            throw new ApplicationException("该用户不是代理商");
        }
        UserBean reqBean = new UserBean();
        reqBean.setParentId(curUser.getUserId());
        PageQueryResult<UserBean> pageQueryResult = new PageQueryResult<UserBean>();
        pageQueryResult.setPageNo(page);
        pageQueryResult.setPageSize(rows);
        pageQueryResult = userService.pageUser(reqBean, pageQueryResult);
        List<UserBean> agentSubAccountInfoList = pageQueryResult.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total", pageQueryResult.getTotalCount());
        map.put("rows", agentSubAccountInfoList);
        return map;
    }

    @RequestMapping(value = "/addAgentSubAccountInfo", method = RequestMethod.POST)
    @ResponseBody
    public void addAgentSubAccountInfo(UserBean userBean){
        AdminDetails adminDetails = SessionControl.getCurAdminDetail(request);
        UserBean curUser = adminDetails.getUserBean();
        userBean.setParentId(curUser.getUserId());
        userBean.setUserType("3");//代理商子帐号
        userBean.setCreateUser(curUser.getUserId());//创建者为父帐号

        IEncrypt encrypt = EncryptFactory.getInstance(MD5Encrypt.class.getSimpleName());
        String password = encrypt.encodePassword(userBean.getLoginPassword(), SystemConstantType.PASS_SALT);
        userBean.setLoginPassword(password);

        userService.insertUser(userBean);
    }

    @RequestMapping(value = "/updateAgentSubAccountInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateAgentSubAccountInfo(UserBean userBean){
        userService.updateUser(userBean);
    }

    @RequestMapping(value = "/deleteAgentSubAccountInfo", method = RequestMethod.POST)
    @ResponseBody
    public void deleteAgentSubAccountInfo(int userId){
        userService.deleteUser(userId);
    }


    /**===============================代理商管理===============================**/

    @RequestMapping(value = "/getAgentInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAgentInfo(int page, int rows) {
        AdminDetails adminDetails = SessionControl.getCurAdminDetail(request);
        UserBean curUser = adminDetails.getUserBean();
        //管理员：查询出所有代理商数据
        //代理商：查询出本人的数据
//        if(curUser.getUserType() == null && !"2".equals(curUser.getUserType())){//2为代理商
//            throw new ApplicationException("该用户不是代理商");
//        }
        UserBean reqBean = new UserBean();
        if("1".equals(curUser.getUserType())){
            reqBean.setUserType("2");//查询出所有代理商的数据
        }
        if("2".equals(curUser.getUserType())){
            reqBean.setUserId(curUser.getUserId());//查询本人的数据
        }
        PageQueryResult<UserBean> pageQueryResult = new PageQueryResult<UserBean>();
        pageQueryResult.setPageNo(page);
        pageQueryResult.setPageSize(rows);
        pageQueryResult = userService.pageUser(reqBean, pageQueryResult);
        List<UserBean> agentSubAccountInfoList = pageQueryResult.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",pageQueryResult.getTotalCount());
        map.put("rows", agentSubAccountInfoList);
        return map;
    }

    @RequestMapping(value = "/addAgentInfo", method = RequestMethod.POST)
    @ResponseBody
    public void addAgentInfo(UserBean userBean){
        AdminDetails adminDetails = SessionControl.getCurAdminDetail(request);
        UserBean curUser = adminDetails.getUserBean();
        userBean.setParentId(curUser.getUserId());
        userBean.setUserType("3");//代理商子帐号
        userBean.setCreateUser(curUser.getUserId());//创建者为父帐号
        userService.insertUser(userBean);
    }

    @RequestMapping(value = "/updateAgentInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateAgentInfo(UserBean userBean){
        userService.updateUser(userBean);
    }

    @RequestMapping(value = "/deleteAgentInfo", method = RequestMethod.POST)
    @ResponseBody
    public void deleteAgentInfo(int userId){
        userService.deleteUser(userId);
    }


    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage changePassword(int userId, String oldPassword, String password) {
        userService.changePassword(userId, oldPassword, password);
        return responseAjaxResult("");
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        SessionControl.removeAttribute(request, SystemConstantType.ADMIN_DETAILS);
        return responseResult("admin/adminLogin");
    }
}