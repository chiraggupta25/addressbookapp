package com.pd.addressbookapp;

import com.pd.addressbookapp.controller.UserController;

public class Main {
    public static void main(String[] args) {
        // Initialize and run the UserController
        UserController userController = new UserController();
        userController.run();
    }
}
