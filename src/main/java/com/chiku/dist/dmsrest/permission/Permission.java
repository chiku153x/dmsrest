package com.chiku.dist.dmsrest.permission;

import com.chiku.dist.dmsrest.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String screen;

    private String userName;

    private Boolean active;


    public Permission() {
        super();
    }

    public Permission(Long id, String screen, String userName, Boolean active) {
        this.id = id;
        this.screen = screen;
        this.userName = userName;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", screen='" + screen + '\'' +
                ", userName='" + userName + '\'' +
                ", active=" + active +
                '}';
    }
}
