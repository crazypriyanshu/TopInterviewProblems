package org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub;

public class KafkaEventPublisher implements EventPublisher{
    @Override
    public void publish(String eventId, String payload) {
        System.out.println("[KAFKA WRITE] Pushed message to cluster -> id: "+eventId);
    }
}
