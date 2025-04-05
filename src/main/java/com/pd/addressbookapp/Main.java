package com.pd.addressbookapp;

import com.pd.addressbookapp.controller.UserController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book App!");
        System.out.println("This is a simple command line application to view users.\n");

        // Initialize and run the UserController
        UserController userController = new UserController();
        userController.run();
    }
}
