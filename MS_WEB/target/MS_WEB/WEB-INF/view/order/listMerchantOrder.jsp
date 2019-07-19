<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/20
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
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
                <c:if test="${item.payState == 1}">未支付</c:if>
                <c:if test="${item.payState == 2}">支付完成</c:if>
                <c:if test="${item.payState == 3}">退款成功</c:if>
                <c:if test="${item.payState == 4}"><a href="javascript:void(0)" onclick="auditRefund('${item.userId}','${item.payType}','3','${item.payAmount}','${item.tradeSerialNumber}')">退款审核通过</a>
                    ||<a href="javascript:void(0)" onclick="auditRefund('${item.userId}','${item.payType}','5','${item.payAmount}','${item.tradeSerialNumber}')">退款审核不通过</a></c:if>
                <c:if test="${item.payState == 5}">退款失败</c:if>
            </td>

        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
    function auditRefund(userId, payType, payState, payAmount,tradeSerialNumber) {
        window.location.href = "/orderAction/auditRefund?userId="+userId+"&payType="
            +payType+"&payState="+payState+"&payAmount="+payAmount+"&tradeSerialNumber="+tradeSerialNumber;
    }
</script>
</body>
</html>
