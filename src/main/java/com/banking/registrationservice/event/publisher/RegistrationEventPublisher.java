package com.banking.registrationservice.event.publisher;
import com.banking.registrationservice.event.model.DomainEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RegistrationEventPublisher implements DomainEventPublisher {

    private final KafkaTemplate<String, DomainEvent> kafkaTemplate;

    public RegistrationEventPublisher(KafkaTemplate<String, DomainEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(DomainEvent event) {
        kafkaTemplate.send("registration-topic", event);
    }
}