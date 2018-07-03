package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AuthorTest {
    Author a = new Author(1,"Squilliam","Fancyson",new ArrayList<Book>());
    Book b = new Book(1,"I Heart Dancing",1999,a,1);
    Book b1 = new Book (2, "Top 10 Oboe Hits",2000,a,1);
    Book b2 = new Book (3, "Being Handsome",1996,a,1);
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