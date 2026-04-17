package org.pdas.arrays.mostAskedProblems;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

public class KnowYourJVM {
    private final static List<byte[]> memoryLeaker = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("ClassLoader for this class is: "+KnowYourJVM.class.getClassLoader().getName());
        System.out.println("ClassLoader for String is "+String.class.getClassLoader());

        Runtime runtime = Runtime.getRuntime();
        for (int i = 0; i < 1000; i++) {
            memoryLeaker.add(new byte[1024*1024]);

        }
        long allocatedMemory = runtime.totalMemory();
        System.out.println("allocatedMemory: "+allocatedMemory/(1024*1024)+" MB");
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        int availableProcessors = runtime.availableProcessors();
        System.out.println("totalMemory "+totalMemory/(1024*1024)+" MB");
        System.out.println("freeMemory "+freeMemory/(1024*1024)+" MB");
        System.out.println("Used Memory "+(totalMemory-freeMemory)/(1024*1024)+" MB");
        System.out.println("Processors: "+availableProcessors);
        jmxPrintHeap();
    }

    private static void jmxPrintHeap(){
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        System.out.println("Initial heap size "+heapUsage.getInit()/(1024*1024) +" MB");
        System.out.println("Used heap size "+heapUsage.getUsed()/(1024*1024) +" MB");
        System.out.println("Max heap size "+heapUsage.getMax()/(1024*1024) +" MB");
    }
}
