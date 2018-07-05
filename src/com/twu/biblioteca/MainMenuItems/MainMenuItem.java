package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;

abstract public class MainMenuItem {
    private int index;
    private String name;

    public MainMenuItem(int index, String name) {
        this.index = index-1;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getIndex(){
        return index;
    }

    abstract public void run();
}
