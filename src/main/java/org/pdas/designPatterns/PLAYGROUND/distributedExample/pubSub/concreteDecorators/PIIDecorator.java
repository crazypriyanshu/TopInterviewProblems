package org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub.concreteDecorators;

import org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub.EventPublisher;
import org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub.EventPublisherDecorator;

import java.util.Base64;

public class PIIDecorator extends EventPublisherDecorator {
    public PIIDecorator(EventPublisher delegate) {
        super(delegate);
    }

    @Override
    public void publish(String eventId, String payload) {
        String encryptedPayload = Base64.getEncoder().encodeToString(payload.getBytes());
        System.out.println("[PII] - Encrypted raw payload Base64 encoding");
        super.publish(eventId, payload);
    }
}
