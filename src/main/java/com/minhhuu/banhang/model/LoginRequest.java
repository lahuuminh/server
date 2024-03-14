package com.minhhuu.banhang.model;

public class LoginRequest {
    private String accountname;

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public LoginRequest() {
    }

    public LoginRequest(String accountname) {
        this.accountname = accountname;
    }
}
