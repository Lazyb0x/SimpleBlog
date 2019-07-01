package com.goods.web;

import com.goods.dao.UserDao;
import com.goods.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User dbuser = new UserDao().getUser(name);
        if (dbuser!=null && dbuser.getPassword().equals(password)){
            request.setAttribute("dbuser",dbuser);
            HttpSession session = request.getSession();
            session.setAttribute("user",dbuser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
            dispatcher.forward(request,response);
        }
        else{
            System.out.println("登录失败！");
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginFailed.jsp");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
