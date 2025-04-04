package com.pd.addressbookapp.Models;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String time_zone;
    private String color;
    private boolean billed;
    private String role;
    private boolean invitation_sent;
    private String id;
    private String type;
    private String summary;
    private String self;
    private String html_url;
    private String avatar_url;

    private List<Team> teams;
    private List<ContactMethod> contact_methods;
    private List<NotificationRule> notification_rules;

    public User() {
    }


    public User(String name, String email, String time_zone, String color, boolean billed, String role,
                boolean invitation_sent, String id, String type, String summary, String self, String html_url,
                List<Team> teams, List<ContactMethod> contact_methods, List<NotificationRule> notification_rules, String avatar_url) {
        this.name = name;
        this.email = email;
        this.time_zone = time_zone;
        this.color = color;
        this.billed = billed;
        this.role = role;
        this.invitation_sent = invitation_sent;
        this.id = id;
        this.type = type;
        this.summary = summary;
        this.self = self;
        this.html_url = html_url;
        this.teams = teams;
        this.contact_methods = contact_methods;
        this.notification_rules = notification_rules;
        this.avatar_url = avatar_url;
        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTime_zone() {
        return time_zone;
    }
    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isBilled() {
        return billed;
    }
    public void setBilled(boolean billed) {
        this.billed = billed;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isInvitation_sent() {
        return invitation_sent;
    }
    public void setInvitation_sent(boolean invitation_sent) {
        this.invitation_sent = invitation_sent;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getSelf() {
        return self;
    }
    public void setSelf(String self) {
        this.self = self;
    }
    public String getHtml_url() {
        return html_url;
    }
    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
    public List<Team> getTeams() {
        return teams;
    }
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    public List<ContactMethod> getContact_methods() {
        return contact_methods;
    }
    public void setContact_methods(List<ContactMethod> contact_methods) {
        this.contact_methods = contact_methods;
    }
    public List<NotificationRule> getNotification_rules() {
        return notification_rules;
    }
    public void setNotification_rules(List<NotificationRule> notification_rules) {
        this.notification_rules = notification_rules;
    }
    public String getAvatar_url() {
        return avatar_url;
    }
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
