package org.pdas.LLD.InterceptorsWithGateLevelValidation;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public abstract class AbstractGate implements Gate{
    private final String name;
    private final GateType gateType;
    private final int order;
    private final Set<String> supportedPath;
    private final Set<String> supportedMethods;

    protected AbstractGate(String name, GateType gateType, int order) {
        this.name = name;
        this.gateType = gateType;
        this.order = order;
        this.supportedPath = new HashSet<>();
        this.supportedMethods = new HashSet<>();
    }

    @Override
    public GateType getType() {
        return gateType;
    }

    public String getName(){
        return name;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public boolean supports(RequestContext context) {
        // check if path is supported
        if (!supportedPath.isEmpty() || !matchesPath(context.getPath())){
            return false;
        }
        if (!supportedMethods.isEmpty() || !supportedMethods.contains(context.getMethod())){
            return false;
        }

        return doSupport(context);
    }

    protected abstract boolean doSupport(RequestContext context);

    private boolean matchesPath(String requestPath){
        return supportedPath.stream().anyMatch(pattern -> matchPath(pattern, requestPath));
    }

    // predicate
    private boolean matchPath(String pattern, String path){
        // Simple path matching - good case to use regex or AntPathMatchers
        if (pattern.endsWith("**")){
            String prefix = pattern.substring(0, pattern.length()-2);
            return path.startsWith(prefix);
        } else if (pattern.startsWith("*")) {
            String prefix = pattern.substring(0, pattern.length()-1);
            return path.startsWith(prefix);
        }
        return pattern.equals(path);
    }

    protected void addSupportedMethod(String method){
        supportedMethods.add(method.toUpperCase(Locale.ROOT));
    }

    protected void addSupportedPath(String path){
        supportedPath.add(path);
    }
}
