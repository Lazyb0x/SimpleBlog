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

@WebServlet(name = "DisplayArticleServlet")
public class DisplayArticleServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int pageID = Integer.parseInt(request.getParameter("id"));
            Article article = new UserDao().displayArticle(pageID);
            article.setContent(article.getContent().replaceAll("\n","\\\n<br>\\\n"));
            request.setAttribute("article",article);
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages.jsp");
            dispatcher.forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
            dispatcher.forward(request,response);
        }
    }
}
