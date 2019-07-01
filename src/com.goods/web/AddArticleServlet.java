package com.goods.web;

import com.goods.dao.UserDao;
import com.goods.model.Article;
import com.goods.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");      //解决提交中文乱码的问题
        response.setCharacterEncoding("UTF-8");
//        int id = Integer.parseInt(request.getParameter("id"));
//        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user =(User) request.getSession().getAttribute("user");
        String author = user.getName();

        Article article = new Article();
        article.setTitle(title);
        article.setAuthor(author);
        article.setContent(content);
        userDao.addArticle(article);

        RequestDispatcher dispatcher = request.getRequestDispatcher("releaseSuccess.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
