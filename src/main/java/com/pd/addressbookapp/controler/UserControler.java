package com.pd.addressbookapp.controler;

import com.pd.addressbookapp.model.ApiResponse;
import com.pd.addressbookapp.service.UserService;
import com.pd.addressbookapp.view.UserRenderer;
import com.pd.addressbookapp.util.AppConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserControler {

    private final AppConfig config = new AppConfig();
    private final UserService userService = new UserService();

    public void run() {
        String url = config.getProperty("pd.endpoint");
        String token = config.getProperty("pd.token");
        boolean userCount = Boolean.parseBoolean(config.getProperty("pd.total"));
        int pageSize = Integer.parseInt(config.getProperty("pd.limit"));
        int pageIndex = Integer.parseInt(config.getProperty("pd.offset"));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (true) {
                displayUsers(url, token, userCount, pageSize, pageIndex, null);

                System.out.println("\nCommands:");
                System.out.println(" - N: Next page");
                System.out.println(" - P: Previous page");
                System.out.println(" - E: Exit");
                System.out.println(" - Or enter a name to search:");
                System.out.print("Enter command: ");

                input = reader.readLine();
                if (input == null || input.equalsIgnoreCase("e") || input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting application...");
                    break;
                } else if (input.equalsIgnoreCase("n")) {
                    pageIndex++;
                } else if (input.equalsIgnoreCase("p")) {
                    if (pageIndex > 0) pageIndex--;
                } else if (!input.trim().isEmpty()) {
                    displayUsers(url, token, false, 0, 0, input);
                    System.out.print("\nPress Enter to return...");
                    reader.readLine();
                } else {
                    System.out.println("Invalid command. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void displayUsers(String url, String token, boolean userCount, int pageSize, int pageIndex, String query) {
        try {
            ApiResponse response = userService.fetchUsers(url, token, query, userCount, pageSize, pageIndex);
            if (query != null && !query.isEmpty()) {
                response.getUsers().forEach(user -> {
                    userService.enrichUserContactMethods(user, token);
                    UserRenderer.renderUser(user);
                });
            } else {
                UserRenderer.renderUserList(response.getUsers());
            }
            System.out.printf("Total Users: %d | Page Size: %d | Page Index: %d | More: %b%n",
                    response.getTotal(), response.getLimit(), response.getOffset(), response.isMore());
        } catch (Exception e) {
            System.err.println("Unable to fetch users: " + e.getMessage());
        }
    }
}
