<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/13
  Time: 下午9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateProductState" method="post">

    <%-- 提交的表单数据，传到后端 --%>
    <input name="id" value="${product.id}" type="hidden">
    商品id：${product.productId}<br><br>
    商家id：${product.merchantId}<br><br>
    商品标题：${product.productTitle}<br><br>
    商品图片地址：${product.productPicture}<br><br>
    秒杀商品价格：${product.miaoshaPrice}<br><br>
    商品原价格：${product.originalPrice}<br><br>
    商品申请时间：${product.applyDate}<br><br>
    秒杀开始时间：${product.startTime}<br><br>
    秒杀结束时间：${product.endTime}<br><br>
    秒杀数量：${product.productCount}<br><br>
    商品库存：${product.stockCount}<br><br>
    商品描述：${product.description}<br><br>

    <%-- 提交的表单数据，传到后端，参数为state --%>
    <input type="radio" name="state" value="2">审核通过&nbsp&nbsp<input type="radio" name="state" value="3">审核不通过
    <input type="button" value="提交" onclick="submit(this)">

</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
