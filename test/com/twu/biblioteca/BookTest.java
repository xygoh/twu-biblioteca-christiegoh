package com.twu.biblioteca;

import com.twu.biblioteca.LibraryItems.Book;
import com.twu.biblioteca.LibraryItems.LibraryItem;
import com.twu.biblioteca.Persons.Author;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {
    static List<LibraryItem> books = new ArrayList<LibraryItem>();
    static Author a = new Author("Mr","Krabs",books);
    static Book b = new Book("The Secret Formula",1980,a,true);

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
        assertEquals("Mr Krabs",b.getAuthor().getFullName());
    }
}