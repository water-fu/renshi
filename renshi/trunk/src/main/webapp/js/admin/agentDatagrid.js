
function createAgentDatagrid(dynamicTable, dgTitleId){
    if(dgTitleId == '医代签约管理'){
        dynamicTable.datagrid({
            url: path+ '/agent/getProxyInfo',
            method: 'get',
            pagination: true,
            singleSelect: true,
            toolbar: [{
                iconCls: 'icon-search',
                text: '申请代理',
                handler: function () {
                    var len = $('#applyAgentDocDialog').length;
                    if(len <= 0){
                        $('body').append('<div id="applyAgentDocDialog"></div>');
                        $('#applyAgentDocDialog').dialog({
                            title: '添加新客户',
                            width: 600,
                            height: 300,
                            closed: false,
                            cache: false,
                            href: path+ '/jsp/applyAgentDoc.jsp',
                            modal: true
                        });
                        $('#applyAgentDocDialog').dialog('open');
                    }else{
                        $('#applyAgentDocDialog').dialog('open');
                    }
                }
            },'-',{
                iconCls: 'icon-add',
                text: '新增客户',
                handler: function () {
                    var len = $('#agentNewCustomerDialog').length;
                    if(len <= 0){
                        $('body').append('<div id="agentNewCustomerDialog"></div>');
                        $('#agentNewCustomerDialog').dialog({
                            title: '添加新客户',
                            width: 600,
                            height: 300,
                            closed: false,
                            cache: false,
                            href: path+ '/jsp/agentNewCustomer.jsp',
                            modal: true
                        });
                        $('#agentNewCustomerDialog').dialog('open');
                    }else{
                        $('#agentNewCustomerDialog').dialog('open');
                    }
                }
            }],
            columns: [[
                {field:'id', title:'id', width:60, hidden:true},
                {field:'agentUserId', title:'代理商用户编号', width:150},
                {field:'doctorUserId', title:'医生用户编号', width:150},
                //{field:'proxyStatus', title:'proxyStatus', width:150},
                {field:'proxyStatus', title:'代理状态', width:150,
                    formatter:function(value, row, index){
                        if (value == '1'){
                            return '待审批';
                        }if (value == '2'){
                            return '审批失败';
                        }if (value == '3'){
                            return '代理中';
                        }if (value == '4'){
                            return '解约中';
                        }if (value == '5'){
                            return '已解约';
                        }
                    }
                },
                {field:'action', title:'操作', width:100, align:'center',
                    formatter:function(value, row, index){
                        if (row.proxyStatus == '3'){//代理中的医代关系，代理商才能申请解约
                            return ' <a href="#" onclick="agentDocCancel()">解约</a>';
                        }else {
                            return '无';
                        }
                    }
                }
            ]]
        });

    }
    if(dgTitleId == '医生账户管理'){
        dynamicTable.datagrid({
            url: path+ '/admin/getApproveInfo',
            method: 'get',
            pagination: true,
            checkOnSelect: false,
            toolbar: [{
                iconCls: 'icon-ok',
                text: '审核通过',
                handler: function () {
                    accountApprove(dgTitleId)
                }
            }],
            columns:[[
                {field:'ck', checkbox: true},
                {field:'accountId',title:'账户编号', hidden: true},
                {field:'loginAccount',title:'登录帐号',width:150},
                {field:'registerType',title:'注册类型',width:70, formatter:function(value) {
                    if(value == '1'){return '手机';}if(value == '2'){return '邮箱';}if(value == '3'){return '其他';}}},
                {field:'accountType',title:'帐号类型',width:70, formatter:function(value) {
                    if(value == '1'){return '医生';}if(value == '2'){return '代理商';}}},
                {field:'accountStatus',title:'帐号状态',width:100, formatter:function(value) {return '待管理员认证'}},
                {field:'activeType',title:'激活状态',width:70, formatter:function(value) {
                    if(value=='0'){return '未激活'}if(value=='1'){return '已激活'}}},
                {field:'activeTime',title:'激活时间',width:100, formatter:function(value){return dateFormater(value)}},
                {field:'createDate',title:'创建日期',width:100, formatter:function(value){return dateFormater(value)}},
                {field:'viewDetail',title:'查看详情',width:100, formatter:function(value, row){
                    return '<a href="javascript:void(0);" onclick="viewDocAccount('+row.accountId+');">查看详情</a>';
                }}
            ]]
        });
    }
    if(dgTitleId == '医生作品管理'){
        dynamicTable.datagrid({
            url: path+ '/admin/getDocProduction',
            method: 'get',
            pagination: true,
            checkOnSelect: false,
            toolbar: [{
                iconCls: 'icon-ok',
                text: '审核通过',
                handler: function () {
                    productionApprove(dgTitleId)
                }
            }],
            columns:[[
                {field:'ck', checkbox: true, width: 100},
                {field:'shareId', title: 'shareId', hidden: 'true', width: 100},
                {field:'accountId',title:'账户编号', hidden: 'true',width:100},
                {field:'shareType',title:'分享类型',width:60},
                {field:'shareTitle',title:'分享标题',width:150},
                {field:'shareTag',title:'分享标签',width:150},
                {field:'shareDesc',title:'分享描述',width:200},
                {field:'belongProfess',title:'所属专业',width:100},
                {field:'shareStatus',title:'审批状态',width:70},
                {field:'likeNum',title:'点赞数量',width:60},
                {field:'collectionNum',title:'收藏数量',width:60},
                {field:'readNum',title:'查看次数',width:60},
                {field:'commentNum',title:'评论次数',width:60},
                {field:'shareLevel',title:'等级',width:60},
                {field:'createDate',title:'创建日期',width:100, formatter:function(value){return dateFormater(value)}}
            ]]
        });
    }
    if(dgTitleId == '子账号管理'){
        dynamicTable.datagrid({
            url: path+ '/admin/getAgentSubAccountInfo',
            method: 'get',
            pagination: true,
            singleSelect: true,
            toolbar: [{
                iconCls: 'icon-add',
                text: '添加代理商子账号',
                handler: function () {
                    var len = $('#agentSubAccountDialog').length;
                    if(len <= 0){
                        $('body').append('<div id="agentSubAccountDialog"></div>');
                        $('#agentSubAccountDialog').dialog({
                            title: '添加子账号',
                            width: 600,
                            height: 300,
                            closed: false,
                            cache: false,
                            href: path+ '/jsp/agentSubAccount.jsp',
                            modal: true
                        });
                        $('#agentSubAccountDialog').dialog('open');
                    }else{
                        $('#agentSubAccountDialog').dialog('open');
                    }
                }
            }],
            columns:[[
                {field:'userId', title:'userId', width:60, hidden:true},
                {field:'loginAccount', title:'登录用户名', width:150, editor: {type: 'text', options: {required: true}}},
                {field:'email', title:'邮箱', width:150, editor: {type: 'text', options: {required: true}}},
                {field:'phone', title:'手机号码', width:150, editor: {type: 'numberbox', options: {required: true}}},
                {field:'action', title:'操作', width:100, align:'center',
                    formatter:function(value, row, index){
                        if (row.editing){
                            var s = '<a href="#" onclick="saveAgentSubAccountRow(this)">保存</a> ';
                            var c = ' <a href="#" onclick="cancelrow(this,\''+dgTitleId+'\')">取消</a>';
                            return s+c;
                        } else {
                            var e = '<a href="#" onclick="editrow(this,\''+dgTitleId+'\')">编辑</a> ';
                            var d = ' <a href="#" onclick="deleteAgentSubAccountRow(this)">删除</a>';
                            return e+d;
                        }
                    }
                }
            ]],
            onBeforeEdit:function(index,row){
                row.editing = true;
                updateActions(index,dgTitleId);
            },
            onAfterEdit:function(index,row){
                row.editing = false;
                updateActions(index,dgTitleId);
            },
            onCancelEdit:function(index,row){
                row.editing = false;
                updateActions(index,dgTitleId);
            }
        });
    }
}


function agentDocCancel(){
    $.messager.confirmNew('','确定要和该代理商解约吗？','确认','取消',function(r){
        var selectRow = $("#代理商管理").datagrid('getSelected');
        if (r){
            $.post(path + "/admin/updateAgentInfo", {userId:selectRow.userId, status:4}, function (result) {
                $('#代理商管理').datagrid('reload');
            });
        }
    });
}