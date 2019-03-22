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
<form action="applyProduct" method="post">

    商品id：<input name="productId"><br><br>
    商品标题：<input name="productTitle"><br><br>
    商品图片地址：<input name="productPicture"><br><br>
    秒杀价格：<input name="miaoshaPrice"><br><br>
    原价：<input name="originalPrice"><br><br>
    商家id：<input name="merchantId"><br><br>
    秒杀开始时间：<input name="startTimeString"><br><br>
    秒杀结束时间：<input name="endTimeString"><br><br>
    商品数量：<input name="productCount"><br><br>
    库存：<input name="stockCount"><br><br>
    描述：<input name="description"><br><br>

    <input type="button" value="提交" onclick="submit(this)">

</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>