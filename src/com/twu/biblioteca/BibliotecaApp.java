package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        MainMenu m = new MainMenu(b);
        start(b,m);
    }

    private static void start(Biblioteca b, MainMenu m){
        printWelcomeMessage();
        b.listBooks();
        //m.listOptions();
        m.run();
    }

    private static void printWelcomeMessage(){
        System.out.println(" ~ Welcome to Biblioteca ~ ");
        System.out.println("");
    }
}
