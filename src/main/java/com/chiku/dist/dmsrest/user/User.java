package com.chiku.dist.dmsrest.user;

import javax.persistence.*;

@Entity
@Table
public class User {
    @javax.persistence.Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_sequence")
    private Long Id;

    private Long userId;
    private String userName;
    private String email;
    private String password;

    private Boolean active;


    public User() {
        super();
    }

    public User(Long id, Long userId, String userName, String email, String password, Boolean active) {
        Id = id;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }



    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
