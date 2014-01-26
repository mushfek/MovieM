package net.therap.moviem.dao;

import net.therap.moviem.domain.Director;
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
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class DirectorDaoImpl implements DirectorDao {
    private static final Logger logger = LoggerFactory.getLogger(DirectorDaoImpl.class);

    @PersistenceContext
    EntityManager em;

    /* returns query result or null instead if not found in database */
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
    public Director getDirectorById(int id) {
        TypedQuery<Director> query = em.createQuery("SELECT d FROM Director d WHERE :id IN d.id", Director.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("Director Not Found in {}", new Object[]{id}, e);
        }
        return null;
    }

    @Override
    public Director getDirectorByName(String name) {
        TypedQuery<Director> query = em.createQuery("SELECT d FROM Director d WHERE :name IN d.name", Director.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("Director Not Found in {}", new Object[]{name}, e);
        }
        return null;
    }

    @Override
    public void addDirector(Director director) {
        em.persist(director);
    }

    @Override
    public void updateDirector(Director director) {
        em.merge(director);
    }
}
