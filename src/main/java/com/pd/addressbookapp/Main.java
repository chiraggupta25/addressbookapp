package com.pd.addressbookapp;

import com.pd.addressbookapp.controler.UserControler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book App!");
        System.out.println("This is a simple command line application to view users.\n");

        // Initialize and run the UserController
        UserControler userController = new UserControler();
        userController.run();
    }
}
