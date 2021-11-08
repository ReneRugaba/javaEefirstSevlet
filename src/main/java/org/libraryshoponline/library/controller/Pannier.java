package org.libraryshoponline.library.controller;

import org.libraryshoponline.library.dto.Book;
import org.libraryshoponline.library.dto.Library;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "pannier",urlPatterns = {"/pannier"})
public class Pannier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        Book book = (new Library()).getBookInList(Integer.parseInt(req.getParameter("id")));
        session.setAttribute("title",book.getTitle());
        out.print("<html><body>Titre du livre en cours d'achat est "+book.getTitle()+"</br>");
        out.print("le numero de session est: "+session.getId()+"</br>");
        out.print("<form action='pannier' method='POST'>" +
                "<input type='texte' name='cb'/>" +
                "<button type='submit'>Payer</button></form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String title =(String) session.getAttribute("title");
        PrintWriter out = resp.getWriter();
        out.print("Le livre "+title+" vient d'être acheté avec succès!");
    }
}
