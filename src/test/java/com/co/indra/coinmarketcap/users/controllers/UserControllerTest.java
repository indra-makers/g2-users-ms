package com.co.indra.coinmarketcap.users.controllers;

import com.co.indra.coinmarketcap.users.config.Routes;
import com.co.indra.coinmarketcap.users.model.entities.User;
import com.co.indra.coinmarketcap.users.model.responses.ErrorResponse;
import com.co.indra.coinmarketcap.users.repositories.UserRespository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {

    @Autowired
    UserRespository userRespository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUserHappy() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(Routes.USER_RESOURCE)
                .content("{\n" +
                        "    \"mail\": \"angie.gomez@ucp.edu.co\",\n" +
                        "    \"username\": \"angi3.gom3z\",\n" +
                        "    \"displayName\": \"Angicita\",\n" +
                        "    \"idCategoryUser\": 1\n" +
                        "}").contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200, response.getStatus());

        List<User> user = userRespository.findUserByMail("angie.gomez@ucp.edu.co");
        Assertions.assertEquals(1, user.size());

    }

    @Test
    @Sql("/testdata/createUser.sql")
    public void createUserWithMailAlreadyExist() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(Routes.USER_RESOURCE)
                .content("{\n" +
                        "    \"mail\": \"romeo.santos@gmail.com\",\n" +
                        "    \"username\": \"rodriguez\",\n" +
                        "    \"displayName\": \"romeo rodriguez santos\",\n" +
                        "    \"idCategoryUser\": 1\n" +
                        "}").contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412, response.getStatus());

        String textResponse = response.getContentAsString();
        ErrorResponse error = objectMapper.readValue(textResponse, ErrorResponse.class);
        Assertions.assertEquals("001", error.getCode());

    }

    @Test
    @Sql("/testdata/createUser.sql")
    public void createUserWithUsernameAlreadyExist() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(Routes.USER_RESOURCE)
                .content("{\n" +
                        "    \"mail\": \"romeo@gmail.com\",\n" +
                        "    \"username\": \"romeito\",\n" +
                        "    \"displayName\": \"romeo rodriguez santos\",\n" +
                        "    \"idCategoryUser\": 1\n" +
                        "}").contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412, response.getStatus());

        String textResponse = response.getContentAsString();
        ErrorResponse error = objectMapper.readValue(textResponse, ErrorResponse.class);
        Assertions.assertEquals("002", error.getCode());

    }
}
