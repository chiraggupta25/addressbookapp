package com.pd.addressbookapp.Models;

public class ContactMethod {
    private String id;
    private String type;
    private String summary;
    private String self;
    private String html_url;
    private String label;
    private String address;
    private String blacklisted;
    private int country_code;
    private boolean enabled;
    private boolean send_short_email;
    private boolean send_html_email;

    public ContactMethod() {
    }
    
    public ContactMethod(String id, String type, String summary, String self, String html_url, String label, String address, String blacklisted, int country_code, boolean enabled, boolean send_short_email, boolean send_html_email) {
        this.id = id;
        this.type = type;
        this.summary = summary;
        this.self = self;
        this.html_url = html_url;
        this.label = label;
        this.address = address;
        this.blacklisted = blacklisted;
        this.country_code = country_code;
        this.enabled = enabled;
        this.send_short_email = send_short_email;
        this.send_html_email = send_html_email;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getBlacklisted() {
        return blacklisted;
    }
    public void setBlacklisted(String blacklisted) {
        this.blacklisted = blacklisted;
    }
    public int getCountry_code() {
        return country_code;
    }
    public void setCountry_code(int country_code) {
        this.country_code = country_code;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public boolean isSend_short_email() {
        return send_short_email;
    }
    public void setSend_short_email(boolean send_short_email) {
        this.send_short_email = send_short_email;
    }
    public boolean isSend_html_email() {
        return send_html_email;
    }
    public void setSend_html_email(boolean send_html_email) {
        this.send_html_email = send_html_email;
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
