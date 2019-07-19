<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/19
  Time: 下午5:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/orderAction/payOrder", method="post">
    商品名称：${product.productTitle}<br>
    购买数量：${count}<br>
    支付总额：${payAmount}<br>
    <input type="hidden" name="productId" value="${product.id}">
    <input type="hidden" name="userId" value="${userId}">
    <input type="hidden" name="merchantId" value="${product.merchantId}">
    <input type="hidden" name="payAmount" value="${payAmount}">
    <input type="hidden" name="count" value="${count}">
    <input type="hidden" name="stockCount" value="${product.stockCount}">

    收货人地址：<input name="receivingAddress"><br>
    收货人电话：<input name="receivingPhone"><br>
    收货人：<input name="receivingName"><br>

    <input type="button" value="提交订单" onclick="submit(this)">
</form>

</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
