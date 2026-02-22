package org.pdas.LLD.InterceptorsWithGateLevelValidation.Interceptor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MetricsCollector {
    private final AtomicLong totalRequests = new AtomicLong();
    private final AtomicLong failedRequests = new AtomicLong();
    private final Map<String, List<Long>> gateDurations = new ConcurrentHashMap<>();

    public void record(String requestId, boolean success, long duration){
        totalRequests.incrementAndGet();
        if (!success){
            failedRequests.incrementAndGet();
        }
    }

    public void recordGates(String gateName, long duration){
        gateDurations.computeIfAbsent(gateName, k -> new ArrayList<>()).add(duration);
    }

    public Map<String, Object> getMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("totalRequests", totalRequests.get());
        metrics.put("failedRequests", failedRequests.get());
        metrics.put("successRate", totalRequests.get() > 0 ? (double) ((totalRequests.get() - failedRequests.get()))/ totalRequests.get() : 0);
        return metrics;
    }
}
