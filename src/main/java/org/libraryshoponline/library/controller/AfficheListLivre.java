package org.libraryshoponline.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.libraryshoponline.library.dto.Book;
import org.libraryshoponline.library.dto.Library;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.fasterxml.jackson.*;

@WebServlet(name = "books",urlPatterns = {"/books"})
public class AfficheListLivre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        final String title=req.getParameter("title");
        final String dateAjout=req.getParameter("dateAjout");
        final String description=req.getParameter("description");
        final Float amount =Float.parseFloat(req.getParameter("prix"));
        Book book = new Book(){{
            setTitle(title);
            setDateAjout(dateAjout);
            setDescription(description);
            setAmount(amount);
        }};
        (new Library()).addBookLibrary(book);
        ObjectMapper objectMapper= new ObjectMapper();
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        objectMapper.writeValue(out,Library.books);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        try {
            final String title=req.getParameter("title");
            final String dateAjout=req.getParameter("dateAjout");
            final String description=req.getParameter("description");
            final Float amount =Float.parseFloat(req.getParameter("prix"));
            Book book = new Book(){{
                setTitle(title);
                setDateAjout(dateAjout);
                setDescription(description);
                setAmount(amount);
            }};
            boolean addBook = (new Library()).addBookLibrary(book);
            if(addBook){
                out.print("<html><body>Le livre a ete ajoute<br/><a href=\"books\">Home<a/></body></html>");
            }
        }catch (NumberFormatException e){
            RequestDispatcher disp = req.getRequestDispatcher("/errors");
            disp.forward(req,resp);
        }



    }


}
