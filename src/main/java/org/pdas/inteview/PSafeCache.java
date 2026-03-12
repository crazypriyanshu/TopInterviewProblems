package org.pdas.inteview;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class PSafeCache<K, V> {
    private final ConcurrentHashMap<K, CacheEntry<V>> map;
    private final ScheduledExecutorService cleanupExecutor;

    public PSafeCache() {
        this.map = new ConcurrentHashMap<>();
        this.cleanupExecutor = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread();
            thread.setDaemon(true);
            thread.setName("Cleanup thread");
            return thread;
        });
        this.cleanupExecutor.scheduleAtFixedRate(this::cleanup,10, 10, TimeUnit.SECONDS);
    }

    public void cleanup(){
        System.out.println("Running cleanup task");
        map.entrySet().removeIf(entry -> (System.currentTimeMillis() > entry.getValue().expirationTime.get()));
        System.out.println("Task completed");
    }

    public void print(){
        for (Map.Entry<K, CacheEntry<V>> entry: map.entrySet()){
            System.out.println("key: "+entry.getKey()+" :: val: "+entry.getValue().value);
        }
    }




    static class CacheEntry<V> {
        private final V value;
        private final AtomicLong expirationTime;
        CacheEntry(V value, long expirationTime){
            this.value = value;
            this.expirationTime = new AtomicLong(expirationTime);
        }

        public V getValue() {
            return value;
        }

        public AtomicLong getExpirationTime() {
            return expirationTime;
        }
    }

    public void put(K key, V value, long ttlInSecs){
        long expirationTime = System.currentTimeMillis() + (ttlInSecs * 1000);
        CacheEntry<V> newEntry = new CacheEntry<>(value, expirationTime);
        map.put(key, newEntry);

    }

    public int size(){
        return map.size();
    }

    public void shutDown(){
        cleanupExecutor.shutdown();
    }

    public V get(K key){
        CacheEntry<V> entry = map.get(key);
        if (entry == null){
            return null;
        }

        if (System.currentTimeMillis() > entry.expirationTime.get()){
            map.remove(key);
            return null;
        }
        return entry.getValue();
    }

    public void remove(K key){
        map.remove(key);
    }




}
