package com.goods.web;

import com.goods.dao.UserDao;
import com.goods.model.Article;
import com.goods.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userdao = new UserDao();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Article article = userdao.displayArticle(id);
        if(user==null) System.out.println("user null");
        if(article==null) System.out.println("article null");
        if (user.getName().equals(article.getAuthor())){
            userdao.deleteArticle(id);
        }

//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request,response);
        response.sendRedirect("index.jsp");
    }
}
