package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.UserManager;

public class UserInformation extends MainMenuItem {
    private UserManager uMan;

    public UserInformation(String name, UserManager uMan) {
        super(name);
        this.uMan = uMan;
    }

    @Override
    public void run() {
        uMan.displayUserAccounts();
    }
}
