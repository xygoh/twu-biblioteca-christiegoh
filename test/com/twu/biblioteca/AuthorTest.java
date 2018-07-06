package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AuthorTest {
    Author a = new Author("Squilliam","Fancyson",new ArrayList<Book>());
    Book b = new Book("I Heart Dancing",1999,a,true);
    Book b1 = new Book ("Top 10 Oboe Hits",2000,a,true);
    Book b2 = new Book ("Being Handsome",1996,a,true);
    ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(b1,b2));

    @Test
    public void testAddBook() {
        a.addBook(b);
        assertTrue(a.books.contains(b));
    }

    @Test
    public void testAddBooks() {
        a.addBooks(books);
        assertTrue(a.books.contains(b1) && a.books.contains(b2));
    }

    @Test
    public void testGetBooks() {
        a.addBook(b);
        a.addBooks(books);
        assertEquals(Arrays.asList(b,b1,b2),a.getBooks());
    }
}