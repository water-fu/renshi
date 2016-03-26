<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>后台管理员修改医生密码</title>


<form id="modifyPwdForm">
  <input type="hidden" name="accountId" id="accountId" />

  当前密码：<input type="password" class="hospital" name="oldPassword" id="oldPassword"/><br><br>

  新密码： <input type="password" class="hospital" name="password" id="password"/><br><br>

  确认新密码：<input type="password" class="hospital" id="confirmPassword"/><br><br>

  <input type="button" value="确认修改" id="submitModifyPwd"/>
  <input type="reset" value="重置"/>
</form>


<script type="text/javascript">
    $(function(){

        $('#submitModifyPwd').click(function() {
            var selectRow = $("#修改医生密码").datagrid('getSelected');
            $('#accountId').val(selectRow.accountId);

            if($('#oldPassword').val() == '') {
                alert('请填写旧密码');
                return;
            }
            if($('#password').val() == '') {
                alert('请填写密码');
                return;
            }
            if($('#confirmPassword').val() == '') {
                alert('请填写确认密码');
                return;
            }
            if($('#password').val() != $('#confirmPassword').val()) {
                alert('密码和确认密码不一致');
                return;
            }
            $.ajax({
                type: 'post',
                url: path + '/doctor/changePasswordForAdmin',
                data: $('#modifyPwdForm').serialize(),
                success: function (result) {
                    if (result.code == '1') {
                        $('#window_modifyPwd').window('close');
                        alert('修改密码成功！');
                    } else {
                        alert('修改密码失败！');
                    }
                }
            });
        });
    });
</script>