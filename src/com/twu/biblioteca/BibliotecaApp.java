package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        start(b);
    }

    private static void start(Biblioteca b){
        printWelcomeMessage();
        b.listBooks();
    }

    private static void printWelcomeMessage(){
        System.out.println(" ~ Welcome to Biblioteca ~ ");
    }
}
