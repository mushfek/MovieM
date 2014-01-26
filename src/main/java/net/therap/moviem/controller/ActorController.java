package net.therap.moviem.controller;

import net.therap.moviem.domain.Actor;
import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;
import net.therap.moviem.service.ActorService;
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
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@SessionAttributes(value = "user")
public class ActorController {
    @Inject
    private UserService userService;

    @Inject
    private MovieService movieService;

    @Inject
    private ActorService actorService;

    @RequestMapping(value = "actor-movie-list/{userId}/{actorId}", method = RequestMethod.GET)
    public String showActorsMovies(@PathVariable("userId") int userId,
                                   @PathVariable("actorId") int actorId, ModelMap modelMap) {
        User user = userService.getUserById(userId);
        Actor actor = actorService.getActorById(actorId);
        List<Movie> movieList = movieService.getMovieByActor(user, actor);
        modelMap.addAttribute("actor", actor);
        modelMap.addAttribute("movieList", movieList);
        return "actorProfile";
    }
}
