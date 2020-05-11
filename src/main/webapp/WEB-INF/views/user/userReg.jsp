<%@ page import="com.usertb.utility.randomString" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/Login_align.css"/>
    <script src="static/js/UReg.js"></script>
</head>

<body>
<input id="pageContext" type="hidden" value="${pageContext.request.contextPath}">
<input id="menbername" type="hidden" name="menbername" value="${randomString.randonMember()}" />
<input id="atime" type="hidden" value="time"/>
<input id="utime" type="hidden" value="time"/>

<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h2>注册</h2>
            <div role="form">
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" id="userEmail" name="userEmail" placeholder="邮箱"/>
                </div>
                <span><div><font id="f1" color=""></font></div></span>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码"/>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" id="password1" name="password1" placeholder="确认密码"/>
                </div>
                <span><div><font id="f2" color=""></font></div></span>
                <br/>
                <button id="b1" type="submit" class="btn btn-success btn-block">注册</button>
                <font color="">已有账号，去<a href="${pageContext.request.contextPath}/userLogin" style="text-decoration: blink;" >登陆</a>？</font>
            </div>
        </div>
    </div>
</div>

</body>
</html>