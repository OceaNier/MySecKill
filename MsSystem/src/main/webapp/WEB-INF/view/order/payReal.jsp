<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/20
  Time: 下午12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/orderAction/payWithOrder", method="post">
    支付方式：<br>
    <input type="radio" name="payType" value="1"/>支付宝<br>
    <input type="radio" name="payType" value="2"/>微信支付<br>
    <input type="radio" name="payType" value="3"/>银联支付<br>

    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="tradeSerialNumber" value="${tradeSerialNumber}">
    <input type="hidden" name="payAmount" value="${payAmount}">

    支付金额：${payAmount}<br>
    交易流水号：${tradeSerialNumber}<br>

    <input type="button" value="立即付款" onclick="submit(this)">
</form>

</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
