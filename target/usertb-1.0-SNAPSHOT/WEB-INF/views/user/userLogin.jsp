<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/Login_align.css"/>
    <script src="static/js/judge.js"></script>

</head>

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
                <a href="${pageContext.request.contextPath}/userReg" style="color: white;text-decoration: blink;"><button type="button" class="btn btn-success btn-block">注册</button></a>
            </div>
        </div>
    </div>
</div>

</body>
</html>