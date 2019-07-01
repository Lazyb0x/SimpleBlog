<%--
  Created by IntelliJ IDEA.
  User: GYM
  Date: 2019/6/26
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <div>
        <form action="createAccount" method="post">
            <div>
                <label for="name">用户名：</label>
                <input type="text" name="name" id="name">
            </div>
            <div>
                <label for="password">密码：</label>
                <input type="text" name="password" id="password">
            </div>
            <div>
                <input type="submit" value="提交">
            </div>
        </form>
    </div>
</body>
</html>
