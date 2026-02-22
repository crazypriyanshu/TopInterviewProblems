package org.pdas.LLD.InterceptorsWithGateLevelValidation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Request Context - Contains all request information
public class RequestContext {
    private final String requestId;
    private final String path;
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, Object> attributes;
    private final Object body;
    private final Map<String, Object> pathVariables;
    private final Map<String, String[]> queryParams;

    private RequestContext(Builder builder){
        this.requestId = builder.requestId;
        this.path = builder.path;
        this.method = builder.method;
        this.headers = Collections.unmodifiableMap(builder.headers);
        this.attributes = new ConcurrentHashMap<>(builder.attributes);
        this.body = builder.body;
        this.pathVariables = Collections.unmodifiableMap(builder.pathVariables);
        this.queryParams = Collections.unmodifiableMap(builder.queryParams);

    }

    public String getRequestId() {
        return requestId;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public Object getBody() {
        return body;
    }

    public Map<String, Object> getPathVariables() {
        return pathVariables;
    }

    public Map<String, String[]> getQueryParams() {
        return queryParams;
    }

    public static class Builder{
        private String requestId;
        private String path;
        private String method;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, Object> attributes = new HashMap<>();
        private Object body;
        private Map<String, Object> pathVariables = new HashMap<>();
        private Map<String, String[]> queryParams = new HashMap<>();

        public Builder requestId(String requestId){
            this.requestId = requestId;
            return this;
        }

        public Builder path(String path){
            this.path = path;
            return this;
        }

        public Builder method(String method){
            this.method = method;
            return this;
        }

        public Builder header(String key, String value){
            this.headers.put(key, value);
            return this;
        }

        public Builder headers(Map<String, String> headers){
            this.headers.putAll(headers);
            return this;
        }

        public Builder attributes(String key, String value){
            this.attributes.put(key, value);
            return this;
        }

        public Builder body(Object body){
            this.body = body;
            return this;
        }

        public Builder pathVariable(String key, String value){
            this.pathVariables.put(key, value);
            return this;
        }

        public Builder queryParam(String key, String[] values){
            this.queryParams.put(key, values);
            return this;
        }

        public RequestContext build(){
            this.requestId = this.requestId != null ? this.requestId: UUID.randomUUID().toString();
            return new RequestContext(this);
        }

    }
}
