package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.UserManager;

public class LogoutOption extends MainMenuItem {
    private UserManager userManager;

    public LogoutOption(int index, String name, UserManager userManager) {
        super(index, name);
        this.userManager = userManager;
    }

    @Override
    public void run() {
        userManager.setCurrentUser(null);
    }
}
