<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/14
  Time: 下午2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <a href="toAdd">添加商家</a>
</center>
<table border="2">
    <tr>
        <td>商家姓名</td>
        <td>商家店铺名称</td>
        <td>商家账号</td>
        <td>商家密码</td>
        <td>商家经营范围</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${merchantList}" var="item">
        <tr>
            <td>${item.merchantName}</td>
            <td>${item.merchantShopName}</td>
            <td>${item.merchantAccount}</td>
            <td>${item.merchantPassword}</td>
            <td>${item.merchantScope}</td>
            <td><a href="toUpdate?id=${item.id}">修改</a>||<a href="delete?id=${item.id}">删除</a>||<a href="query?id=${item.id}">查看</a></td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
