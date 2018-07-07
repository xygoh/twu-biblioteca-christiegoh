package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.Assert.*;

// general tests go here first will get refactored into more appropriate test classes later on.
public class UserStoriesTests {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

// List Movies - As a customer, I would like to see a list of available movies, so that I can browse for a movie that I might check-out. Movies have a name, year, director and movie rating (from 1-10 or unrated).
    @Test
    public void testListMovies(){
        Biblioteca b = new Biblioteca();
        b.defaultSetUpMovies();
        b.listMovies();
        assertTrue(sor.getLog().contains("\n" +
                "Title                                   Director                                Year      Rating    \n" +
                "----------------------------------------------------------------------------------------------------------------------\n" +
                "The Royal Tenenbaums                    Wes Anderson                            1999      7         \n" +
                "Moonrise Kingdom                        Wes Anderson                            2000      8         \n" +
                "----------------------------------------------------------------------------------------------------------------------")); // look for heading also think about putting heading for books
    }

// Check-out Movie - As a customer, I would like to check out a movie from the library, so I can enjoy it at home.
    @Test
    public void checkOutMovieSuccessful(){
        assertTrue(sor.getLog().contains("Successful Checkout"));
    }

    @Test
    public void checkOutMovieUnsuccessful(){
        assertTrue(sor.getLog().contains("Unsuccessful Checkout"));
    }

    @Test
    public void checkInMovieSuccessful(){
        assertTrue(sor.getLog().contains("Thank you for returning the movie"));
    }

    @Test
    public void checkInMovieUnsuccessful(){
        assertTrue(sor.getLog().contains("Unsuccessful return"));
    }

/* User Accounts - Login - As a librarian, I want to know who has checked out a book,
 so that I can hold them accountable for returning it. Users must now login using their library number
 (which is in the format xxx-xxxx) and a password in order to check-out and return books.
 User credentials are predefined, so registering new users is not part of this story.*/
    @Test
    public void userAccountsLibrarian(){ // list of userAccounts and books borrowed
        // login as librarian
        // list books
        assertTrue(sor.getLog().contains("User Accounts"));
    }

    @Test
    public void userLogin(){
        // login
        assertTrue(sor.getLog().contains("Login successful"));
        // assert login == true?
    }
// User Accounts - User information - As a customer, I want to be able to see my user information (name, email address and phone number), so that I know that the library can contact me. This option should only be available when the customer is logged in and should only display that customer’s information.
    @Test
    public void userInformation(){
        assertTrue(sor.getLog().contains("Your User Information"));
    }
}