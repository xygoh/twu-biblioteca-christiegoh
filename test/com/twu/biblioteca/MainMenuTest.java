package com.twu.biblioteca;

import com.sun.tools.javac.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class MainMenuTest {
    Biblioteca b = new Biblioteca();
    MainMenu m = new MainMenu(b);

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testMenuListsOptionsWhenRun() {
        m.run();
        assertTrue(sor.getLog().contains("MAIN MENU\n" + "--------------------\n" + " 1. List Books\n"));
    }

    @Test
    public void testInvalidMenuOption(){
        si.provideLines("100");
        m.run();
        assertTrue(sor.getLog().contains("Invalid Option"));
    }
}