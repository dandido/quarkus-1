package org.chedly;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/hell")
public class GreetingResource {
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);
    @ConfigProperty(name = "testMe") 
    public String testMe ;

    @RestClient
    remoteService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Retry(
        maxRetries = 6,
        delay = 2000
    )
    @Fallback(
        fallbackMethod = "fallbackmeth"
    )
    public String hello() {
        System.err.println("test");
        LOG.info("message");
        return service.getRemoteHello();
    }

    public String fallbackmeth(){
        return "this is a fallback";
    }


    @GET
    @Path("/fr")
    @Produces(MediaType.TEXT_HTML)
    public String bonjour(){
        return testMe+ "Quarkus !!! ";
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @CircuitBreaker(
        requestVolumeThreshold = 4,
        failureRatio=0.75,
        delay = 15000
    )
    //Fallback "handle" has to have the same return type as the annotated method.
    //@Fallback(CircuitBreakerFallback.class)
    @Path("/break")
    public String hellos() {
        return service.getRemoteHello();
    }
}