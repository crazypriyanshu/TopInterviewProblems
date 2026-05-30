package org.pdas.popularInterview.StreamCoolExamples;

import java.math.BigDecimal;

public record Order(Long orderId, String paymentStatus, String currency, BigDecimal amount) {}
