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
<form action="add" method="post">
    商家姓名：<input name="merchantName"><br><br>
    商家店铺名称：<input name="merchantShopName"><br><br>
    商家账号：<input name="merchantAccount"><br><br>
    商家密码：<input name="merchantPassword"><br><br>
    商家经营范围：<input name="merchantScope"><br><br>

    <input type="button" value="提交" onclick="submit(this)">

</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
