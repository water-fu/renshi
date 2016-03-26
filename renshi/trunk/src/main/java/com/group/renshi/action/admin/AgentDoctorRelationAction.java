package com.group.renshi.action.admin;

import com.group.renshi.bean.admin.UserBean;
import com.group.renshi.service.admin.AgentDoctorRelationService;
import com.group.renshi.service.admin.UserService;
import com.group.renshi.service.doctor.AuthenticInfoService;
import com.group.renshi.service.doctor.UserInfoService;
import com.group.renshi.service.share.ShareInfoService;
import com.group.renshi.service.system.AccountInfoService;
import com.group.renshi.service.system.AreaInfoService;
import com.group.renshi.service.system.DeptInfoService;
import com.group.renshi.service.system.HospitalInfoService;
import com.group.webFramework.entity.AdminDetails;
import com.group.webFramework.uitl.PageQueryResult;
import com.group.webFramework.uitl.SessionControl;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group.webFramework.common.BaseController;
import com.group.renshi.bean.admin.AgentDoctorRelationBean;
import com.group.webFramework.uitl.ResponseMessage;

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
 * @version $Id: DoctorRelationAction.java,v 0.1 2015-07-27 下午09:28:49 Exp $
 */
@Controller
@RequestMapping("/agent")
@Scope("prototype")
public class AgentDoctorRelationAction extends BaseController {

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
    @Resource
    private AgentDoctorRelationService agentDoctorRelationService;



    @RequestMapping(value = "/getProxyInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getProxyInfo(int page, int rows) {
        AdminDetails adminDetails = SessionControl.getCurAdminDetail(request);
        UserBean curUser = adminDetails.getUserBean();
        AgentDoctorRelationBean reqBean = new AgentDoctorRelationBean();
        if("1".equals(curUser.getUserType())){
//            reqBean.setUserType("2");//查询出所有代理商的数据
        }
        if("2".equals(curUser.getUserType())){
            reqBean.setAgentUserId(curUser.getUserId());//查询代理商本人的数据
        }
        PageQueryResult<AgentDoctorRelationBean> pageQueryResult = new PageQueryResult<AgentDoctorRelationBean>();
        pageQueryResult.setPageNo(page);
        pageQueryResult.setPageSize(rows);
        pageQueryResult = agentDoctorRelationService.pageDoctorRelation(reqBean, pageQueryResult);
        List<AgentDoctorRelationBean> agentInfoList = pageQueryResult.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",pageQueryResult.getTotalCount());
        map.put("rows", agentInfoList);
        return map;
    }
}