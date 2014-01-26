package net.therap.moviem.dao;

import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Director;
import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class MovieDaoImpl implements MovieDao {
    private static final Logger logger = LoggerFactory.getLogger(MovieDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

//    /* returns query result or null instead if not found in database */
//    public static<T> List<T> getQueryResult(TypedQuery<T> query, boolean isSingle) {
//        if (isSingle == true) {
//            query.setMaxResults(1);
//        }
//
//        List<T> resultList = query.getResultList();
//        if ((resultList == null) || (resultList.size() == 0)) {
//            return null;
//        }
//        return resultList;
//    }

    @Override
    public Movie getMovieById(int id) {
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE :id IN m.id", Movie.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("No Movie Found in {}", new Object[]{id}, e);
        }
        return null;
    }

    @Override
    public Movie getMovieByName(String name) {
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE :name IN m.name", Movie.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("No Movie Found in {}", new Object[]{name}, e);
        }
        return null;
    }

    @Override
    public void addMovie(Movie movie) {
        em.persist(movie);
    }

    @Override
    public void removeMovie(Movie movie) {
        /* gonna implement afterwards */
    }

    @Override
    public void updateMovie(Movie movie) {
        em.merge(movie);
    }

    @Override
    public List<Movie> getMovieByReleaseYear(User user, String releaseYear) {
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE :user MEMBER OF m.watchedBy AND :releaseYear = m.year", Movie.class);
        query.setParameter("user", user);
        query.setParameter("releaseYear", releaseYear);
        return query.getResultList();
    }

    @Override
    public List<Movie> getMovieByDirector(User user, Director director) {
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE :user MEMBER OF m.watchedBy AND :directorId=m.director.id", Movie.class);
        query.setParameter("user", user);
        query.setParameter("directorId", director.getId());
        return query.getResultList();
    }

    @Override
    public List<Movie> getMovieByActor(User user, Actor actor) {
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE :user MEMBER OF m.watchedBy AND :actorId = m.actor.id", Movie.class);
        query.setParameter("user", user);
        query.setParameter("actorId", actor.getId());
        return query.getResultList();
    }

    @Override
    public List<Movie> getMovieList(User user) {
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE :user MEMBER OF m.watchedBy", Movie.class);
        query.setParameter("user", user);
        return query.getResultList();
    }
}
