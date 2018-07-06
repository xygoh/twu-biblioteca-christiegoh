package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.MainMenu;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class CheckOutOptionTest {
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
    public void testCheckoutSuccessful() {
        si.provideLines("2\nI Heart Dancing");
        m.run();
        assertTrue(sor.getLog().contains("Thank you! Enjoy your book"));
    }

    @Test
    public void testCheckOutUnsuccessfulBookNotListedInBookList(){
        si.provideLines("2\nNo, this is Patrick");
        m.run();
        assertTrue(sor.getLog().contains("Unsuccessful Checkout. Book does not exist in our system"));
    }

    @Test
    public void testCheckOutUnsuccessfulBookUnavailable(){
        si.provideLines("2\nBeing Handsome");
        m.run();
        assertTrue(sor.getLog().contains("Unsuccessful Checkout. Book not available"));
    }
}