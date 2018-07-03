package com.twu.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    List<Book> library;
    List<Author> authorList;


    public Biblioteca(){
        this.library = new ArrayList<Book>();
        this.authorList = new ArrayList<Author>();
    }

    public Biblioteca(List<Book> library, List<Author> authorList) {
        this.library = library;
        this.authorList = authorList;
    }

    public List<Book> getLibrary() {
        return library;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    // Prints list of books <id, Title , author, year published>
    public void listBooks(){
        System.out.println("id\tTitle\t\t\tAuthor\t\t\t\tYear Published");
        System.out.println("------------------------------------------------------");
        for(Book b:library){
            int id = b.getId();
            String title = b.getTitle();
            String author = b.getAuthor();
            int year = b.getYear();

            System.out.println(id+"\t"+title+"\t\t\t"+author+"\t\t\t"+year);
        }
        System.out.println("------------------------------------------------------");
    }
}
