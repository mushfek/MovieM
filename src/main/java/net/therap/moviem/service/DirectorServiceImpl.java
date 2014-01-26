package net.therap.moviem.service;

import net.therap.moviem.dao.DirectorDao;
import net.therap.moviem.domain.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/4/13
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    private net.therap.moviem.dao.DirectorDao directorDao;

    @Override
    @Transactional
    public Director getDirectorById(int id) {
        return directorDao.getDirectorById(id);
    }

    @Override
    @Transactional
    public Director getDirectorByName(String name) {
        return directorDao.getDirectorByName(name);
    }

    @Override
    @Transactional
    public void addDirector(Director director) {
        directorDao.addDirector(director);
    }

    @Override
    @Transactional
    public void updateDirector(Director director) {
        directorDao.updateDirector(director);
    }
}