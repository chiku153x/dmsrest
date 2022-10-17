package com.chiku.dist.dmsrest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {


    //* Folder location for storing files
    private String location = "/home/docs";

    //private String location ="/Users/gchinthaka/Desktop/erp";


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
