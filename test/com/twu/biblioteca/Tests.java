package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.contrib.java.lang.system.SystemOutRule;

public class Tests {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    // Welcome Message
    @Test
    public void testWelcomeMessage(){
        // check log for welcome message
        BibliotecaApp.main(new String[] {});
        Assert.assertEquals( " ~ Welcome to Biblioteca ~ \n",sor.getLog());
    }

    // List Books
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
