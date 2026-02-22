package org.pdas.LLD.InterceptorsWithGateLevelValidation;

public enum GateType {
    PRE_PROCESSING,
    AUTHENTICATION,
    AUTHORIZATION,
    INPUT_VALIDATION,
    RATE_LIMITING,
    DATA_ENRICHMENT,
    AUDIT,
    POST_PROCESSING
}
