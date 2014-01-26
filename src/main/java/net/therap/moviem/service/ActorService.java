package net.therap.moviem.service;

import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Movie;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/5/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */

public interface ActorService {
    public Actor getActorById(int id);

    public Actor getActorByName(String name);

    public Actor getActorByMovie(Movie movie);

    public void addActor(Actor actor);

    public void updateActor(Actor actor);
}