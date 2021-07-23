package org.chedly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8085")
@Path("/hello")
public interface remoteService {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRemoteHello();
}
