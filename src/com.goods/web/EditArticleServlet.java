package com.goods.web;

import com.goods.dao.UserDao;
import com.goods.model.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditArticleServlet")
public class EditArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");      //解决提交中文乱码的问题
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("servlet id=" + id);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

        UserDao dao = new UserDao();
        dao.editArticle(article,id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("releaseSuccess.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
