package org.chedly;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.Repository.EpisodeRepository;
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

    @GET
    @Path("/test/{episode}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Episode> getEpisodeV1(@PathParam("episode") String episode){
        if (episode != null){
            return Episode.findByEpisode(episode);
        }
        return Episode.listAll();
    }

    @Inject
    EpisodeRepository episodeRepository;
    @GET
    @Path("/Repo/{episode}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Episode> getEpisodeRepo(@PathParam("episode") String episode){
            return episodeRepository.findByEpisode(episode);
    }


    @GET
    @Path("/stream")
    @Produces(MediaType.TEXT_PLAIN)
    public String streamReturn(){
        return Episode.<Episode>listAll().stream().map(e -> e.title.toUpperCase()).collect(Collectors.joining());
    }
}
