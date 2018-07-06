package com.twu.biblioteca.MainMenuItems;

import org.junit.Test;
import org.junit.Rule;

import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitOptionTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testQuitWhenRun(){
        QuitOption q = new QuitOption(1,"Quit");
        exit.expectSystemExitWithStatus(0);
        q.run();
    }
}