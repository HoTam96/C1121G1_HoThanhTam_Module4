package com.email.model;

public class Email {
    private String language;
    private Integer pageSize;
    private boolean spams;
    private String sign;

    public Email(String language, Integer pageSize, boolean spams, String sign) {
        this.language = language;
        this.pageSize = pageSize;
        this.spams = spams;
        this.sign = sign;
    }

    public Email() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
