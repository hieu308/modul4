package com.example.demo.model;

public class SettingEmail {
    private String language;
    private int page_size;
    private String signature ;

    public SettingEmail() {
    }

    public SettingEmail(String language, int page_size, String signature) {
        this.language = language;
        this.page_size = page_size;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }
}
