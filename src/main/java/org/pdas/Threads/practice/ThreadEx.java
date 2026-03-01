package org.pdas.Threads.practice;

import java.util.ArrayList;
import java.util.List;

public class ThreadEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Check jconsole");
        Thread.sleep(1000);
        List<String> leak = new ArrayList<>();
        while (true){
            String s = "Very Long String that keeps growing... "+System.nanoTime();
            leak.add(s.substring(0, 5));
            if (leak.size() > 10000) leak.clear();
            Thread.sleep(1);
        }
    }
}
