package com.chiku.dist.dmsrest.document;

class DocumentVO {
    private String user;
    private String screen;
    private String instance;

    public DocumentVO(String user, String screen, String instance) {
        this.user = user;
        this.screen = screen;
        this.instance = instance;
    }

    public String getUser() {
        return user;
    }

    public String getScreen() {
        return screen;
    }

    public String getInstance() {
        return instance;
    }
}
