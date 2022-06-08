package com.co.indra.coinmarketcap.users.controllers;

import com.co.indra.coinmarketcap.users.config.Routes;
import com.co.indra.coinmarketcap.users.model.entities.User;
import com.co.indra.coinmarketcap.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

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

    /**
     * localhost:8080/api/users-ms/users/{username}
     * GET /users/{username}
     * @param username
     * @return 200 OK
     */
    @GetMapping(Routes.USERNAME_PATH)
    @Cacheable(value = "findUser", cacheManager = "expire30Mins", key = "{#username}", unless = "#result == null")
    public User findUser(@PathVariable("username") String username){
        return userService.findUser(username);
    }
}
