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

    public void defaultSetupBooks(){
        Author a = new Author(1,"Squilliam","Fancyson",new ArrayList<Book>());
        Book b1 = new Book(1,"I Heart Dancing",1999,a,true);
        Book b2 = new Book (2, "Top 10 Oboe Hits",2000,a,true);
        Book b3 = new Book (3, "Being Handsome",1996,a,true);

        library.add(b1);
        library.add(b2);
        library.add(b3);
        a.addBooks(library);
    }

    // Prints list of books <id, Title , author, year published>
    public void listBooks(){
        System.out.println("id\tTitle\t\t\tAuthor\t\t\t\tYear Published");
        System.out.println("------------------------------------------------------");
        for(Book b:library){
            // book to string record method
            int id = b.getId();
            String title = b.getTitle();
            String author = b.getAuthor();
            int year = b.getYear();

            System.out.println(id+"\t"+title+"\t\t\t"+author+"\t\t\t"+year);
        }
        System.out.println("------------------------------------------------------");
    }

    public Book searchLibrary(String bookTitle){
        for (Book b: library){
            if (b.getTitle().trim().toLowerCase().equals(bookTitle)){
                return b;
            }
        }
        return null;
    }
}
