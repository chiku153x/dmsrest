package com.chiku.dist.dmsrest.dto;

public class CredentialDto {
    private String userName;
    private String password;

    public CredentialDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
