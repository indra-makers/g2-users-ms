package com.co.indra.coinmarketcap.users.controllers;

import com.co.indra.coinmarketcap.users.config.Routes;
import com.co.indra.coinmarketcap.users.model.entities.CategoryUser;
import com.co.indra.coinmarketcap.users.model.entities.User;
import com.co.indra.coinmarketcap.users.repositories.CategoryUserRepository;
import com.co.indra.coinmarketcap.users.repositories.UserRespository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CategoryUserControllerTest {

    @Autowired
    CategoryUserRepository categoryUserRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void showAllCategoryUserHappy() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.GET_CATEGORY_USER)
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200, response.getStatus());

        CategoryUser[] categoryUser = objectMapper.readValue(response.getContentAsString(),CategoryUser[].class);
        Assertions.assertEquals(3, categoryUser.length);
    }
}
