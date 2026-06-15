package org.pdas.designPatterns.PLAYGROUND.distributedExample.pubSub;

public class Client {
    public static void main(String[] args) {
        EventPublisher pipeLine = EventPublisherFactory.createResilientPublisher(false);
        pipeLine.publish("TXN-1001", "{ 'amount': 50000, 'currency': 'INR' }");
        pipeLine.publish("TXN-1002", "{ 'amount': 30000, 'currency': 'INR' }");
        pipeLine.publish("TXN-1001", "{ 'amount': 50000, 'currency': 'INR' }");
    }
}
