<%--
  Created by IntelliJ IDEA.
  User: LongGuoShuai
  Date: 2020/4/11
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
</head>
<body>
    <table align="center" border="1">
        <tr>
            <td>头像</td>
            <td>id</td>
            <td>会员名</td>
            <td>邮箱</td>
            <td>电话</td>
        </tr>
        <c:forEach var="u" items="${users.users}">
            <tr>
                <td>${u.datum.photo}</td>
                <td>${u.id}</td>
                <td>${u.menbername}</td>
                <td>${u.email}</td>
                <td>${u.phone}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5" align="center">
                <button id="b1">首页</button>
                <button id="b2">上一页</button>
                <button id="b3">下一页</button>
                <button id="b4">尾页</button>
            </td>
        </tr>
    </table>
<script>

</script>
</body>
</html>
