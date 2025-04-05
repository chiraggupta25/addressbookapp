package com.pd.addressbookapp.view;



import com.pd.addressbookapp.model.ContactMethod;
import com.pd.addressbookapp.model.Team;
import com.pd.addressbookapp.model.User;

import java.util.List;

public class UserRenderer {

    public static void renderUser(User user) {
        if (user == null) {
            System.out.println("No user information available.");
            return;
        }

        System.out.println("User Details");
        System.out.println("------------");
        System.out.printf("Name : %s%n", safeString(user.getName()));
        System.out.printf("Email: %s%n", safeString(user.getEmail()));
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
            System.out.printf("%-25s %-35s %-10d%n",
                    safeString(user.getName()),
                    safeString(user.getEmail()),
                    user.getTeams() != null ? user.getTeams().size() : 0);
        }
    }

    private static void renderTeams(List<Team> teams) {
        if (teams == null || teams.isEmpty()) {
            System.out.println("No teams associated with this user.");
            return;
        }

        System.out.println("Teams:");
        for (Team team : teams) {
            System.out.println("- " + safeString(team.getSummary()));
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
            System.out.printf("- Type: %s%n", safeString(contact.getType()));
            System.out.printf("  Address: %s%n", safeString(contact.getAddress()));
            System.out.printf("  Summary: %s%n", safeString(contact.getSummary()));
        }
        System.out.println();
    }

    private static String safeString(String value) {
        return value != null ? value : "N/A";
    }
}
