package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import java.util.ArrayList;
import org.junit.contrib.java.lang.system.SystemOutRule;
import static org.junit.Assert.*;

public class BibliotecaTest {
    Biblioteca biblioteca;
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Author> authors = new ArrayList<Author>();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Before
    public void setup(){
        for(int i=1;i<=3;i++){
            Author a = new Author(i,"Luffy","Monkey",new ArrayList<>());
            Book b = new Book(i,"Book "+Integer.toString(i),1990+i,a,true);
            books.add(b);
            authors.add(a);
        }
        biblioteca = new Biblioteca(books,authors);
    }

    @Test
    public void getLibrary() {
        assertEquals(books,biblioteca.getLibrary());
    }

    @Test
    public void getAuthorList() {
        assertEquals(authors,biblioteca.getAuthorList());
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
}