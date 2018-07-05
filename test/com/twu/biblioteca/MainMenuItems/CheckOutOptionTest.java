package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.MainMenu;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class CheckOutOptionTest {
    Biblioteca b;
    MainMenu m;

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setup(){
        b = new Biblioteca();
        b.defaultSetupBooks();
        m = new MainMenu(b);
    }

    @Test
    public void testCheckoutSuccessful() {
        si.provideLines("3\nI Heart Dancing");
        m.run();
        assertTrue(sor.getLog().contains("Thank you! Enjoy your book"));
    }

    @Test
    public void testCheckOutUnsuccessfulBookNotListedInBookList(){
        si.provideLines("3\nNo, this is Patrick");
        m.run();
        assertTrue(sor.getLog().contains("Unsuccessful Checkout"));
    }

    @Test
    public void testCheckOutUnsuccessfulBookUnavailable(){
        si.provideLines("3\nI Heart Dancing");
        m.run();
        assertTrue(sor.getLog().contains("Unsuccessful Checkout"));
    }
}