package com.ironyard.servlet;

import com.ironyard.service.UserService;
import com.ironyard.data.IronYardUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jasonskipper on 1/26/17.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // fetch all valid users
        UserService uServ = new UserService();

        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        IronYardUser found = uServ.getUser(email, pass);
        request.getSession().setAttribute("ironyard_user", found);

        String nextJSP = "/list";

        if(found == null){
            // error message
            nextJSP = "/login.jsp";
            request.setAttribute("err_login_msg", true);
        }

        // send to JSP page to display tickets
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
