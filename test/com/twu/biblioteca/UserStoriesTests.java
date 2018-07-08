package com.twu.biblioteca;

import com.twu.biblioteca.MainMenuItems.LoginOption;
import com.twu.biblioteca.MainMenuItems.MainMenuItem;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Hashtable;

import static org.junit.Assert.*;

// general tests go here first will get refactored into more appropriate test classes later on.
public class UserStoriesTests {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

// test options shown only when logged in
    // test displays correct menu depending on whether logged in or not
    @Test
    public void testMenuDisplay_LoggedIn(){
        Biblioteca b = new Biblioteca();
        b.defaultSetUpMovies();
        b.defaultSetupBooks();

        UserManager userMan = new UserManager();
        userMan.defaultSetupUsers();

        MainMenu m = new MainMenu(b,userMan);
        si.provideLines("1\n000-0000\npassword");
        m.run();

        assertTrue(sor.getLog().contains("Checkout an Item"));
    }

    @Test
    public void testMenuDisplay_NotLoggedIn(){
        Biblioteca b = new Biblioteca();
        b.defaultSetUpMovies();
        b.defaultSetupBooks();

        UserManager userMan = new UserManager();
        userMan.defaultSetupUsers();

        MainMenu m = new MainMenu(b,userMan);

        m.run();
        assertTrue(sor.getLog().contains("Login"));
        assertFalse(sor.getLog().contains("Checkout an Item"));
    }
}