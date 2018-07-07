package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.MainMenu;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class ListBooksOptionTest {
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
    public void testBooksOnlyAvailableBooksListed(){
        si.provideLines("1\n1");
        m.run();
        assertTrue(sor.getLog().contains("\nTitle                                             Author                                            Year Published\n" +
                "----------------------------------------------------------------------------------------------------------------------\n" +
                "I Heart Dancing                                   Squilliam Fancyson                                1999\n" +
                "Top 10 Oboe Hits                                  Squilliam Fancyson                                2000\n" +
                "----------------------------------------------------------------------------------------------------------------------\n"));
    }

    // List Movies - As a customer, I would like to see a list of available movies, so that I can browse for a movie that I might check-out. Movies have a name, year, director and movie rating (from 1-10 or unrated).
    @Test
    public void testListMovies(){
        si.provideLines("1\n2");
        m.run();
        assertTrue(sor.getLog().contains("\n" +
                "Title                                   Director                                Year      Rating    \n" +
                "----------------------------------------------------------------------------------------------------------------------\n" +
                "The Royal Tenenbaums                    Wes Anderson                            1999      7         \n" +
                "Moonrise Kingdom                        Wes Anderson                            2000      8         \n" +
                "----------------------------------------------------------------------------------------------------------------------")); // look for heading also think about putting heading for books
    }
}