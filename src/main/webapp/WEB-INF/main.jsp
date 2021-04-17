<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'main.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        .list{
            margin: 10px 10px;
        }
    </style>

</head>

<body>
<div style="width: 100%;height: 50px">
    <span>摊位后台管理系统 当前用户: 【<%=session.getAttribute("name")%>】</span>
</div>

<div style="width: 100px;height: 100%">
    <div class="list">
        <a href="/bazaar/list">市场管理</a> <br/>
    </div>
    <div class="list">
        <a href="/stall/list">摊位管理</a> <br/>
    </div >

    <div class="list">
        <a href="/user/list">人员管理</a>  <br/>
    </div>

    <div class="list">
        <a href="/message/list">消息管理</a> <br/>
    </div>
</div>


</body>
</html>
