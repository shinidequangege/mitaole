<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="org.apache.shiro.session.Session" %>
<%@ page import="cc.xpress.mitaole.user.dto.UserTbDTO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.apache.shiro.subject.Subject" %><%--
  Created by IntelliJ IDEA.
  User: viphu
  Date: 2017-10-26
  Time: 22:01
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String basePath=application.getInitParameter("localPath");//获取的是项目的根路径
%>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
    <p>服务器2</p>
    <p>登陆成功:</p>
    <p>登陆账户：<span>${userBean.userId}</span></p>
    <p>登陆账户：<span>${userBean.userLoginAccount}</span></p>
    <p>账户余额：<span>${userBean.accountTbDTO.accountTotal}</span></p>
    <p>冻结金额：<span>${userBean.accountTbDTO.accountFreeze}</span></p>
    <p>可用余额：<span>${userBean.accountTbDTO.accountBalance}</span></p>
    <shiro:hasAnyRoles name="super,admin">
        <a href="<%=request.getContextPath()%>/user/user_list/1.html">用户管理</a>
    </shiro:hasAnyRoles>
</body>
</html>
