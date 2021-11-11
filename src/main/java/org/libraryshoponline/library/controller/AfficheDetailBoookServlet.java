package org.libraryshoponline.library.controller;


import org.libraryshoponline.library.dto.Library;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "afficheDetailsBook",urlPatterns = {"/detailsbook"})
public class AfficheDetailBoookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("bookDetails",(new Library()).getBookInList(Integer.parseInt(req.getParameter("index"))));
        req.getRequestDispatcher("/details.jsp").forward(req,resp);
    }
}
