<%@ page import="com.goods.model.User" %><%--
  Created by IntelliJ IDEA.
  User: GYM
  Date: 2019/6/23
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:useBean id="user" class="com.goods.model.User" scope="session"/>
    <%--<%--%>
        <%--String name = request.getParameter("name");--%>
        <%--String password = request.getParameter("password");--%>
        <%--user =(User) request.getAttribute("dbuser");--%>
    <%--%>--%>
    <p>登录成功！</p>
    <p>您的用户名是：<%=user.getName()%></p>
    <a href="/">返回首页</a>
</head>
<body>

</body>
</html>
