package com.co.indra.coinmarketcap.users.repositories;

import com.co.indra.coinmarketcap.users.model.entities.CategoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class CategoryUserRowMapper implements RowMapper <CategoryUser>{

    @Override
    public CategoryUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryUser categoryUser = new CategoryUser();
        categoryUser.setIdCategoryUser(rs.getLong("id_CategoryUser"));
        categoryUser.setNameCategoryUser(rs.getString("nameCategoryUser"));
        return categoryUser;
    }
}


@Repository
public class CategoryUserRepository {

    @Autowired
    private JdbcTemplate template;


    public List<CategoryUser> getCategories(){
        return template.query("SELECT id_categoryUser, nameCategoryUser FROM public.tbl_categoryUsers",
                new CategoryUserRowMapper());
    }
}
