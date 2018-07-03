package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;

public class Tests {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    // Welcome Message
    @Test
    public void testWelcomeMessage(){
        // check log for welcome message
        BibliotecaApp.main(new String[] {});
        assertEquals( " ~ Welcome to Biblioteca ~ \n",sor.getLog());
    }

    // List Books
    @Test
    public void testListBooks(){
        String[] booklist= new String[2];
        assertEquals(new String[]{"book1","book2"},booklist);
    }

    // Book Details
    // Main Menu
    // Invalid Menu Option
    // Quit
    // Checkout book
    // Successful checkout
    // Unsuccessful Checkout
    // Return Book
    // Successful Return
    // Unsuccessful Return

}
