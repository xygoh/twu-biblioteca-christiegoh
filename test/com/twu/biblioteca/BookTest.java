package com.twu.biblioteca;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {
    static List<Book> books = new ArrayList<Book>();
    static Author a = new Author(1,"Mr","Krabs",books);
    static Book b = new Book(1,"The Secret Formula",1980,a,true);

    @BeforeClass
    public static void setup(){
        a.addBook(b);
    }

    @Test
    public void testGetTitle() {
        assertEquals("The Secret Formula",b.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Mr Krabs",b.getAuthor());
    }
}