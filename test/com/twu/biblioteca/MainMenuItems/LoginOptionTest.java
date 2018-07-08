package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.MainMenu;
import com.twu.biblioteca.User;
import com.twu.biblioteca.UserManager;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class LoginOptionTest {
    private static UserManager uMan;
    private static MainMenuItem loginOp;

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

    @BeforeClass
    public static void setup(){
        uMan = new UserManager();
        User u_librarian = new User("000-0000","password","Mr. Librarian","librarian@bangalorelib.com","0123456789",true);
        User u_cust1 = new User("001-0000","ilovedogs","Beatrice Baudelaire", "beatrice@gmail.com","0123456788",false);
        uMan.addUser(u_librarian);
        uMan.addUser(u_cust1);
        loginOp = new LoginOption(1,"Login",uMan);
    }

    @Test
    public void userLoginSuccessful(){
        si.provideLines("000-0000\npassword");
        loginOp.run();
        assertTrue(sor.getLog().contains("Login Successful"));
    }

    @Test
    public void userLoginNotSuccessfulUserDoesntExist(){
        si.provideLines("000\npassword");
        loginOp.run();
        assertTrue(sor.getLog().contains("User doesn't exist in our system"));
    }

    @Test
    public void userLoginNotSuccessfulPasswordDoesntMatch(){
        si.provideLines("001-0000\nilovecats");
        loginOp.run();
        assertTrue(sor.getLog().contains("Password doesn't match"));
    }

}