package org.chedly;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.chedly.Model.Episode;

@Path("/episode")
public class EpisodeRessource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Episode> getEpisode(){
        return Episode.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveEpisode(Episode episode){
        episode.persist();
            return Response.status(Status.CREATED).entity(episode).build();
    }

}
