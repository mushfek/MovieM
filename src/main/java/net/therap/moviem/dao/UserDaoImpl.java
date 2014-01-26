package net.therap.moviem.dao;

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
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

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
    public User getUserById(int id) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE :id IN u.id", User.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("No User Found in {}", new Object[]{id}, e);
        }
        return null;
    }

    @Override
    public User getUserByName(String name) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE :name IN u.name", User.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            logger.debug("No User Found in {}", new Object[]{name}, e);
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

//    @Override
//    public List<Movie> getMovieByDirector(User user, Director director) {
//        TypedQuery<User> query = em.createQuery("SELECT u.watchList FROM User AS u WHERE :director IN u.watchList")
//    }

    @Override
    public List<User> getUserList() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
