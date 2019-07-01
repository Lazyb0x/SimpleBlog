<%--
  Created by IntelliJ IDEA.
  User: GYM
  Date: 2019/6/18
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="article" type="com.goods.model.Article" scope="request"/>
<jsp:useBean id="user" class="com.goods.model.User" scope="session"/>

<html>
<head>
    <title><jsp:getProperty name="article" property="title"/></title>
</head>
<body>
    <div>
        <p>标题：<jsp:getProperty name="article" property="title"/></p>
        <p>作者：<jsp:getProperty name="article" property="author"/></p>
        <p>日期：<jsp:getProperty name="article" property="date"/></p>
        <hr>
        <p><jsp:getProperty name="article" property="content"/></p>
        <p><a href="/">返回</a></p>
    </div>
</body>
</html>
