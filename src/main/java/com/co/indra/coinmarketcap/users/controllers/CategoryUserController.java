package com.co.indra.coinmarketcap.users.controllers;


import com.co.indra.coinmarketcap.users.config.Routes;
import com.co.indra.coinmarketcap.users.model.entities.CategoryUser;
import com.co.indra.coinmarketcap.users.services.CategoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Routes.CATEGORY_RESOURCE)
public class CategoryUserController {

    @Autowired
    CategoryUserService categoryUserService;

    /**
     * localhost:8080/api/users-ms/categoryUsers
     * GET /categoryUsers
     * @return 200 OK
     */
    @GetMapping
    public List<CategoryUser> showCategory(){
        return categoryUserService.getCategories();
    }
}
