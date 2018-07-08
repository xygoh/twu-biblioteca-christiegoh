package com.twu.biblioteca.MainMenuItems;

abstract public class MainMenuItem {
    private String name;

    public MainMenuItem(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    abstract public void run();
}
