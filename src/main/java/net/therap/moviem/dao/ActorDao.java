package net.therap.moviem.dao;

import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Movie;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */

public interface ActorDao {
    public Actor getActorById(int id);

    public Actor getActorByName(String name);

    public Actor getActorByMovie(Movie movie);

    public void addActor(Actor actor);

    public void updateActor(Actor actor);
}
