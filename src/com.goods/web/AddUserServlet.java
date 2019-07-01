package com.goods.web;

import com.goods.dao.UserDao;
import com.goods.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setAdmin(false);
        user.setName(name);
        user.setPassword(password);

        try{
            UserDao dao = new UserDao();
            dao.addUser(user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("signinSuccess.jsp");
            dispatcher.forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
