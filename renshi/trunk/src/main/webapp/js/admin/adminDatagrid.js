
function createAdminDatagrid(dynamicTable, dgTitleId){
    if(dgTitleId == '代理商审核'){
        dynamicTable.datagrid({
            url: path+ '/admin/getAgentInfo',
            method: 'get',
            pagination: true,
            singleSelect: true,
            columns: [[
                {field:'userId', title:'userId', width:60, hidden:true},
                {field:'loginAccount', title:'登录用户名', width:150},
                {field:'email', title:'邮箱', width:150},
                {field:'phone', title:'手机号码', width:150},
                {field:'status', title:'状态', width:150,
                    formatter:function(value, row, index){
                        if (row.status == '1'){
                            return '待认证';
                        }if (row.status == '2'){
                            return '已认证';
                        }if (row.status == '3'){
                            return '认证失败';
                        }if (row.status == '4'){
                            return '已解约';
                        }
                    }
                },
                {field:'action', title:'操作', width:100, align:'center',
                    formatter:function(value, row, index){
                        if (row.status == '1'){
                            return '<a href="#" onclick="agentApprove()">认证通过</a> ';
                        }else if (row.status == '2'){
                            return ' <a href="#" onclick="agentDocCancel()">解约</a>';
                        }else {
                            return '无';
                        }
                    }
                }
            ]]
        });

    }
    if(dgTitleId == '医代关系审核'){
        dynamicTable.datagrid({
            url: path+ '/admin/getAgentInfo',
            method: 'get',
            pagination: true,
            singleSelect: true,
            columns: [[
                {field:'userId', title:'userId', width:60, hidden:true},
                {field:'loginAccount', title:'登录用户名', width:150},
                {field:'email', title:'邮箱', width:150},
                {field:'phone', title:'手机号码', width:150},
                {field:'status', title:'状态', width:150,
                    formatter:function(value, row, index){
                        if (row.status == '1'){
                            return '待认证';
                        }if (row.status == '2'){
                            return '已认证';
                        }if (row.status == '3'){
                            return '认证失败';
                        }if (row.status == '4'){
                            return '已解约';
                        }
                    }
                },
                {field:'action', title:'操作', width:100, align:'center',
                    formatter:function(value, row, index){
                        if (row.status == '1'){
                            return '<a href="#" onclick="agentApprove()">认证通过</a> ';
                        }else if (row.status == '2'){
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
                    return '<a href="#" onclick="viewDocAccount('+row.accountId+')">查看详情</a>';
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
                {field:'shareType',title:'分享类型',width:60, formatter:function(value){
                    if(value == '1'){
                        return '视频';
                    }if(value == '2'){
                        return '观点';
                    }if(value == '3'){
                        return '病例';
                    }if(value == '4'){
                        return '文档';
                    }if(value == '5'){
                        return '提问';
                    }else{
                        return '未知';
                    }
                }},
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
                {field:'createDate',title:'创建日期',width:100, formatter:function(value){return dateFormater(value)}},
                {field:'viewDetail',title:'查看详情',width:100, formatter:function(value, row){
                    return '<a href="#" onclick="viewDroducDetail('+row.shareId+')">查看详情</a>';
                }}
            ]]
        });
    }
    if(dgTitleId == '修改医生密码'){
        $('#'+dgTitleId).append('<div id="findDocToolbar" style="padding:3px"><span>医生姓名: </span><input id="realName" value=""/>' +
            /*'<a href="#" class="easyui-linkbutton" plain="true" onclick="doDocSearch()"></a>'+*/ '</div>');
        dynamicTable.datagrid({
            url: path+ '/doctor/serarchApprovedDoc',
            method: 'get',
            pagination: true,
            singleSelect: true,
            toolbar: $('#findDocToolbar'),
            columns: [[
                {field:'accountId', title:'accountId', width:60, hidden:true},
                {field:'realName', title:'姓名', width:100},
                {field:'accountSex', title:'性别', width:50,formatter:function(value, row, index){
                    if (value == '1'){
                        return '男';
                    }else if (value == '2'){
                        return '女';
                    }else {
                        return '未知';
                    }
                }},
                {field:'birthDate', title:'出生日期', width:100},
                {field:'homeTown', title:'故乡', width:150},
                {field:'liveTown', title:'现居地', width:150},
                {field:'belongHospital', title:'所属医院', width:150},
                {field:'belongDept', title:'所属科室', width:100},
                {field:'action', title:'操作', width:100, align:'center',
                    formatter:function(value, row, index){
                        return ' <a href="#" onclick="modifyPassword('+row.accountId+','+index+')">修改密码</a>';
                    }
                }
            ]]
        });
        $('#realName').searchbox({
            width : 150,
            searcher : doDocSearch,
            prompt : '请输入医生姓名'
        });

    }
    if(dgTitleId == '地域信息维护'){
        dynamicTable.datagrid({
            url: path+ '/admin/getAreaInfo',
            method: 'get',
            pagination: true,
            singleSelect: true,
            toolbar: [{
                iconCls: 'icon-add',
                text: '添加地域信息',
                handler: function () {
                    dynamicTable.datagrid('appendRow', {});
                    var rows = dynamicTable.datagrid('getRows');
                    dynamicTable.datagrid('beginEdit', rows.length - 1);
                }
            }],
            columns:[[
                {field:'areaId', title:'areaId', width:60, hidden:true},
                {field:'parentId', title:'归属地市', width:150, editor: {type: 'numberbox', options: {required: true}}},
                {field:'firstChar', title:'地市首字母', width:150, editor: {type: 'text', options: {required: true}}},
                {field:'areaName', title:'医院名称', width:200, editor: {type: 'text', options: {required: true}}},
                {field:'action', title:'操作', width:100, align:'center',
                    formatter:function(value, row, index){
                        if (row.editing){
                            var s = '<a href="#" onclick="saveAreaRow(this)">保存</a> ';
                            var c = ' <a href="#" onclick="cancelrow(this,\''+dgTitleId+'\')">取消</a>';
                            return s+c;
                        } else {
                            var e = '<a href="#" onclick="editrow(this,\''+dgTitleId+'\')">编辑</a> ';
                            var d = ' <a href="#" onclick="deleteAreaRow(this)">删除</a>';
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
    if(dgTitleId == '医院信息维护'){
        dynamicTable.datagrid({
            url: path+ '/admin/getHospitalInfo',
            method: 'get',
            pagination: true,
            singleSelect: true,
            toolbar: [{
                iconCls: 'icon-add',
                text: '添加医院信息',
                handler: function () {
                    dynamicTable.datagrid('appendRow', {});
                    var rows = dynamicTable.datagrid('getRows');
                    dynamicTable.datagrid('beginEdit', rows.length - 1);
                }
            }],
            columns:[[
                {field:'hospitalId', title:'hospitalId', width:60, hidden:true},
                {field:'areaId', title:'归属地市', width:150, editor: {type: 'numberbox', options: {required: true}}},
                {field:'hospitalName', title:'医院名称', width:150, editor: {type: 'text', options: {required: true}}},
                {field:'action', title:'操作', width:100, align:'center',
                    formatter:function(value, row, index){
                        if (row.editing){
                            var s = '<a href="#" onclick="saveHospitalRow(this)">保存</a> ';
                            var c = ' <a href="#" onclick="cancelrow(this,\''+dgTitleId+'\')">取消</a>';
                            return s+c;
                        } else {
                            var e = '<a href="#" onclick="editrow(this,\''+dgTitleId+'\')">编辑</a> ';
                            var d = ' <a href="#" onclick="deleteHospitalRow(this)">删除</a>';
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
    if(dgTitleId == '科室信息维护'){
        dynamicTable.datagrid({
            url: path+ '/admin/getDeptInfo',
            method: 'get',
            pagination: true,
            singleSelect: true,
            toolbar: [{
                iconCls: 'icon-add',
                text: '添加科室信息',
                handler: function () {
                    dynamicTable.datagrid('appendRow', {});
                    var rows = dynamicTable.datagrid('getRows');
                    dynamicTable.datagrid('beginEdit', rows.length - 1);
                }
            }],
            columns:[[
                {field:'deptId', title:'deptId', width:60, hidden:true},
                {field:'hospitalId', title:'归属医院', width:150, editor: {type: 'numberbox', options: {required: true}}},
                {field:'deptName', title:'科室名称', width:150, editor: {type: 'text', options: {required: true}}},
                {field:'deptType', title:'科室类型', width:150, editor: {type: 'text', options: {required: true}}},
                {field:'action', title:'操作', width:100, align:'center',
                    formatter:function(value, row, index){
                        if (row.editing){
                            var s = '<a href="#" onclick="saveDeptRow(this)">保存</a> ';
                            var c = ' <a href="#" onclick="cancelrow(this,\''+dgTitleId+'\')">取消</a>';
                            return s+c;
                        } else {
                            var e = '<a href="#" onclick="editrow(this,\''+dgTitleId+'\')">编辑</a> ';
                            var d = ' <a href="#" onclick="deleteDeptRow(this)">删除</a>';
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

function doDocSearch() {
    //var realName = $('#realName').val().replace(/\s+/g,"");
    var realName = $('#realName').val();
    $('#修改医生密码').datagrid('load', {realName: $('#realName').val()});
}

/**====================医生帐号审核====================*/
function accountApprove(dgTitleId) {
    var checkedItems = $('#'+dgTitleId).datagrid('getChecked');
    var accountIds = [];
    $.each(checkedItems, function (index, item) {
        accountIds.push(item.accountId);
    });
    $.ajax({
        async: false,
        type: 'post',
        url: path + '/admin/accountApprove',
        data: {accountIds: accountIds},
        success: function (result) {
            if (result == 'true') {
                alert('医生帐号审核成功！');
            } else {
                alert('医生帐号审核失败！');
            }
        }
    });
    //重新加载datagrid的数据
    $('#'+dgTitleId).datagrid('reload');
}

/**====================医生作品审核====================*/
function productionApprove(dgTitleId) {
    var checkedItems = $('#'+dgTitleId).datagrid('getChecked');
    var shareIds = [];
    $.each(checkedItems, function (index, item) {
        shareIds.push(item.shareId);
    });
    $.ajax({
        async: false,
        type: 'post',
        url: path + '/admin/productionApprove',
        data: {shareIds: shareIds},
        success: function (result) {
            if (result == 'true') {
                alert('医生作品审核成功！');
            } else {
                alert('医生作品审核失败！');
            }
        }
    });
    //重新加载datagrid的数据
    $('#'+dgTitleId).datagrid('reload');
}

/**====================医生帐号详情====================*/
function viewDocAccount(accountId){
    var winId = 'window_'+accountId;
    var len = $('#'+winId).length;
    if(len <= 0){//添加window div元素
        $('body').append('<div id=' + winId + '></div>');
        $('#window_'+accountId).window({
            draggable: false,
            modal: true,
            minimizable: false,
            closed: true,
            width: 800,
            height: 600,
            title: '医生帐号详情',
            //content: content
            href: path+'/admin/getAccountDetailInfo?accountId='+accountId
        });
        $('#window_'+accountId).window('open');
    }else{
        $('#window_'+accountId).window('open');
    }
}

function viewDroducDetail(shareId){
    var winId = 'window_produc_'+shareId;
    var len = $('#'+winId).length;
    if(len <= 0){//添加window div元素
        $('body').append('<div id=' + winId + '></div>');
        $('#window_produc_'+shareId).window({
            draggable: false,
            modal: true,
            minimizable: false,
            closed: true,
            width: 800,
            height: 600,
            title: '医生作品详情',
            href: path + '/blog/content?shareId=' + shareId
        });
        $('#window_produc_'+shareId).window('open');
    }else{
        $('#window_produc_'+shareId).window('open');
    }
}

function modifyPassword(accountId, index){
    $("#修改医生密码").datagrid('selectRow', index);
    $('#modifyPwdForm').resetForm();

    var len = $('#window_modifyPwd').length;
    if(len <= 0){//添加window div元素
        $('body').append('<div id="window_modifyPwd"></div>');
        $('#window_modifyPwd').window({
            draggable: false,
            modal: true,
            minimizable: false,
            closed: true,
            width: 400,
            height: 250,
            title: '修改医生密码',
            href: path+ '/jsp/modifyPwd.jsp'
        });
        $('#window_modifyPwd').window('open');
    }else{
        $('#window_modifyPwd').window('open');
    }
}

function updateActions(index,dgTitle){
    $('#'+dgTitle).datagrid('updateRow',{
        index: index,
        row:{}
    });
}
function getRowIndex(target){
    var tr = $(target).closest('tr.datagrid-row');
    var index = parseInt(tr.attr('datagrid-row-index'));
    return index;
}
function cancelrow(target, dgTitle){
    $('#'+dgTitle).datagrid('cancelEdit', getRowIndex(target));//取消对一行进行编辑
}
function editrow(target, dgTitle){
    $('#'+dgTitle).datagrid('beginEdit', getRowIndex(target));//开始对一行进行编辑
}
function deleteAreaRow(target){
    $.messager.confirm('','确定要删除吗？',function(r){
        if (r){
            var deleteRow = $("#地域信息维护").datagrid('getChanges','deleted');//获取delete的行数据
            $('#地域信息维护').datagrid('deleteRow', getRowIndex(target));//删除一行
            $.post(path + "/admin/deleteAreaInfo", {areaId:deleteRow[0].areaId}, function (result) {
                $('#地域信息维护').datagrid('reload');
                //alert("数据添加成功！");
            });
        }
    });
}
function saveAreaRow(target){
    $('#地域信息维护').datagrid('endEdit', getRowIndex(target));//结束对一行进行编辑
    var updateRow = $("#地域信息维护").datagrid('getChanges','updated');//获取update的行数据
    var addRow = $("#地域信息维护").datagrid('getChanges','inserted');//获取inserted的行数据

    if(updateRow.length > 0){//update操作
        var dataObj = updateRow[0];
        $.post(path + "/admin/updateAreaInfo", {
            areaId: dataObj.areaId,
            parentId: dataObj.parentId,
            firstChar: dataObj.firstChar,
            areaName: dataObj.areaName
        }, function (result) {
            $('#地域信息维护').datagrid('reload');
            //alert("数据修改成功！");
        });
    }
    if(addRow.length > 0){//add操作
        $.post(path + "/admin/addAreaInfo", addRow[0], function (result) {
            $('#地域信息维护').datagrid('reload');
            //alert("数据添加成功！");
        });
    }
}


function deleteHospitalRow(target){
    $.messager.confirm('','确定要删除吗？',function(r){
        if (r){
            var deleteRow = $("#医院信息维护").datagrid('getChanges','deleted');//获取delete的行数据
            $('#医院信息维护').datagrid('deleteRow', getRowIndex(target));//删除一行
            $.post(path + "/admin/deleteHospitalInfo", {hospitalId:deleteRow[0].hospitalId}, function (result) {
                $('#医院信息维护').datagrid('reload');
            });
        }
    });
}
function saveHospitalRow(target){
    $('#医院信息维护').datagrid('endEdit', getRowIndex(target));//结束对一行进行编辑
    var updateRow = $("#医院信息维护").datagrid('getChanges','updated');//获取update的行数据
    var addRow = $("#医院信息维护").datagrid('getChanges','inserted');//获取inserted的行数据

    if(updateRow.length > 0){//update操作
        var dataObj = updateRow[0];
        $.post(path + "/admin/updateHospitalInfo", {
            hospitalId: dataObj.hospitalId,
            areaId: dataObj.areaId,
            hospitalName: dataObj.hospitalName
        }, function (result) {
            $('#医院信息维护').datagrid('reload');
        });
    }
    if(addRow.length > 0){//add操作
        $.post(path + "/admin/addHospitalInfo", addRow[0], function (result) {
            $('#医院信息维护').datagrid('reload');
        });
    }
}


function saveDeptRow(target){
    $('#科室信息维护').datagrid('endEdit', getRowIndex(target));//结束对一行进行编辑
    var updateRow = $("#科室信息维护").datagrid('getChanges','updated');//获取update的行数据
    var addRow = $("#科室信息维护").datagrid('getChanges','inserted');//获取inserted的行数据

    if(updateRow.length > 0){//update操作
        var dataObj = updateRow[0];
        $.post(path + "/admin/updateDeptInfo", {
            deptId: dataObj.deptId,
            hospitalId: dataObj.hospitalId,
            deptName: dataObj.deptName,
            deptType: dataObj.deptType
        }, function (result) {
            $('#科室信息维护').datagrid('reload');
        });
    }
    if(addRow.length > 0){//add操作
        $.post(path + "/admin/addDeptInfo", addRow[0], function (result) {
            $('#科室信息维护').datagrid('reload');
        });
    }
}
function deleteDeptRow(target){
    $.messager.confirm('','确定要删除吗？',function(r){
        if (r){
            var deleteRow = $("#科室信息维护").datagrid('getChanges','deleted');//获取delete的行数据
            $('#科室信息维护').datagrid('deleteRow', getRowIndex(target));//删除一行
            $.post(path + "/admin/deleteDeptInfo", {deptId:deleteRow[0].deptId}, function (result) {
                $('#科室信息维护').datagrid('reload');
            });
        }
    });
}

function saveAgentSubAccountRow(target){
    $('#子账号管理').datagrid('endEdit', getRowIndex(target));//结束对一行进行编辑
    var updateRow = $("#子账号管理").datagrid('getChanges','updated');//获取update的行数据
    var addRow = $("#子账号管理").datagrid('getChanges','inserted');//获取inserted的行数据

    if(updateRow.length > 0){//update操作
        var dataObj = updateRow[0];
        $.post(path + "/admin/updateAgentSubAccountInfo", {
            userId: dataObj.userId,
            email: dataObj.email,
            phone: dataObj.phone,
            loginAccount: dataObj.loginAccount
        }, function (result) {
            $('#子账号管理').datagrid('reload');
        });
    }
    if(addRow.length > 0){//add操作
        $.post(path + "/admin/addAgentSubAccountInfo", addRow[0], function (result) {
            $('#子账号管理').datagrid('reload');
        });
    }
}
function deleteAgentSubAccountRow(target){
    $.messager.confirm('','确定要删除吗？',function(r){
        if (r){
            var deleteRow = $("#子账号管理").datagrid('getChanges','deleted');//获取delete的行数据
            $('#子账号管理').datagrid('deleteRow', getRowIndex(target));//删除一行
            $.post(path + "/admin/deleteAgentSubAccountInfo", {userId:deleteRow[0].userId}, function (result) {
                $('#子账号管理').datagrid('reload');
            });
        }
    });
}

function agentApprove(){
    $.messager.confirmNew('','该代理商确定要认证通过吗？','认证通过','认证不通过',function(r){
        var selectRow = $("#代理商管理").datagrid('getSelected');
        if (r){
            $.post(path + "/admin/updateAgentInfo", {userId:selectRow.userId, status:2}, function (result) {
                $('#代理商管理').datagrid('reload');
            });
        }else{
            $.post(path + "/admin/updateAgentInfo", {userId:selectRow.userId, status:3}, function (result) {
                $('#代理商管理').datagrid('reload');
            });
        }
    });
}



