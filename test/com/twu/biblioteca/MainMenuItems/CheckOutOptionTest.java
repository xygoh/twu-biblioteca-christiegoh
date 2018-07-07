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
        b.defaultSetUpMovies();
        m = new MainMenu(b);
    }

    @Test
    public void testCheckoutBookSuccessful() {
        si.provideLines("2\n1\nI Heart Dancing");
        m.run();
        assertTrue(sor.getLog().contains("Thank you! Enjoy"));
    }

    @Test
    public void testCheckOutUnsuccessfulBookNotListedInBookList(){
        si.provideLines("2\n1\nNo, this is Patrick");
        m.run();
        assertTrue(sor.getLog().contains("Unsuccessful Checkout. Item does not exist in our system"));
    }

    @Test
    public void testCheckOutUnsuccessfulBookUnavailable(){
        si.provideLines("2\n1\nBeing Handsome");
        m.run();
        assertTrue(sor.getLog().contains("Unsuccessful Checkout. Item not available"));
    }

    @Test
    public void checkOutMovieSuccessful(){
        si.provideLines("2\n2\nMoonrise Kingdom");
        m.run();
        assertTrue(sor.getLog().contains("Thank you! Enjoy"));
    }

    @Test
    public void checkOutMovieUnsuccessfulDoesNotExist(){
        si.provideLines("2\n2\nSunrise Kingdom");
        m.run();
        assertTrue(sor.getLog().contains("Unsuccessful Checkout"));
    }

    @Test
    public void checkOutMovieUnsuccessfulNotAvailable(){
        si.provideLines("2\n2\nShopping List");
        m.run();
        assertTrue(sor.getLog().contains("Unsuccessful Checkout"));
    }
}