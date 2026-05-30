package org.pdas.popularInterview.StreamCoolExamples;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * You are reading millions of tracking IDs from a database,
 * and you need to push them to an external vendor API or a Kafka stream.
 * However, the external service limits requests to a maximum batch size of 3 records per payload call.
 * You need to chunk a continuous stream into small, fixed-size batches dynamically.
 * */
public class BatchEngine {

    public static <T> Collection<List<T>> chunkStream(List<T> resourceList, int batchSize){
        final AtomicInteger counter = new AtomicInteger(100);
        return resourceList.stream()
                .collect(Collectors.groupingBy(
                        item -> counter.getAndIncrement()/batchSize
                ))
                .values();
    }
}
