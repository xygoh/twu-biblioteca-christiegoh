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
            Book b = new Book(i,"Book "+Integer.toString(i),1990+i,a,1);
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
        String expected = "id\tTitle\t\t\tAuthor\t\t\t\tYear Published\n" +
                "------------------------------------------------------\n" +
                "1\tBook 1\t\t\tLuffy Monkey\t\t\t1991\n" +
                "2\tBook 2\t\t\tLuffy Monkey\t\t\t1992\n" +
                "3\tBook 3\t\t\tLuffy Monkey\t\t\t1993\n" +
                "------------------------------------------------------\n";
        biblioteca.listBooks();
        assertEquals(expected,sor.getLog());
    }
}