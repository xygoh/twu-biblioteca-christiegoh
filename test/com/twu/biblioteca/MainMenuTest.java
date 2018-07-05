package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Rule;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class MainMenuTest {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    public void testMenuListsOptionsWhenRun() {
        Biblioteca b = new Biblioteca();
        MainMenu m = new MainMenu(b);
        m.run();
        assertTrue(sor.getLog().contains("MAIN MENU\n" + "--------------------\n" + " 1. List Books\n"));
    }
}