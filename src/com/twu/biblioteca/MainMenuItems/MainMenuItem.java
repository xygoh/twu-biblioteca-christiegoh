package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;

abstract public class MainMenuItem {
    private int index;
    private String name;
    protected Biblioteca biblioteca;


    public MainMenuItem(int index, String name, Biblioteca b) {
        this.index = index-1;
        this.name = name;
        this.biblioteca = b;
    }

    public String getName(){
        return name;
    }

    public int getIndex(){
        return index;
    }

    abstract public void run();
}
