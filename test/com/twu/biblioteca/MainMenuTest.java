package com.twu.biblioteca;

import com.sun.tools.javac.Main;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class MainMenuTest {
    private static Biblioteca b;
    private static MainMenu m;
    private static UserManager userMan;

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @BeforeClass
    public static void setup(){
        b = new Biblioteca();
        userMan = new UserManager();
        userMan.defaultSetupUsers();
        m = new MainMenu(b,userMan);
    }
    @Test
    public void testMenuListsOptionsWhenRun() {
        m.run();
        assertTrue(sor.getLog().contains("MAIN MENU\n"));
    }

    @Test
    public void testInvalidMenuOption(){
        si.provideLines("100");
        m.run();
        assertTrue(sor.getLog().contains("Invalid Option"));
    }

    @Test
    public void testMenuDisplay_NotLoggedIn(){
        m.run();
        assertTrue(sor.getLog().contains("Login"));
        assertFalse(sor.getLog().contains("Checkout an Item"));
    }

    @Test
    public void testMenuDisplay_LoggedIn(){
        si.provideLines("1\n000-0000\npassword\n5");
        m.run();
        assertTrue(sor.getLog().contains("Login Successful!"));
        assertTrue(sor.getLog().contains("Checkout an Item"));
    }
}