package net.therap.moviem.service;

import net.therap.moviem.domain.Director;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/4/13
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */

public interface DirectorService {
    public Director getDirectorById(int id);

    public Director getDirectorByName(String name);

    public void addDirector(Director director);

    public void updateDirector(Director director);
}
