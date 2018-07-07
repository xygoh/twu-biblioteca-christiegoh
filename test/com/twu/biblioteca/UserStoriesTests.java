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