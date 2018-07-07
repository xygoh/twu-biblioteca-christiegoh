package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.MainMenu;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class ReturnOptionTest {
    static Biblioteca b;
    static MainMenu m;

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @BeforeClass
    public static void setup(){
        b = new Biblioteca();
        b.defaultSetupBooks();
        m = new MainMenu(b);
    }

    @Test
    public void testSuccessfulReturn(){
        si.provideLines("3\n1\nBeing Handsome");
        m.run();
        assertTrue(sor.getLog().contains("Thank you for returning it"));
    }

    @Test
    public void testUnsuccessfulReturn(){
        si.provideLines("3\n1\nTop 10 Clarinet Hits");
        m.run();
        assertTrue(sor.getLog().contains("That is not a valid item"));
    }
}