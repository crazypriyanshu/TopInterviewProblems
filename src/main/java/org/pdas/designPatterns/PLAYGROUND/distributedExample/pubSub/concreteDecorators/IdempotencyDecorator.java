package org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub.concreteDecorators;

import org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub.EventPublisher;
import org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub.EventPublisherDecorator;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class IdempotencyDecorator extends EventPublisherDecorator {

    private final Set<String> processedEvent = ConcurrentHashMap.newKeySet();
    public IdempotencyDecorator(EventPublisher delegate){
        super(delegate);
    }

    @Override
    public void publish(String eventId, String payload) {
        if (processedEvent.contains(eventId)){
            System.err.println("[DEDUPLICATION]: Duplicate event blocked -> "+eventId);
            return;
        }
        processedEvent.add(eventId);
        super.publish(eventId, payload);
    }
}
