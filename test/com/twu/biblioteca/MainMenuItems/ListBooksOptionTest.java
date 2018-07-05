package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.MainMenu;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class ListBooksOptionTest {
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
    public void testBooksOnlyAvailableBooksListed(){
        si.provideLines("1");
        m.run();
        assertTrue(sor.getLog().contains("\nTitle                                             Author                                            Year Published\n" +
                "----------------------------------------------------------------------------------------------------------------------\n" +
                "I Heart Dancing                                   Squilliam Fancyson                                1999\n" +
                "Top 10 Oboe Hits                                  Squilliam Fancyson                                2000\n" +
                "----------------------------------------------------------------------------------------------------------------------\n"));
    }
}