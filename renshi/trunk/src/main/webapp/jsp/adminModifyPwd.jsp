<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>修改管理员密码</title>


<form id="modifyAdminPwdForm">
  当前密码：<input type="password" class="hospital" name="oldPassword" id="oldPwd"/><br><br>
  新密码： <input type="password" class="hospital" name="password" id="pwd"/><br><br>
  确认新密码：<input type="password" class="hospital" id="confirmPwd"/><br><br>
  <input type="button" value="确认修改" id="submitAdminModifyPwd"/>
  <input type="reset" value="重置"/>
</form>
<script type="text/javascript">
    $(function(){

        $('#submitAdminModifyPwd').click(function() {
            var userId = $('#userId').val();

            if($('#oldPwd').val() == '') {
                alert('请填写旧密码');
                return;
            }
            if($('#pwd').val() == '') {
                alert('请填写密码');
                return;
            }
            if($('#confirmPwd').val() == '') {
                alert('请填写确认密码');
                return;
            }
            if($('#pwd').val() != $('#confirmPwd').val()) {
                alert('密码和确认密码不一致');
                return;
            }
            $.ajax({
                type: 'get',
                url: path + '/admin/changePassword',
                data: 'userId='+userId+ '&' +$('#modifyAdminPwdForm').serialize(),
                success: function (result) {
                    if (result.code == '1') {
                        $('#window_AdminModifyPwd').window('close');
                        alert('修改密码成功！');
                        $.ajax({
                            type: 'get',
                            url: path + '/admin/logout',
                            success: function (data) {
                                console.log('clean session success.');
                            }
                        });
                        window.location = path +'/admin';
                    } else {
                        alert('修改密码失败！');
                    }
                }
            });
        });
    });
</script>