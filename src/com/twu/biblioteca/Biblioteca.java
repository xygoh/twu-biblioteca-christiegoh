package com.twu.biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    List<Book> library; // master list of books

    public Biblioteca(){
        this.library = new ArrayList<Book>();
    }

    public Biblioteca(List<Book> library) {
        this.library = library;
    }

    public List<Book> getLibrary() {
        return library;
    }

    public void defaultSetupBooks(){
        Author a = new Author(1,"Squilliam","Fancyson",new ArrayList<Book>());
        Book b1 = new Book(1,"I Heart Dancing",1999,a,true);
        Book b2 = new Book (2, "Top 10 Oboe Hits",2000,a,true);
        Book b3 = new Book (3, "Being Handsome",1996,a,false);

        library.add(b1);
        library.add(b2);
        library.add(b3);
        a.addBooks(library);
    }

    // Prints list of books <Title , author, year published>
    public void listBooks(){
        String format = "%-50s%-50s%s%n";
        System.out.println("");
        System.out.printf(format,"Title","Author","Year Published");
        //System.out.println("Title\tAuthor\t\t\t\tYear Published");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        for(Book b:library){
            if (b.isAvailable()){
                String title = b.getTitle();
                String author = b.getAuthor();
                String year = Integer.toString(b.getYear());
                System.out.printf(format,title,author,year);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
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
