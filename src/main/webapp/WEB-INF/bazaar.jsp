<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.manage.sys.sms.api.entity.BazaarEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>摊位管理</title>
    <style>
        .col{
            width: 250px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<center>
    <div style="margin-top: 50px">
        <table>
            <tr>
            <td class="col">名称</td>
            <td class="col">电话</td>
            <td class="col">管理员</td>
            <td class="col">地址</td>
            <td class="col">排序</td>
            <td class="col">状态</td>
            <td class="col">操作</td>
            </tr>
            <c:forEach var="item" items="${bazaar}" varStatus="i">
                <tr>
                    <td class="col">${item.name}</td>
                    <td class="col">${item.phone}</td>
                    <td class="col">${item.manager}</td>
                    <td class="col">${item.location}</td>
                    <td class="col">${item.sortNumber}</td>
                    <td class="col">${item.status==0 ? "未开放" : "开放"}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</center>

</body>
</html>
