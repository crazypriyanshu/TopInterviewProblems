package org.pdas.Threads.CustomThrealPool;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ResilientApiTask implements Runnable{
    private final String url;
    private static final HttpClient client = HttpClient.newHttpClient();

    public ResilientApiTask(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        int attempts = 0;
        int maxAttempt = 3;
        long delay = 1000;

        while (attempts < maxAttempt){
            try {
                executeRequest();
                break;

            } catch (IOException | InterruptedException e) {
                attempts++;
                if (attempts >= maxAttempt){
                    System.out.println("Task failed after "+maxAttempt+" attempts.");
                    return;
                }
                System.out.println("retry attempt: "+attempts+ " for URL: "+url+ " after delay "+ delay+" ms");
                waitForBackOff(delay);
                delay *= 2;
            } catch (Exception e){
                System.err.println("Some fatal error : "+e.getMessage());
                break;
            }
        }
    }

    private void executeRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 500){
            throw new IOException("Server error: "+ response.statusCode());
        }if (response.statusCode() >= 400){
            throw new IOException("Resource not found error: "+ response.statusCode());
        }
        System.out.println("Success: "+response.statusCode()+" from "+url);
    }

    private void waitForBackOff(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
