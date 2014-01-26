package net.therap.moviem.service;

import net.therap.moviem.dao.MovieDao;
import net.therap.moviem.dao.UserDao;
import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Director;
import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    @Transactional
    public Movie getMovieById(int id) {
        return movieDao.getMovieById(id);
    }

    @Override
    @Transactional
    public Movie getMovieByName(String name) {
        return movieDao.getMovieByName(name);
    }

    @Override
    @Transactional
    public void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    @Override
    @Transactional
    public void removeMovie(Movie movie) {
        movieDao.removeMovie(movie);
    }

    @Override
    @Transactional
    public void updateMovie(Movie movie) {
        movieDao.updateMovie(movie);
    }

    @Override
    @Transactional
    public List<Movie> getMovieByReleaseYear(User user, String releaseYear) {
        return movieDao.getMovieByReleaseYear(user, releaseYear);
    }

    @Override
    @Transactional
    public List<Movie> getMovieByDirector(User user, Director director) {
        return movieDao.getMovieByDirector(user, director);
    }

    @Override
    @Transactional
    public List<Movie> getMovieByActor(User user, Actor actor) {
        return movieDao.getMovieByActor(user, actor);
    }

    @Override
    @Transactional
    public List<Movie> getMovieList(User user) {
        return movieDao.getMovieList(user);
    }
}