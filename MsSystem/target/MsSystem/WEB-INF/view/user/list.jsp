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
    <a href="toAdd">添加用户</a>
</center>
<table border="2">
    <tr>
        <td>用户姓名</td>
        <td>用户账号</td>
        <td>用户密码</td>
        <td>用户性别</td>
        <td>用户年龄</td>
        <td>用户地址</td>
        <td>用户邮箱</td>
        <td>操作</td>

    </tr>
        <c:forEach items="${userList}" var="item">
            <tr>
                <td>${item.username}</td>
                <td>${item.userAccount}</td>
                <td>${item.userPassword}</td>
                <td>${item.userSex}</td>
                <td>${item.userAge}</td>
                <td>${item.userAddress}</td>
                <td>${item.userEmail}</td>
                <td><a href="toUpdate?id=${item.id}">修改</a> <a href="delete?id=${item.id}">删除</a> <a href="query?id=${item.id}">查看</a></td>
            </tr>

        </c:forEach>
</table>
</body>
</html>
