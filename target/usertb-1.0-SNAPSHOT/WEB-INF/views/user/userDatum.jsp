<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎登录</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/Login_align.css"/>
    <script>

        $(function(){
            password = $('#password').val();
            phone = $('#phone').val();
            email =$('#email').val();
            d_name = $('#d_name').val();

            if ($('#d_gender').val() == '0'){
                d_gender = '男';
            }else if ($('#d_gender').val() == '1'){
                d_gender = '女';
            }

            d_birthday = $('#d_birthday').val();
            d_photo = $('#d_photo').val();

            $('#b1').click(function(){
                alert("这就是首页！");
                return false;
            })

            $('#b2').click(function(){
                $('#t1').toggle(1000);
                $('#t1').html("<table style='margin-left: 190px' align='center' border='1'>" +
                    "<tr><td>邮箱：</td>" +
                    "<td>"+email+"</td></tr>" +
                    "<tr><td>电话：</td>" +
                    "<td>"+phone+"</td></tr>" +
                    "<tr><td>姓名：</td>" +
                    "<td>"+d_name+"</td></tr>" +
                    "<tr><td>性别：</td>" +
                    "<td>"+d_gender+"</td></tr>" +
                    "<tr><td>生日：</td>" +
                    "<td>"+d_birthday+"</td></tr>" +
                    "<tr>" +
                    "<td colspan='2' align='center'><button type='button' class='btn btn-default' onclick='updateUser()' >修改</button></td>" +
                    "</tr>" +
                    "</table>");
            })

            $('#b3').click(function(){
                window.location.href = $('#contextPath').val() + "/site?uid=" + $('#uid').val();
            })
        })

        function updateUser() {
            url = $('#contextPath').val();
            uid = $('#uid').val();
            window.location.href = url + "/updateUserDatum?uid=" + uid;
        }

        function updatePhoto() {
            url = $('#contextPath').val();
            uid = $('#uid').val();
            window.location.href = url + "/updateUserPhoto?uid=" + uid;
        }

    </script>
</head>
<body>
<input id="uid" type="hidden" value="${user.id}" >
<input id="password" type="hidden" value="${user.password}" />
<input id="phone" type="hidden" value="${user.phone}" />
<input id="email" type="hidden" value="${user.email}" />
<input id="d_name" type="hidden" value="${user.datum.name}" />
<input id="d_birthday" type="hidden" value="${user.datum.birthday}" />
<input id="d_gender" type="hidden" value="${user.datum.gender}" />
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" >
<div class="container" style="margin-top: 200px">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <div id="d1">
                <img src="${pageContext.request.contextPath}/static/img/${user.datum.photo}" style="height: 150px;width: 150px;" alt="头像" class="img-circle" onclick="updatePhoto()" />
            </div>
            <span class="input-group-addon">
            	<i>欢迎${user.menbername}!!！</i>
            </span>
            <br />
            <div role="form">
                <button id="b1" type="submit" class="btn btn-success btn-block">首页</button>
                <button id="b2" type="submit" class="btn btn-success btn-block">个人资料</button>
                <button id="b3" type="submit" class="btn btn-success btn-block">管理收货地址</button>
            </div>
            <br />
            <span id="t1"></span>
        </div>
    </div>
</div>
</body>
</html>
