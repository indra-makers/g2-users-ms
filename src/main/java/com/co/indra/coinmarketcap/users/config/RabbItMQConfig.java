package com.co.indra.coinmarketcap.users.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbItMQConfig {

    @Bean
    public Queue testQueue() {
        return new Queue("test_users");
    }
}
