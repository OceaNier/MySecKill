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
    <a href="toApplyProduct">申请秒杀商品</a>
</center>
<table border="2">
    <tr>
        <td>商品id</td>
        <td>商品标题</td>
        <td>图片地址</td>
        <td>秒杀价格</td>
        <td>原价</td>
        <td>商家id</td>
        <td>申请时间</td>
        <td>审核时间</td>
        <td>审核状态</td>
        <td>秒杀开始时间</td>
        <td>秒杀结束时间</td>
        <td>秒杀商品数</td>
        <td>库存</td>
        <td>商品描述</td>
        <td>操作</td>

    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.productId}</td>
            <td>${item.productTitle}</td>
            <td>${item.productPicture}</td>
            <td>${item.miaoshaPrice}</td>
            <td>${item.originalPrice}</td>
            <td>${item.merchantId}</td>
            <td>${item.applyDate}</td>
            <td>${item.auditDate}</td>
            <td>${item.auditState}</td>
            <td>${item.startTime}</td>
            <td>${item.endTime}</td>
            <td>${item.productCount}</td>
            <td>${item.stockCount}</td>
            <td>${item.description}</td>
            <td><a href="toUpdate?id=${item.id}">修改</a>||<a href="delete?id=${item.id}">删除</a>||<a href="query?id=${item.id}">查看</a>
                ||<a href="toUpdateState?id=${item.id}">审核</a>||<a href="/productDetailAction/toAdd?productId=${item.id}&merchantId=${item.merchantId}">添加详情</a>
                ||<a href="/productDetailAction/toUpdate?productId=${item.id}">修改详情</a>||<a href="/productDetailAction/query?productId=${item.id}">查看详情</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
