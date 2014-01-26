package net.therap.moviem.dao;

import net.therap.moviem.domain.Director;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */

public interface DirectorDao {
    public Director getDirectorById(int id);

    public Director getDirectorByName(String name);

    public void addDirector(Director director);

    public void updateDirector(Director director);
}
