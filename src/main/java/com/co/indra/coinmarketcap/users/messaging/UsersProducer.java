package com.co.indra.coinmarketcap.users.messaging;

import com.co.indra.coinmarketcap.users.model.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendUser(User user) {
        try {
            String message = objectMapper.writeValueAsString(user);
            rabbitTemplate.convertAndSend("test_measures", message);
        } catch (JsonProcessingException exc) {
            exc.printStackTrace();
        }
    }
}
