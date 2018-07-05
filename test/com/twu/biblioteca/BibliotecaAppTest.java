package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setup(){
        BibliotecaApp.main(new String[] {});
    }
    @Test
    public void testWelcomeMessage(){
        assertTrue(sor.getLog().contains(" ~ Welcome to Biblioteca ~ "));
    }

    @Test
    public void testMainMenu(){
        assertTrue(sor.getLog().contains("MENU"));
    }
}