package com.co.indra.coinmarketcap.users.model.entities;

import java.io.Serializable;

public class User implements Serializable {
    private String mail;
    private String username;
    private String displayName;
    private long idCategoryUser;

    public User() {
    }

    public User(String mail, String username, String displayName, long idCategoryUser) {
        this.mail = mail;
        this.username = username;
        this.displayName = displayName;
        this.idCategoryUser = idCategoryUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public long getIdCategoryUser() {
        return idCategoryUser;
    }

    public void setIdCategoryUser(long idCategoryUser) {
        this.idCategoryUser = idCategoryUser;
    }
}
