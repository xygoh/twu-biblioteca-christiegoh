package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.UserManager;

public class LogoutOption extends MainMenuItem {
    private UserManager userManager;

    public LogoutOption(String name, UserManager userManager) {
        super(name);
        this.userManager = userManager;
    }

    @Override
    public void run() {
        userManager.setCurrentUser(null);
    }
}
