<%--
  Created by IntelliJ IDEA.
  User: viphu
  Date: 2017-10-29
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%!
%><%
    String basePath= application.getInitParameter("localPath");//获取的是项目的根路径
%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/css/admin/admin.css">
</head>
<body>
<table class="table">
    <tr>
        <th>用户ID</th>
        <th>用户邮箱</th>
        <shiro:hasPermission name="delete_user">
            <th>删除</th>
        </shiro:hasPermission>
        <shiro:hasRole name="super">
            <th>权限管理</th>
        </shiro:hasRole>
    </tr>
    <c:forEach var="user" items="${pageBean.list}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userLoginAccount}</td>
            <shiro:hasPermission name="delete_user">
            <td><a href="<%=basePath%>/user/user_list?pageNo=1">删除</a></td>
            </shiro:hasPermission>
            <shiro:hasRole name="super">
                <td><a href="#">权限</a></td>
            </shiro:hasRole>
        </tr>
    </c:forEach>
</table>
</body>
</html>
