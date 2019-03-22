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
<form action="update" method="post">
    <input name="id" value="${productDetail.id}" type="hidden">
    <input name="productId" value="${productDetail.productId}" type="hidden">
    <input name="merchantId" value="${productDetail.merchantId}" type="hidden">
    产地：<input name="productPlace" value="${productDetail.productPlace}"><br><br>
    商品名称：<input name="productName" value="${productDetail.productName}"><br><br>
    品牌：<input name="brand" value="${productDetail.brand}"><br><br>
    商品重量：<input name="productWeight" value="${productDetail.productWeight}"><br><br>
    规格详情：<input name="specification" value="${productDetail.specification}"><br><br>
    商品图片地址：<input name="productDetailPicture" value="${productDetail.productDetailPicture}"><br><br>
    <input type="button" value="提交" onclick="submit(this)">

</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
