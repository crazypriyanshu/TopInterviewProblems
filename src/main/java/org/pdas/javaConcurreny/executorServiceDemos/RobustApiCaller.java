package org.pdas.javaConcurreny.executorServiceDemos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class RobustApiCaller {
    private static final Duration defaultTimeOutDuration = Duration.of(4, ChronoUnit.SECONDS);
    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(defaultTimeOutDuration)
            .build();

    private static final RetryUtils.RetryConfig retryConfig = new RetryUtils.RetryConfig.Builder()
            .setBaseDelay(Duration.of(150, ChronoUnit.MILLIS))
            .setMaxDelay(Duration.ofSeconds(3))
            .setMaxAttempts(3)
            .setMaxDuration(5)
            .setRetryable(Set.of(IOException.class, InterruptedException.class, RuntimeException.class))
            .build();

    public static void main(String[] args) {
        System.out.println("Starting RobustApiCaller");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(RetryUtils.api1))
                .GET()
                .build();
        try {
            HttpResponse<String> response = executeCall(request, retryConfig);
            System.out.printf("Success: Response from = "+response.body().toString());
            System.out.println("Success! Response status: " + response.statusCode());
        } catch (Exception e) {
            System.out.printf("Failed! because of : "+e.getMessage());
        }

    }

    private static HttpResponse<String> executeCall(HttpRequest request, RetryUtils.RetryConfig config){
        try {
            HttpResponse<String> response = RetryUtils.executeWithRetry(() -> {
                try {
                    HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
                    if (res.statusCode() >= 500){
                        throw new RuntimeException("Server returned status code: " + res.statusCode());
                    }
                    return res;

                } catch (InterruptedException | IOException exception) {
                    System.out.println("Transient network failure detected. Signaling retry engine...");
                    throw new RuntimeException("Wrapped transient failures: "+exception.getMessage());
                }
            }, config);
            return response;

        } catch (Exception e) {
            // System.out.println(""); - explain why this line gives me compilation error
            throw new RuntimeException("Completely failed after exhausting all retry configs: "+e.getMessage()); // why is this okay ?

        }

    }
}
