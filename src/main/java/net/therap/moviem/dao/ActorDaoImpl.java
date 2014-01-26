package net.therap.moviem.dao;

import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Movie;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class ActorDaoImpl implements ActorDao {
    private static final Logger logger = LoggerFactory.getLogger(DirectorDaoImpl.class);

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
    public Actor getActorById(int id) {
        TypedQuery<Actor> query = em.createQuery("SELECT a FROM Actor a WHERE :id IN a.id", Actor.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("Actor Not Found in {}", new Object[]{}, e);
        }
        return null;
    }

    @Override
    public Actor getActorByName(String name) {
        TypedQuery<Actor> query = em.createQuery("SELECT a FROM Actor a WHERE :name IN a.name", Actor.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("Actor Not Found in {}", new Object[]{}, e);
        }
        return null;
    }

    @Override
    public Actor getActorByMovie(Movie movie) {
        TypedQuery<Actor> query = em.createQuery("SELECT a FROM Actor a WHERE :movieName IN a.actedIn", Actor.class);
        query.setParameter("movieName", movie.getName());
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("Actor Not Found in {}", new Object[]{}, e);
        }
        return null;
    }

//    @Override
//    public List<Actor> getActorListByMovie(Movie movie) {
//        TypedQuery<Actor> query = em.createQuery("SELECT a FROM Actor a WHERE :movie MEMBER OF a.actedIn", Actor.class);
//        query.setParameter("movie", movie);
//        return query.getResultList();
//    }

    @Override
    public void addActor(Actor actor) {
        em.persist(actor);
    }

    @Override
    public void updateActor(Actor actor) {
        em.merge(actor);
    }
}
