<%--
  Created by IntelliJ IDEA.
  User: GYM
  Date: 2019/6/24
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            margin-bottom: 2ex;
        }
    </style>
</head>
<body>
    <h1>撰写文章</h1>
    <br>
    <form action="add-article" method="post">
        <div>
            <label for="title">标题:</label>
            <input type="text" id="title" name="title">
        </div>
        <div>
            <label for="content">内容：</label>
            <textarea name="content" id="content" cols="40" rows="20"></textarea>
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>

</body>
</html>
