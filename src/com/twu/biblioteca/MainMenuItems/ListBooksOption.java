package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;

public class ListBooksOption extends MainMenuItem {
    private Biblioteca biblioteca;

    public ListBooksOption(int index, String name,Biblioteca biblioteca){
        super(index,name);
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        biblioteca.listBooks();
    }
}
