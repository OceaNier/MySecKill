<%--
  Created by IntelliJ IDEA.
  User: zhangxi
  Date: 2019/3/18
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${errorInfo}
<form action="/userRegisterLoginAction/login" method="post">
    用户账号：<input name="userAccount"><br><br>
    用户密码：<input name="userPassword"><br><br>
    <input type="button" value="提交" onclick="submit(this)">

</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>