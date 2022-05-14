package com.co.indra.coinmarketcap.users.model.entities;

import java.io.Serializable;

public class CategoryUser implements Serializable {

    private long idCategoryUser;
    private String nameCategoryUser;


    public CategoryUser() {
    }

    public CategoryUser(long idCategoryUser, String nameCategoryUser) {
        this.idCategoryUser = idCategoryUser;
        this.nameCategoryUser = nameCategoryUser;
    }

    public long getIdCategoryUser() {
        return idCategoryUser;
    }

    public void setIdCategoryUser(long idCategoryUser) {
        this.idCategoryUser = idCategoryUser;
    }

    public String getNameCategoryUser() {
        return nameCategoryUser;
    }

    public void setNameCategoryUser(String nameCategoryUser) {
        this.nameCategoryUser = nameCategoryUser;
    }
}
