package com.pd.addressbookapp.View;

import com.pd.addressbookapp.Models.User;
import com.pd.addressbookapp.Models.ContactMethod;
import com.pd.addressbookapp.Models.Team;

import java.util.List;

public class UserRenderer {

    public static void renderUser(User user) {
        if (user == null) {
            System.out.println("No user information available.");
            return;
        }

        String name = safeString(user.getName());
        String email = safeString(user.getEmail());

        System.out.println("User Details");
        System.out.println("------------");
        System.out.printf("Name : %s%n", name);
        System.out.printf("Email: %s%n", email);
        System.out.println();

        renderTeams(user.getTeams());
        renderContactMethods(user.getContact_methods());
    }

    public static void renderUserList(List<User> users) {
        if (users == null || users.isEmpty()) {
            System.out.println("No users to display.");
            return;
        }

        System.out.printf("%-25s %-35s %-10s%n", "User Name", "Email", "Team Count");
        System.out.println("-----------------------------------------------------------------------");

        for (User user : users) {
            String name = safeString(user.getName());
            String email = safeString(user.getEmail());
            int teamCount = user.getTeams() != null ? user.getTeams().size() : 0;

            System.out.printf("%-25s %-35s %-10d%n", name, email, teamCount);
        }
    }

    private static void renderTeams(List<Team> teams) {
        if (teams == null || teams.isEmpty()) {
            System.out.println("No teams associated with this user.");
            return;
        }

        System.out.println("Teams:");
        for (Team team : teams) {
            System.out.println("- " + safeString(team.toString()));
        }
        System.out.println();
    }

    private static void renderContactMethods(List<ContactMethod> contactMethods) {
        if (contactMethods == null || contactMethods.isEmpty()) {
            System.out.println("No contact methods available.");
            return;
        }

        System.out.println("Contact Methods:");
        for (ContactMethod contact : contactMethods) {
            String type = safeString(contact.getType());
            String summary = safeString(contact.getSummary());
            System.out.printf("- Type: %s%n", type);
            System.out.printf("  Summary: %s%n", summary);
        }
        System.out.println();
    }

    private static String safeString(String value) {
        return value != null ? value : "N/A";
    }
}
