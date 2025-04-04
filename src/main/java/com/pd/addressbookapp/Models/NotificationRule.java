package com.pd.addressbookapp.Models;

public class NotificationRule {
    private String id;
    private String type;
    private String summary;
    private String self;
    private String html_url;

    public NotificationRule() {
    }

    public NotificationRule(String id, String type, String summary, String self, String html_url) {
        this.id = id;
        this.type = type;
        this.summary = summary;
        this.self = self;
        this.html_url = html_url;
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
}
