package com.twu.biblioteca;

import com.twu.biblioteca.LibraryItems.Book;
import com.twu.biblioteca.LibraryItems.LibraryItem;
import com.twu.biblioteca.Persons.Author;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import java.util.ArrayList;
import org.junit.contrib.java.lang.system.SystemOutRule;
import static org.junit.Assert.*;

public class BibliotecaTest {
    static Biblioteca biblioteca;
    static ArrayList<Book> books = new ArrayList<Book>();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @BeforeClass
    public static void setup(){
        for(int i=1;i<=3;i++){
            Author a = new Author("Luffy","Monkey",new ArrayList<>());
            Book b = new Book("Book "+Integer.toString(i),1990+i,a,true);
            books.add(b);
        }
        biblioteca = new Biblioteca(books);
    }

    @Test
    public void testConstruction(){
        assertEquals(3, biblioteca.getLibrary().size());
    }

    @Test
    public void listBooks() {
        String expected = "\nTitle                                             Author                                            Year Published\n" +
                "----------------------------------------------------------------------------------------------------------------------\n" +
                "Book 1                                            Luffy Monkey                                      1991\n" +
                "Book 2                                            Luffy Monkey                                      1992\n" +
                "Book 3                                            Luffy Monkey                                      1993\n" +
                "----------------------------------------------------------------------------------------------------------------------\n";
        biblioteca.listBooks();
        assertEquals(expected,sor.getLog());
    }

    @Test
    public void testMovieSetup(){
        biblioteca.defaultSetUpMovies();
        assertTrue(biblioteca.movies.get(0).getTitle()=="The Royal Tenenbaums");
        assertTrue(biblioteca.movies.get(1).getTitle()=="Moonrise Kingdom");
        assertTrue(biblioteca.movies.get(2).getTitle()=="Shopping List");
    }


}