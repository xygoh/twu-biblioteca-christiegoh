package com.twu.biblioteca;

public class BibliotecaApp {
    Biblioteca b;
    MainMenu m;

    public BibliotecaApp() {
        b = new Biblioteca();
        b.defaultSetupBooks();
        m = new MainMenu(b);
    }

    private void start(){
        System.out.println(" ~ Welcome to Biblioteca ~ ");
        m.run();
    }

    public static void main(String[] args) {
        BibliotecaApp bApp = new BibliotecaApp();
        bApp.start();
    }
}
