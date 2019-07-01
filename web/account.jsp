<%--
  Created by IntelliJ IDEA.
  User: GYM
  Date: 2019/6/20
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="login" method="post">
        <label for="name">用户名：</label>
        <input type="text" id="name" name="name">
        <label for="password">密码：</label>
        <input type="text" id="password" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
