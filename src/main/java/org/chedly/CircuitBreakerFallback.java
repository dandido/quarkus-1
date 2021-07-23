package org.chedly;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class CircuitBreakerFallback implements FallbackHandler<String> {

    @Override
    public String handle(ExecutionContext executionContext) {
        return getValidTrackingIds();
    }

    public String getValidTrackingIds() {
        return "Has reached fallback for circuit breaker. You can provide and alternative here.";
    }
}