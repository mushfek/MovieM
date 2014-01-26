package net.therap.moviem.service;

import net.therap.moviem.dao.ActorDao;
import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/5/13
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorDao actorDao;

    @Override
    @Transactional
    public Actor getActorById(int id) {
        return actorDao.getActorById(id);
    }

    @Override
    @Transactional
    public Actor getActorByName(String name) {
        return actorDao.getActorByName(name);
    }

    @Override
    public Actor getActorByMovie(Movie movie) {
        return actorDao.getActorByMovie(movie);
    }

    @Override
    @Transactional
    public void addActor(Actor actor) {
        actorDao.addActor(actor);
    }

    @Override
    @Transactional
    public void updateActor(Actor actor) {
        actorDao.updateActor(actor);
    }
}