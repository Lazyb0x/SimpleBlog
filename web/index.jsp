<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.goods.model.Article" %>
<%@ page import="com.goods.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.goods.model.User" %><%--
  Created by IntelliJ IDEA.
  User: GYM
  Date: 2019/6/14
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Article> list = new UserDao().listArticle();
  request.setAttribute("list",list);
%>
<jsp:useBean id="user" class="com.goods.model.User" scope="session"/>

<html>
  <head>
    <title>简单博客</title>
    <style>
        main{
            margin: 50px auto;
        }
    </style>
  </head>
  <body>
    <h1>简单博客</h1>
    <hr>
  <div id="main">
    <table border="1" style="position: relative;margin: auto">
      <tr>
        <td>ID</td>
        <td>标题</td>
        <td>作者</td>
        <td>日期</td>
        <td  colspan="2">操作</td>
      </tr>

      <%--
        for(Article a : list){
            out.print("<tr>");
            out.print("<td>" + a.getId() + "</td>");
            out.print("<td>" + a.getTitle() + "</td>");
            out.print("<td>" + a.getAuthor() + "</td>");
            out.print("<td>" + a.getDate() + "</td>");
            out.print("</tr>");
        }
      --%>
      <c:forEach items="${list}" var="article">
          <tr>
              <td>${article.id}</td>
              <td><a href="page?id=${article.id}">${article.title}</a></td>
              <td>${article.author}</td>
              <td>${article.date}</td>
              <td><a href="delete?id=${article.id}">删除</a></td>
              <td><a href="edit.jsp?id=${article.id}">编辑</a></td>
          </tr>
      </c:forEach>
    </table>
  </div>
    <hr>
    <a href="account.jsp">登录</a>
    <a href="signin.jsp">注册</a>
    <a href="write.jsp">写文章</a>
  </body>
</html>
