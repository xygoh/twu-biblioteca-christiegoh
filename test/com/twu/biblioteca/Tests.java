package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class Tests {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testWelcomeMessage(){
        BibliotecaApp bApp = new BibliotecaApp();
        BibliotecaApp.main(new String[] {});
        assertTrue(sor.getLog().contains(" ~ Welcome to Biblioteca ~ "));
    }

    @Test
    public void testMainMenu(){
        BibliotecaApp.main(new String[] {});
        assertTrue(sor.getLog().contains("MENU"));
    }

}
