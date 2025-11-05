package com.banking.registrationservice.event.publisher;

import com.banking.registrationservice.event.model.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
