package net.therap.moviem.service;

import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Director;
import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */

public interface UserService {
    public User getUserById(int id);

    public User getUserByName(String name);

    public User checkLogin(String username, String password);

    public void updateUser(User user, String movieName, String releaseYear, String movieLink,
                           String directorName, String directorLink, String actorName, String actorLink);

    public List<User> getUserList();
}