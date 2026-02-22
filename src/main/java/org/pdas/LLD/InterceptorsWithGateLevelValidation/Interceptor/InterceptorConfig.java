package org.pdas.LLD.InterceptorsWithGateLevelValidation.Interceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InterceptorConfig {
    private boolean loginEnabled = true;
    private boolean debuggingEnabled = true;
    private int timeoutInSecs = 30;
    private Map<String, Object> customSetting = new HashMap<>();

    public boolean isLoginEnabled() {
        return loginEnabled;
    }

    public boolean isDebuggingEnabled() {
        return debuggingEnabled;
    }

    public int getTimeoutInSecs() {
        return timeoutInSecs;
    }

    public Map<String, Object> getCustomSetting() {
        return customSetting;
    }

    public void setLoginEnabled(boolean loginEnabled) {
        this.loginEnabled = loginEnabled;
    }

    public void setDebuggingEnabled(boolean debuggingEnabled) {
        this.debuggingEnabled = debuggingEnabled;
    }

    public void setTimeoutInSecs(int timeoutInSecs) {
        this.timeoutInSecs = timeoutInSecs;
    }

    public void setCustomSetting(Map<String, Object> customSetting) {
        this.customSetting = customSetting;
    }
}
