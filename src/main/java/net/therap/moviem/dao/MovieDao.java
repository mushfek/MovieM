package net.therap.moviem.dao;

import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Director;
import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */

public interface MovieDao {
    public Movie getMovieById(int id);

    public Movie getMovieByName(String name);

    public void addMovie(Movie movie);

    public void removeMovie(Movie movie);

    public void updateMovie(Movie movie);

    public List<Movie> getMovieByReleaseYear(User user, String releaseYear);

    public List<Movie> getMovieByDirector(User user, Director director);

    public List<Movie> getMovieByActor(User user, Actor actor);

    public List<Movie> getMovieList(User user);
}
