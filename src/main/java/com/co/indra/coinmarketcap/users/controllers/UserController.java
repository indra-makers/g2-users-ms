package com.co.indra.coinmarketcap.users.controllers;

import com.co.indra.coinmarketcap.users.config.Routes;
import com.co.indra.coinmarketcap.users.model.entities.User;
import com.co.indra.coinmarketcap.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.USER_RESOURCE)
public class UserController {

    @Autowired
    UserService userService;

    /**
     * localhost:8080/api/users-ms/users
     * POST /users
     * @param user
     * @return 200 OK
     */
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }


}
