package org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub;

public abstract class EventPublisherDecorator implements EventPublisher{
    protected final EventPublisher delegate;

    protected EventPublisherDecorator(EventPublisher delegate){
        this.delegate = delegate;
    }

    @Override
    public void publish(String eventId, String payload){
        this.delegate.publish(eventId, payload);
    }
}
