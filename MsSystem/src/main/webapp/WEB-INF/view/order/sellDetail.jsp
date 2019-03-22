<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/19
  Time: 下午4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/orderAction/toPayOrder">
    购买数量：<input type="text" name="count">
    <input type="hidden" name="id" value="${product.id}">
    <table border="1">
        <tr>
            <td>商品标题</td>
            <td>商品图片地址</td>
            <td>秒杀价格</td>
            <td>原价</td>
            <td>秒杀开始时间</td>
            <td>秒杀结束时间</td>
            <td>商品数量</td>
            <td>库存</td>
        </tr>
        <tr>
            <td>${product.productTitle}</td>
            <td>${product.productPicture}</td>
            <td>${product.miaoshaPrice}</td>
            <td>${product.originalPrice}</td>
            <td>${product.startTime}</td>
            <td>${product.endTime}</td>
            <td>${product.productCount}</td>
            <td>${product.stockCount}</td>
        </tr>
    </table>

    <table border="1">
        <tr>
            <td>产地</td>
            <td>商品名称</td>
            <td>品牌</td>
            <td>商品重量</td>
            <td>规格描述</td>
            <td>商品详情图片地址</td>
        </tr>
        <tr>
            <td>${productDetail.productPlace}</td>
            <td>${productDetail.productName}</td>
            <td>${productDetail.brand}</td>
            <td>${productDetail.productWeight}</td>
            <td>${productDetail.specification}</td>
            <td>${productDetail.productDetailPicture}</td>
        </tr>
    </table>

    <input type="button" value="立即购买" onclick="submit(this)">
</form>
</body>

<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>

</html>
