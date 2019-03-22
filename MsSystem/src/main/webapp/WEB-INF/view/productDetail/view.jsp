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

<form>
    商品id：${productDetail.productId}<br><br>
    商家id：${productDetail.merchantId}<br><br>
    产地：${productDetail.productPlace}<br><br>
    商品名称：${productDetail.productName}<br><br>
    品牌：${productDetail.brand}<br><br>
    商品重量：${productDetail.productWeight}<br><br>
    规格描述：${productDetail.specification}<br><br>
    商品详情图片地址：${productDetail.productDetailPicture}<br><br>
</form>
</body>
</html>