package com.chiku.dist.dmsrest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Login {
    @javax.persistence.Id
    @SequenceGenerator(name = "login_sequence", sequenceName = "login_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "login_sequence")
    private Long Id;

    private String user;
    private String token;
    private Date createdOn;

    public Login() {
        super();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Login(Long id, String user, String token, Date createdOn) {
        Id = id;
        this.user = user;
        this.token = token;
        this.createdOn = createdOn;
    }
}
