package org.pdas.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread2 {
    private static final ExecutorService executorService = Executors.newScheduledThreadPool(10);
    public static void main(String[] args) {
        Thread t1 = new Thread(new BeepService(), "t1");
        t1.start();
        //executorService.submit(BeepService);

    }

    static class BeepService implements Runnable{

        @Override
        public void run() {
            System.out.println("BEEP");
        }
    }
}
