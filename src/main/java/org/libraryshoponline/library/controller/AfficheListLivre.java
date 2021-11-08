package org.libraryshoponline.library.controller;

import org.libraryshoponline.library.dto.Book;
import org.libraryshoponline.library.dto.Library;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "books",urlPatterns = {"/books"})
public class AfficheListLivre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        out.print("<html><body><ul>");
        for (int i=0;i<Library.books.size();i++){

            out.print("<li><a href='pannier?id="+i+"'>"+Library.books.get(i).getTitle().substring(0,1).toUpperCase()+Library.books.get(i).getTitle().substring(1).toLowerCase()+"</a></li>");
        }
        out.print("</ul></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        final String title=req.getParameter("title");
        final String dateAjout=req.getParameter("dateAjout");
        final String description=req.getParameter("description");
        Book book = new Book(){{
            setTitle(title);
            setDateAjout(dateAjout);
            setDescription(description);
        }};

        boolean addBook = (new Library()).addBookLibrary(book);
        if(addBook){
            out.print("<html><body>Le livre a ete ajoute<br/><a href=\"books\">Home<a/></body></html>");
        }
    }


}
