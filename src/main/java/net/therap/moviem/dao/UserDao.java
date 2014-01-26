package net.therap.moviem.dao;

import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */

public interface UserDao {
    public User getUserById(int id);

    public User getUserByName(String name);

    public void updateUser(User user);

//    public List<Movie> getMovieByDirector(User user, Director director);

    public List<User> getUserList();
}
