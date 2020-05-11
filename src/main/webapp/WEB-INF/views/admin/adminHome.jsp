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
                <td><img src="${pageContext.request.contextPath}/static/img/${u.datum.photo}" alt="头像" style="height: 50px;width: 50px"/></td>
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
                ${users.currentPage+1}/${users.totalPages}/总数据${users.totalUsers}
            </td>
        </tr>
    </table>
    <input type="hidden" id="pageContext" value="${pageContext.request.contextPath}">
    <input type="hidden" id="currentPage" value="${users.currentPage}">
    <input type="hidden" id="pageSize" value="${users.pageSize}">
    <input type="hidden" id="tail" value="${users.totalPages}">
<script>
    $(function () {
        pageContext = $('#pageContext').val();
        currentPage = $('#currentPage').val();
        pageSize = $('#pageSize').val();
        tail = $('#tail').val()
        console.log("currentPage=%s,pageSize=%s,tail=%s",currentPage,pageSize,tail);
        if (currentPage == 0){
            $('#b1').attr('disabled',true);
            $('#b2').attr('disabled',true);
        }
        if (currentPage == tail-1 ){
            $('#b3').attr('disabled',true);
            $('#b4').attr('disabled',true);
        }
        /**
         * 首页
         */
        $('#b1').click(function () {
            window.location.href = pageContext+"/userList?cp="+0+"&ps="+pageSize;
        })
        /**
         * 上一页1
         */
        $('#b2').click(function () {
            window.location.href = pageContext+"/userList?cp="+(currentPage-1)+"&ps="+pageSize;
        })
        /**
         * 下一页
         */
        $('#b3').click(function () {
            window.location.href = pageContext+"/userList?cp="+currentPage+1+"&ps="+pageSize;
        })
        /**
         * 尾页
         */
        $('#b4').click(function () {
            window.location.href = pageContext+"/userList?cp="+(tail-1)+"&ps="+pageSize;
        })
    })
</script>
</body>
</html>
