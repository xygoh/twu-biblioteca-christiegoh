package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;

public class QuitOption extends MainMenuItem {

    public QuitOption(int index, String name) {
        super(index, name);
    }

    @Override
    public void run() {
        System.out.println("Good bye...");
        System.exit(0);
    }
}
