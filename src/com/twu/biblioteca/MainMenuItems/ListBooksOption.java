package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;

public class ListBooksOption extends MainMenuItem {

    public ListBooksOption(int index, String name,Biblioteca biblioteca){
        super(index,name,biblioteca);
    }

    @Override
    public void run() {
        biblioteca.listBooks();
    }
}
