package net.therap.moviem.controller;

import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Director;
import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;
import net.therap.moviem.service.ActorService;
import net.therap.moviem.service.DirectorService;
import net.therap.moviem.service.MovieService;
import net.therap.moviem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/4/13
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@SessionAttributes(value = "user")
public class MovieController {
    @Inject
    private UserService userService;

    @Inject
    private MovieService movieService;

    @Inject
    private DirectorService directorService;

    @Inject
    private ActorService actorService;

    @RequestMapping(value = "/new-movie-form/{id}", method = RequestMethod.GET)
    public String newMovieForm(@PathVariable("id") int userId, ModelMap modelMap) {
        User user = userService.getUserById(userId);
        modelMap.addAttribute("user", user);
        return "newMovieForm";
    }

    @RequestMapping(value = "/add-success", method = RequestMethod.POST)
    public String addNewMovie(@RequestParam("userId") int userId, @RequestParam("movieName") String movieName,
                              @RequestParam("releaseYear") String releaseYear, @RequestParam("movieLink") String movieLink,
                              @RequestParam("directorName") String directorName, @RequestParam("directorLink") String directorLink,
                              @RequestParam("actorName") String actorName, @RequestParam("actorLink") String actorLink,
                              ModelMap modelMap) {
        User user = userService.getUserById(userId);
        userService.updateUser(user, movieName, releaseYear, movieLink, directorName, directorLink,
                actorName, actorLink);

        /*
         * getting recently updated user image and
         * setting to modelMap as an attribute
         */
        User updatedUser = userService.getUserById(userId);
        modelMap.addAttribute("user", updatedUser);
        return "addSuccess";
    }

    @RequestMapping(value = "/movie-by-year/{id}/{year}", method = RequestMethod.GET)
    public String yearMovieList(@PathVariable("id") int id,
                                @PathVariable("year") String year, ModelMap modelMap) {
        User user = userService.getUserById(id);
        List<Movie> movieList = movieService.getMovieByReleaseYear(user, year);
        modelMap.addAttribute("year", year);
        modelMap.addAttribute("movieList", movieList);
        return "movieByYear";
    }
}
