package com.co.indra.coinmarketcap.users.repositories;


import com.co.indra.coinmarketcap.users.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setMail(rs.getString("mail"));
        user.setUsername(rs.getString("username"));
        user.setDisplayName(rs.getString("displayName"));
        user.setIdCategoryUser(rs.getLong("id_categoryUser"));
        return user;
    }
}

@Repository
public class UserRespository {

    @Autowired
    private JdbcTemplate template;
}
