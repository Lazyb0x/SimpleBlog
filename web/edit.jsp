<%--
  Created by IntelliJ IDEA.
  User: GYM
  Date: 2019/6/26
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
    <style>
        div{
            margin-bottom: 2ex;
        }
    </style>
</head>
<body>
<h1>撰写文章</h1>
<br>
<%
    int aid = Integer.parseInt(request.getParameter("id"));
    request.setAttribute("id",aid);
%>
<form action="edit-article" method="post">
    <div>
        <label for="title">标题:</label>
        <input type="text" id="title" name="title">
    </div>
    <div>
        <label for="content">内容：</label>
        <textarea name="content" id="content" cols="40" rows="20"></textarea>
    </div>
    <div>
        <input type="hidden" name="id" value="<%=aid%>">
        <input type="submit" value="提交">
    </div>
</form>

</body>
</html>
