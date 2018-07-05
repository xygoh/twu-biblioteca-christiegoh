package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {
    List<Book> books = new ArrayList<Book>();
    Author a = new Author(1,"Mr","Krabs",books);
    Book b = new Book(1,"The Secret Formula",1980,a,true);

    @Before
    public void setup(){
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