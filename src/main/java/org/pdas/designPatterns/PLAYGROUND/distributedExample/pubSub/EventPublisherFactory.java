package org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub;

import org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub.concreteDecorators.IdempotencyDecorator;
import org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub.concreteDecorators.PIIDecorator;

public class EventPublisherFactory {
    public static EventPublisher createResilientPublisher(boolean isProd){
        EventPublisher eventPublisher = new KafkaEventPublisher();
        if (isProd){
            eventPublisher = new PIIDecorator(eventPublisher);
            eventPublisher = new IdempotencyDecorator(eventPublisher);
        }
        return eventPublisher;
    }
}
