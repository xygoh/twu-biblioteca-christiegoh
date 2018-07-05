package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class Tests {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();


    // Welcome Message
    @Test
    public void testWelcomeMessage(){
        // check log for welcome message
        BibliotecaApp.main(new String[] {});
        assertTrue(sor.getLog().contains(" ~ Welcome to Biblioteca ~ "));
    }

    /* List Books: tested in biblioteca test
    @Test
    public void testListBooks(){
        String[] booklist= new String[2];
        assertEquals(new String[]{"book1","book2"},booklist);
    }*/
    // Book Details: same as above

    // Main Menu
    @Test
    public void testMainMenu(){
        BibliotecaApp.main(new String[] {});
        assertTrue(sor.getLog().contains("MENU"));
    }
    // Invalid Menu Option
    @Test
    public void testInvalidMenuOption(){
        Biblioteca b = new Biblioteca();
        MainMenu m = new MainMenu(b);
        si.provideLines("100");
        m.run();
        assertTrue(sor.getLog().contains("Invalid Option"));
    }
    // Quit

    // Checkout book
    // Successful checkout
    // Unsuccessful Checkout
    // Return Book
    // Successful Return
    // Unsuccessful Return

}
