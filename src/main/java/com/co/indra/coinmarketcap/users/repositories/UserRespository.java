package com.co.indra.coinmarketcap.users.repositories;


import com.co.indra.coinmarketcap.users.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public void createUser (User user){
        template.update("INSERT INTO public.tbl_users (mail, username, displayName, id_categoryUser) VALUES (?,?,?,?)",
                user.getMail(), user.getUsername(), user.getDisplayName(), user.getIdCategoryUser());
    }

    public List<User> findUserByMail (String mail){
        return template.query("SELECT mail, username, displayName, id_categoryUser FROM public.tbl_users WHERE mail=?",
                new UserRowMapper(), mail);
    }

    public List<User> findUserByUsername (String username){
        return template.query("SELECT mail, username, displayName, id_categoryUser FROM public.tbl_users WHERE username=?",
                new UserRowMapper(), username);
    }
}
