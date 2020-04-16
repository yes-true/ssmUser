<%--
  Created by IntelliJ IDEA.
  User: LongGuoShuai
  Date: 2020/3/31
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
    <script>
        /**
         * 判断邮箱是否可用
         */
        $(function () {
            url = $("#pageContext").val();
            $("#email").on('input propertychange',function(){
                reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                userEmail = $.trim($("#email").val());
                uid = $("#uid").val();
                isok = reg.test(userEmail);
                if (isok && userEmail.split("@")[0].length <= 64 && userEmail.length <= 255){
                    $("#f1").html("该邮箱可用");
                    $("#f1").attr("color","green");
                    $("#b1").attr("disabled",false);
                }else if(userEmail.split("@")[0].length > 64 || userEmail.length > 255){
                    $("#f1").html("邮箱过长");
                    $("#f1").attr("color","red");
                    $("#b1").attr("disabled",true);
                }else {
                    $("#f1").html("邮箱不可用");
                    $("#f1").attr("color","red");
                    $("#b1").attr("disabled",true);//true按钮不可用 false按钮可用
                }
                $.ajax({
                    type : "post",
                    url : url + "/userUpdateJudge",
                    dataType : "json",
                    contentType : "application/json",
                    data : JSON.stringify({
                        email : userEmail,
                        id : uid
                    }),
                    success : function (data) {

                        if (data.error == -1){
                            $("#f1").html("该邮箱不可用")
                            $("#f1").attr("color","red")
                            $("#b1").attr("disabled",true)
                        }else if (data.ok == 1){
                            $("#f1").html("该邮箱可用");
                            $("#f1").attr("color","green");
                            $("#b1").attr("disabled",false);
                        }
                    }
                })
            });

        })

        /**
         * 判断电话号码是否可用
         */
        $(function () {
            url = $('#pageContext').val();
            uid = $("#uid").val();
            reg = /^1[34578]\d{9}$/;
            $("#phone").on('input propertychange',function(){
                phone = $.trim($('#phone').val()) ;

                isok = reg.test(phone);
                if (isok){
                    $("#f2").html("该号码可用");
                    $("#f2").attr("color","green");
                    $("#b1").attr("disabled",false);
                }else{
                    $("#f2").html("该号码不可用");
                    $("#f2").attr("color","red");
                    $("#b1").attr("disabled",true);
                }

                $.ajax({
                    type: "post",
                    url : url + "/userUpdateJudge",
                    dataType : "json",
                    contentType : "application/json",
                    data: JSON.stringify({
                        id : uid,
                        phone : phone
                    }),
                    success : function (data) {
                        if (data.error == -1){
                            $("#f2").html("该号码不可用");
                            $("#f2").attr("color","red");
                            $("#b1").attr("disabled",true);
                        }
                    },
                    error : function () {
                        alert("请求失败，刷新后重试！！！");
                        return false;
                    }
                })
            })
        })

        function time() {
            date = new Date().getTime();
            $("#utime").attr("value",date);
            setTimeout("time()",1000);
        }
        window.onload = function () {
            time();
        }

        $(function () {
            $('#b1').click(function () {
            email = $.trim($('#email').val());
            phone = $.trim($('#phone').val());
            password = $.trim($('#password').val());
            name1 = $.trim($('#name').val());
            birthday = $.trim($('#birthday').val());
            gender = $('input:radio:checked').val();
            utime = $('#utime').val();
            uid = $('#uid').val();
            url = $('#pageContext').val();
            $.ajax({
                type : "post",
                url : url + "/updateUser",
                dataType : "json",
                contentType : "application/json",
                data : JSON.stringify({
                    user : {
                        id : uid,
                        email : email,
                        phone : phone,
                        password : password,
                        utime : utime
                    },
                    datum : {
                        name : name1,
                        birthday : birthday,
                        gender : gender
                    }
                }),
                success : function (data) {
                    if (data.error == 0){
                        alert("修改成功");
                        window.location.href = url + "/udatum?userid="+ uid;
                        return false;
                    }
                },
                error : function () {
                    alert("请求失败！");
                    //刷新当前页
                    window.location.reload();
                    return false;
                }
            })
            })
        })
    </script>
</head>
<body>
<input id="pageContext" type="hidden" value="${pageContext.request.contextPath}" />
<input id="uid" type="hidden" value="${user.id}" />
<input type="hidden" id="utime" value="" />
    <table border="1" align="center">
        <tr>
            <td>邮箱：</td>
            <td><input id="email" type="text" name="email" value="${user.email}" />
                <span><font id="f1"></font></span>
            </td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input id="phone" type="text" name="phone" value="${user.phone}" />
            <span><font id="f2"></font></span></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" id="password" value="${user.password}" /></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input id="name" type="text" name="name" value="${user.datum.name}" /></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="radio" name="gender" value="0"/>男<input type="radio" name="gender" value="1"/>女</td>
        </tr>
        <tr>
            <td>生日：</td>
            <td>
            <input id="birthday" type="date" name="birthday" value="${user.datum.birthday}" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button id="b1" type="submit">修改</button>
            </td>
        </tr>
    </table>
</body>
</html>
