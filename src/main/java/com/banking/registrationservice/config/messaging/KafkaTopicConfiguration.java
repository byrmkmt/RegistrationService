package com.banking.registrationservice.config.messaging;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public List<NewTopic> topics() {
        return List.of(
                new NewTopic("registration-topic", 2, (short) 1)
        );
    }

}
