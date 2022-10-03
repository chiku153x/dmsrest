package com.chiku.dist.dmsrest.security;

public class LoginDto {
    private String userName;
    private String Password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public LoginDto(String userName, String password) {
        this.userName = userName;
        Password = password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "userName='" + userName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
