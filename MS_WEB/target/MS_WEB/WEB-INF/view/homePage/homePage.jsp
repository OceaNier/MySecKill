<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/18
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎您</title>
</head>
<body>
欢迎：<span id="userAccount"></span>
<a href="/userRegisterLoginAction/toRegister">注册</a>
<a href="/userRegisterLoginAction/toLogin">登陆</a>
<a href="/userRegisterLoginAction/exit">退出登录</a>
<a href="/orderAction/queryOrderByUserId">订单查询</a>

<table border="2">
    <tr>
        <td>商品标题</td>
        <td>图片地址</td>
        <td>秒杀价格</td>
        <td>原价</td>
        <td>秒杀开始时间</td>
        <td>秒杀结束时间</td>
        <td>操作</td>

    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.productTitle}</td>
            <td>${item.productPicture}</td>
            <td>${item.miaoshaPrice}</td>
            <td>${item.originalPrice}</td>
            <td>${item.startTime}</td>
            <td>${item.endTime}</td>
            <td><a href="viewProductDetail?productId=${item.id}">&nbsp查看&nbsp</a></td>
        </tr>
    </c:forEach>
</table>
<script src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $.ajax({
        type:"get",
        url:"/pageHomeAction/getUser",
        success:function(msg){
            alert("I am an alert box!!")
            $("#userAccount").html(msg);
        }
    });
</script>
</body>
</html>
