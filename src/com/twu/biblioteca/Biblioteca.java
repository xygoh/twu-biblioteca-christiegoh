package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    List<Book> library; // master list of books both available and unavailable
    List<Movie> movies; // master list of movies both available and unavailable

    public Biblioteca(){
        this.library = new ArrayList<Book>();
        this.movies = new ArrayList<Movie>();
    }

    public Biblioteca(List<Book> library) {
        this.library = library;
        this.movies = new ArrayList<Movie>();
    }

    public List<Book> getLibrary() {
        return library;
    }

    public void defaultSetupBooks(){
        Author a = new Author("Squilliam","Fancyson",new ArrayList<Book>());
        Book b1 = new Book("I Heart Dancing",1999,a,true);
        Book b2 = new Book ("Top 10 Oboe Hits",2000,a,true);
        Book b3 = new Book ( "Being Handsome",1996,a,false);

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
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        for(Book b:library){
            if (b.isAvailable()){
                b.getDetails(format);
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

    public void defaultSetUpMovies(){
        Director d = new Director("Wes","Anderson");
        Movie m1 = new Movie("The Royal Tenenbaums",1999,true,d,new Rating(7));
        Movie m2 = new Movie("Moonrise Kingdom",2000, true,d,new Rating(8));
        Movie m3 = new Movie("Shopping List", 1961,false,d,new Rating());

        movies.addAll(Arrays.asList(m1,m2,m3));
    }

    public void listMovies(){
        String format = "%-40s%-40s%-10s%-10s%n";
        System.out.println("");
        System.out.printf(format,"Title","Director","Year","Rating");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        for(Movie m:movies){
            if (m.isAvailable()){
                m.getDetails(format);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
    }
}
