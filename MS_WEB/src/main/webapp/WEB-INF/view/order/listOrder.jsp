<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">
    <tr>
        <td>支付金额</td>
        <td>下单时间</td>
        <td>支付状态</td>
        <td>收货地址</td>
        <td>收货人电话</td>
        <td>收货人</td>
        <td>交易流水号</td>
        <td>数量</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.payAmount}</td>
            <td>${item.createTime}</td>
            <td>${item.payState}</td>
            <td>${item.receivingAddress}</td>
            <td>${item.receivingPhone}</td>
            <td>${item.receivingName}</td>
            <td>${item.tradeSerialNumber}</td>
            <td>${item.count}</td>
            <td>
                <c:if test="${item.payState == 1}"><a
                        href="/orderAction/toPayWithOrder?id=${item.id}&tradeSerialNumber=${item.tradeSerialNumber}&payAmount=${item.payAmount}">继续支付</a></c:if>
                <c:if test="${item.payState == 2}">支付完成||<input type="button" value="发起退款" onclick="applyRefund('${item.id}','${item.payType}')"></c:if>
                <c:if test="${item.payState == 3}">退款成功</c:if>
                <c:if test="${item.payState == 4}">退款申请中</c:if>
                <c:if test="${item.payState == 5}">退款失败</c:if>
            </td>

        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
    function applyRefund(orderId, payType) {
        window.location.href = "/orderAction/applyRefund?orderId="+orderId+"&payType="+payType;
    }
</script>
</body>
</html>
