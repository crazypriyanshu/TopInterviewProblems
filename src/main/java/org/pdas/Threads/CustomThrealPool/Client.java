package org.pdas.Threads.CustomThrealPool;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool customThreadPool = new CustomThreadPool(3, 5);
        String endpoint = "https://jsonplaceholder.typicode.com/postss/1";

        System.out.println("Starting API executor... ");
        for (int i=0; i < 20; i++){
            customThreadPool.execute(new ResilientApiTask(endpoint));
        }
        Thread.sleep(10000);
        System.out.println("Stopping executor...");
        customThreadPool.stop();

    }
}
