package org.libraryshoponline.library.controller;

import org.libraryshoponline.library.dto.Basket;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "pannier",urlPatterns = {"/pannier"})
public class Pannier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        final Book book = (new Library()).getBookInList(Integer.parseInt(req.getParameter("id")));
        Basket basket=(Basket) session.getAttribute("basket");
        if(basket==null){
            final List<Book> bookList=new ArrayList<Book>(){{
                add(book);
            }};
            Basket newBasket = new Basket(){{
               setBasket(bookList);
               setAmount(book.getAmount());
            }};
            session.setAttribute("basket",newBasket);
        }else {
            basket.getBasket().add(book);
            basket.setAmount(basket.getAmount()+ book.getAmount());
            session.setAttribute("basket",basket);
        }
        out.print("<html><body><h2>Pannier:</h2><ol>");
        for (Book b:((Basket)session.getAttribute("basket")).getBasket()){
            out.print("<li>"+b.getTitle()+" : "+b.getAmount()+" euros</li>");
        }
        out.print("</ol></br>");
        out.print("<h1>Montant à payer "+((Basket)session.getAttribute("basket")).getAmount()+" euros</h1>");

        out.print("le numero de session est: "+session.getId()+"</br>" +
                "<a href='books'>Continuer achat!</a></br>");
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
