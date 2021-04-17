<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<center>
    <div style="margin-top: 300px;">
        <h3>用户登陆</h3>
        <form action="/dologin" method="post">
            用户名：<input style="margin-top: 20px" type="text" name="username"><br>
            密码：<input  style="margin-top: 20px" type="password" name="password"><br>
            <input type="submit" value="登陆" style="margin-top: 20px">
            <input type="reset" value="重置">
        </form>
    </div>
</center>
</body>
</html>
