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
<form action="register" method="post">

    用户姓名：<input name="username"><br><br>
    用户账号：<input name="userAccount"><br><br>
    用户密码：<input name="userPassword"><br><br>
    用户性别：<input name="userSex"><br><br>
    用户年龄：<input name="userAge"><br><br>
    用户地址：<input name="userAddress"><br><br>
    用户邮箱：<input name="userEmail"><br><br>

    <input type="button" value="提交" onclick="submit(this)">

</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
