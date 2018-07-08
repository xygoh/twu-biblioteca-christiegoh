package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.MainMenu;
import com.twu.biblioteca.UserManager;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class CheckOutOptionTest {
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
        b.defaultSetupBooks();
        b.defaultSetUpMovies();

        userMan = new UserManager();
        userMan.defaultSetupUsers();

        m = new MainMenu(b,userMan);
    }

    @Test
    public void testCheckoutBookSuccessful() {
        si.provideLines("1\n001-0000\nilovedogs\n2\n1\nI Heart Dancing");
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