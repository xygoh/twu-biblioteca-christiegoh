package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.User;
import com.twu.biblioteca.UserManager;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class UserInformationTest {
    private static UserManager uMan;
    private static User u_librarian;
    private static User u_cust1;

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @BeforeClass
    public static void setup(){
        uMan = new UserManager();
        u_librarian = new User("000-0000","password","Mr. Librarian","librarian@bangalorelib.com","0123456789",true);
        u_cust1 = new User("001-0000","ilovedogs","Beatrice Baudelaire", "beatrice@gmail.com","0123456788",false);
        uMan.addUser(u_librarian);
        uMan.addUser(u_cust1);
    }

    @Test
    public void userAccounts_Librarian(){ // list of userAccounts and books borrowed
        uMan.setCurrentUser(u_librarian);
        uMan.displayUserAccounts();
        assertTrue(sor.getLog().contains("Mr. Librarian"));
        assertTrue(sor.getLog().contains("Beatrice Baudelaire"));
    }

    @Test
    public void userAccounts_Customer() {
        uMan.setCurrentUser(u_cust1);
        uMan.displayUserAccounts();
        assertTrue(sor.getLog().contains("Beatrice Baudelaire"));
        assertFalse(sor.getLog().contains("Mr. Librarian"));
    }
}