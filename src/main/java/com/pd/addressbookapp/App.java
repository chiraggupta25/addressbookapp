package com.pd.addressbookapp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.addressbookapp.Models.ApiResponse;
import com.pd.addressbookapp.Models.User;
import com.pd.addressbookapp.Utils.AppConfig;
import com.pd.addressbookapp.Utils.Utils;
import com.pd.addressbookapp.View.UserRenderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private static final ObjectMapper mapper = createMapper();

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book App!");
        System.out.println("This is a simple command line application to view users.\n");

        AppConfig config = new AppConfig();
        String url = config.getProperty("pd.endpoint");
        String token = config.getProperty("pd.token");
        boolean userCount = Boolean.parseBoolean(config.getProperty("pd.total"));
        int pageSize = Integer.parseInt(config.getProperty("pd.limit"));
        int pageIndex = Integer.parseInt(config.getProperty("pd.offset"));

        runUserInteractionLoop(url, token, userCount, pageSize, pageIndex);
    }

    private static void runUserInteractionLoop(String url, String token, boolean userCount, int pageSize, int pageIndex) {
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
                    if (pageIndex > 0) {
                        pageIndex--;
                    } else {
                        System.out.println("Already on the first page.");
                    }
                } else if (!input.trim().isEmpty()) {
                    displayUsers(url, token, false, 0, 0, input);
                    System.out.print("\nPress Enter to return...");
                    reader.readLine();
                } else {
                    System.out.println("Invalid command. Please try again.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void displayUsers(String url, String token, boolean userCount, int pageSize, int pageIndex, String query) {
        try {
            String response = Utils.get(url, token, query, userCount, pageSize, pageIndex);
            ApiResponse apiResponse = mapper.readValue(response, ApiResponse.class);

            if (query != null && !query.isEmpty()) {
                for (User user : apiResponse.getUsers()) {
                    UserRenderer.renderUser(user);
                }
            } else {
                UserRenderer.renderUserList(apiResponse.getUsers());
            }

            System.out.printf("Total Users: %d | Page Size: %d | Page Index: %d | More: %b%n",
                    apiResponse.getTotal(),
                    apiResponse.getLimit(),
                    apiResponse.getOffset(),
                    apiResponse.isMore());

        } catch (IllegalArgumentException e) {
            System.err.println("Configuration error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("API request failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }
}
