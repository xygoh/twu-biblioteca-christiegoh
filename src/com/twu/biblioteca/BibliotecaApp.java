package com.twu.biblioteca;

public class BibliotecaApp {
    Biblioteca b;
    MainMenu m;
    UserManager userMan;

    public BibliotecaApp() {
        b = new Biblioteca();
        b.defaultSetupBooks();
        b.defaultSetUpMovies();

        userMan = new UserManager();
        userMan.defaultSetupUsers();

        m = new MainMenu(b,userMan);
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
