package org.chedly.live;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class livenessProbe implements HealthCheck{

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("i'm alive");
    }
    
}
