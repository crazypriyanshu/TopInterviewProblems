package org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub;
// core interface
public interface EventPublisher {
    void publish(String eventId, String payload);
}
