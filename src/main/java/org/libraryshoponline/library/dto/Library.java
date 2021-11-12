package org.libraryshoponline.library.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    public static List<Book> books=new ArrayList<>();


    public boolean addBookLibrary(Book book){
        books.add(book);
        return true;
    }

    public Book update(int id,Book book){
        books.set(id, book);
        return books.get(id);
    }

    public Book getBookInList(int id){
        return books.get(id);
    }

    public boolean removeBookInList(int id){
        books.remove(id);
        return true;
    }
}
