<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/18
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎您</title>
</head>
<body>
${errorInfo}
欢迎：${merchant.merchantAccount}
<a href="/merchantRegisterLoginAction/toRegister">商家注册</a>
<a href="/merchantRegisterLoginAction/toLogin">商家登陆</a>
<a href="/merchantRegisterLoginAction/exit">商家退出登录</a>
<a href="/orderAction/queryOrderByMerchantId">订单查询</a>


</body>
</html>
