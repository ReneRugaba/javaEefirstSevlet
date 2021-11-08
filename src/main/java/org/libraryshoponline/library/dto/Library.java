package org.libraryshoponline.library.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    public static List<Book> books=new ArrayList<>();

    public Library(){

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }



    public boolean addBookLibrary(Book book){
        books.add(book);
        return true;
    }

    public boolean update(int id,Book book){
        books.set(id, book);
        return true;
    }

    public Book getBookInList(int id){
        return books.get(id);
    }
}
