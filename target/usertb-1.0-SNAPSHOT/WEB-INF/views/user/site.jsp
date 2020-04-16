<%--
  Created by IntelliJ IDEA.
  User: LongGuoShuai
  Date: 2020/4/1
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理收货地址</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>电话</td>
            <td>地址</td>
            <td>邮箱</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${user.sites}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.phone}</td>
                <td>${s.address}</td>
                <td>${s.mailbox}</td>
                <td><a href="${pageContext.request.contextPath}/deleteSite?id=${s.id}&uid=${user.id}"><button id="delete">删除</button></a></td>
            </tr><input id="id" type="hidden" value="${s.id}" />
        </c:forEach>
        <tr>
            <td colspan="8" align="center"><button id="save" >增加</button></td>
        </tr>
        <span id="s">

        </span>
    </table>
<input type="hidden" id="contextPath" value="${pageContext.request.contextPath}" />
<input type="hidden" id="uid" value="${user.id}"/>
<script>
    $(function () {
        /*$('#delete').click(function () {
            id = $('#id').val();
            url = $('#contextPath').val();
            $.ajax({
                type : "post",
                url : url + "/deleteSite?id="+id,
                success : function (data) {
                    if (data.error == 0){
                        alert("删除成功！！");
                        window.location.reload();
                        return false;
                    }else{
                        alert("删除失败，请重试！！");
                        return false;
                    }
                },
                error : function () {
                    alert("连接失败，请重试！！！");
                    window.location.reload();
                    return false;
                }
            })
        })*/

        $('#save').click(function () {
            $('#s').html('<table align="center"><tr>\n' +
                '            <td></td>\n' +
                '            <td><input id="name" type="text" placeholder="姓名" /></td>\n' +
                '            <td><input id="phone" type="text" placeholder="电话"/></td>\n' +
                '            <td><input id="address" type="text" placeholder="地址"/></td>\n' +
                '            <td><input id="mailbox" type="text" placeholder="邮编"/></td>\n' +
                '            <td><button id="b1" onclick="save()" type="submit" >提交</button></td>\n' +
                '        </tr></table>')
        })

    })

    function save() {
            names = $.trim($('#name').val());
            phone = $.trim($('#phone').val());
            address = $.trim($('#address').val());
            mailbox = $.trim($('#mailbox').val());
            uid = $('#uid').val();
            url = $('#contextPath').val();
            $.ajax({
                type: 'post',
                url: url + '/saveSite',
                dataType : 'json',
                contentType : 'application/json',
                data : JSON.stringify({
                    uid : uid,
                    name : names,
                    phone : phone,
                    address : address,
                    mailbox : mailbox
                }),
                success : function (data) {
                    if (data.error == 0){
                        window.location.reload();
                    }else {
                        alert('添加失败，请重试！！');
                        return false;
                    }
                },
                error : function () {
                    alert("连接失败，请重试！！！");
                    window.location.reload();
                    return false;
                }
        })
    }

</script>
</body>
</html>
