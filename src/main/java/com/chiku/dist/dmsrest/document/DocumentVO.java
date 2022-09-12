package com.chiku.dist.dmsrest.document;

class DocumentVO {
    private String user;
    private String screen;


    public DocumentVO(String user, String screen) {
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
