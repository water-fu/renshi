var userData = initData();
var treeAdminData = [
    /*{
        text: "代理商管理",
        //state:'closed',
        children: [{
            text: '代理商审核',
            attributes: {}
        }, {
            text: '医代关系审核',
            attributes: {}
        }]
    }, */{
        text: "医生管理",
        //state:'closed',
        children: [{
            text: "医生账户管理",
            attributes: {}
        }, {
            text: "医生作品管理",
            attributes: {}
        }, {
            text: "修改医生密码",
            attributes: {}
        }]
    }, {
        text: "系统设置",
        //state:'closed',
        children: [{
            text: '地域信息维护',
            attributes: {}
        }, {
            text: '医院信息维护',
            attributes: {}
        }, {
            text: '科室信息维护',
            attributes: {}
        }]
    }];

var treeAgentData = [{
        text: "代理商管理",
        //state:'closed',
        children: [{
            text: '医代签约管理',
            attributes: {}
        }]
    }, {
        text: "医生管理",
        //state:'closed',
        children: [{
            text: "医生账户管理",
            attributes: {}
        }, {
            text: "医生作品管理",
            attributes: {}
        }]
    },{
    text: '子账号管理',
    //state:'closed',
    children: [{
        text: '子账号管理',
        attributes: {}
    }]
}];

var treeData = [];
if(userData.userType == '1'){
    treeData = treeAdminData;
}else if(userData.userType == '2'){
    treeData = treeAgentData;
}

$('#tt').tree({
    data: treeData,
    lines : true,
    onContextMenu: function (e, title) {
        e.preventDefault();
        $("#tabsMenu").menu('show', {
            left: e.pageX,
            top: e.pageY
        }).data("tabTitle", title.text);
    },
    onClick : function (node) {
        if (node.attributes) {
            OpenTab(node.text, node.attributes.url);
        }
    }
});

//绑定tabs的右键菜单
$("#tabs").tabs({
    onContextMenu : function (e, title) {
        e.preventDefault();
        $('#tabsMenu').menu('show', {
            left : e.pageX,
            top : e.pageY
        }).data("tabTitle", title);
    }
});

//实例化menu的onClick事件
$("#tabsMenu").menu({
    onClick : function (item) {
        CloseTab(this, item.name);
    }
});

//在右边center区域打开菜单，新增tab
function OpenTab(text, url) {
    if ($("#tabs").tabs('exists', text)) {
        $('#tabs').tabs('select', text);
        $('#'+text).datagrid('reload');
    } else {
        $('#tabs').tabs('add', {
            title : text,
            closable : true,
            content : text
        });
        var currentTabPanel = $("#tabs").tabs('getSelected');
        var textId = text;
        var dynamicTable = $('<table id="'+textId+'"></table>');
        //这里一定要先添加到currentTabPanel中
        currentTabPanel.html(dynamicTable);

        if(userData.userType == '1'){
            createAdminDatagrid(dynamicTable, textId);
        }else if(userData.userType == '2'){
            createAgentDatagrid(dynamicTable, textId);
        }
    }
}