package net.therap.moviem.controller;

import net.therap.moviem.domain.Director;
import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;
import net.therap.moviem.service.DirectorService;
import net.therap.moviem.service.MovieService;
import net.therap.moviem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/5/13
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@SessionAttributes(value = "user")
public class DirectorController {
    @Inject
    private UserService userService;

    @Inject
    private MovieService movieService;

    @Inject
    private DirectorService directorService;

    @RequestMapping(value = "/dir-movie-list/{userId}/{directorId}", method = RequestMethod.GET)
    public String showDirectorsMovies(@PathVariable("userId") int userId,
                                      @PathVariable("directorId") int directorId, ModelMap modelMap) {
        User user = userService.getUserById(userId);
        Director director = directorService.getDirectorById(directorId);
        List<Movie> movieList = movieService.getMovieByDirector(user, director);
        modelMap.addAttribute("director", director);
        modelMap.addAttribute("movieList", movieList);
        return "directorProfile";
    }
}
