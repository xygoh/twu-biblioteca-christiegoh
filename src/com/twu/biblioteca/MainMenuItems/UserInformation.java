package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.UserManager;

public class UserInformation extends MainMenuItem {
    private UserManager uMan;

    public UserInformation(int index, String name, UserManager uMan) {
        super(index, name);
        this.uMan = uMan;
    }

    @Override
    public void run() {
        uMan.displayUserAccounts();
    }
}
