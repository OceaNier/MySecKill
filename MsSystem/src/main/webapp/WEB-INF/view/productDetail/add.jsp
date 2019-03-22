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
<form action="addProductDetail" method="post">
    <input name="productId" type="hidden" value="${productId}">
    <input name="merchantId" type="hidden" value="${merchantId}">
    产地：<input name="productPlace"><br><br>
    商品名称：<input name="productName"><br><br>
    品牌：<input name="brand"><br><br>
    商品重量：<input name="productWeight"><br><br>
    规格描述：<input name="specification"><br><br>
    商品详情图片地址：<input name="productDetailPicture"><br><br>

    <input type="button" value="提交" onclick="submit(this)">

</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>