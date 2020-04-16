<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员登录</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/Login_align.css"/>

</head>
<script>
    $(function () {
        $('#b1').click(function () {
            userid = $.trim($('#userid').val());
            password = $.trim($('#password').val());
            if (userid == "" || password == ""){
                alert("账户或密码不能为空！！！");
                return false;
            }
            pageContext = $('#pageContext').val();
            $.ajax({
                type : "post",
                url : pageContext + "/aLogin",
                dataType : "json",
                contentType : "application/json",
                data : JSON.stringify({
                    email : userid,
                    phone : userid,
                    passWord : password
                }),
                success : function (data) {
                    if (data.error == -1){
                        alert("账户或密码错误！！！");
                        return false;
                    }else{
                        window.location.href = pageContext + "/userList";
                    }
                },
                error : function () {
                    alert("连接失败");
                }
            })
        })
    })
</script>
<body>
<input id="pageContext" type="hidden" value="${pageContext.request.contextPath}">

<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h2>欢迎登录</h2>
            <div role="form">
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" id="userid" name="userid" placeholder="请输入账户电话或邮箱"/>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                </div>
                <br/>
                <button id="b1" type="submit" class="btn btn-success btn-block">登录</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>