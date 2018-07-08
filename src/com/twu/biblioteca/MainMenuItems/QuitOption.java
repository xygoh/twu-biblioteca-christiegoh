package com.twu.biblioteca.MainMenuItems;

public class QuitOption extends MainMenuItem {

    public QuitOption(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Good bye...");
        System.exit(0);
    }
}
