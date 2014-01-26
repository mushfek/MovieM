package net.therap.moviem.service;

import net.therap.moviem.dao.ActorDao;
import net.therap.moviem.dao.DirectorDao;
import net.therap.moviem.dao.MovieDao;
import net.therap.moviem.dao.UserDao;
import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Director;
import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private DirectorDao directorDao;

    @Autowired
    private ActorDao actorDao;

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    @Transactional
    public User checkLogin(String username, String password) {
        User user = getUserByName(username);
        if (user != null) {
            return (user.getPassword().equals(password)) ? user : null;
        }
        return null;
    }

    @Override
    @Transactional
    public void updateUser(User user, String movieName, String releaseYear, String movieLink,
                           String directorName, String directorLink, String actorName, String actorLink) {
        Movie movie = movieDao.getMovieByName(movieName);
        Director director = directorDao.getDirectorByName(directorName);
        Actor actor = actorDao.getActorByName(actorName);

        /* if not found, we gotta create one */
        if (director == null) {
            director = new Director();
            director.setName(directorName);
            director.setLink(directorLink);
        }

        if (actor == null) {
            actor = new Actor();
            actor.setName(actorName);
            actor.setLink(actorLink);
        }

        if (movie == null) {
            movie = new Movie();
            movie.setName(movieName);
            movie.setYear(releaseYear);
            movie.setLink(movieLink);
            movie.setDirector(director);
            movie.setActor(actor);
        }

        List<Movie> movieList = user.getWatchList();
        movieList.add(movie);
        user.setWatchList(movieList);
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> getUserList() {
        return userDao.getUserList();
    }
}