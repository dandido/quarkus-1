package org.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.chedly.Model.Episode;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EpisodeRepository implements PanacheRepository<Episode>{
    
    public List<Episode> findByEpisode(String episodeTitle){
        return Episode.find("title", episodeTitle).list();
    }
}
