package com.chiku.dist.dmsrest.dto;

public class DocumentDto {
    private String user;
    private String screen;


    public DocumentDto(String user, String screen) {
        this.user = user;
        this.screen = screen;
    }

    public String getUser() {
        return user;
    }

    public String getScreen() {
        return screen;
    }

}
