package com.ironyard.servlet;

import com.ironyard.data.GroceryItem;
import com.ironyard.data.IronYardUser;
import com.ironyard.service.GroceryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jasonskipper on 1/31/17.
 */
@WebServlet(name = "ListGroceryServlet", urlPatterns = "/list")
public class ListGroceryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroceryService gs = new GroceryService();
        IronYardUser user = (IronYardUser) request.getSession().getAttribute("ironyard_user");
        List<GroceryItem> allItems = gs.getAllGroceryFromDatabase();
        request.setAttribute("gList", allItems);

        // forward back to create page
        String nextJSP = "/home.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);

    }
}
