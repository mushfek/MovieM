package net.therap.moviem.controller;

import net.therap.moviem.domain.Movie;
import net.therap.moviem.domain.User;
import net.therap.moviem.service.ActorService;
import net.therap.moviem.service.MovieService;
import net.therap.moviem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/2/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@SessionAttributes(value = "user")
public class UserController {
    @Inject
    private UserService userService;

    @Inject
    private MovieService movieService;

    @Inject
    private ActorService actorService;

    @RequestMapping(value = "/user-profile/{id}", method = RequestMethod.GET)
    public String userProfile(@PathVariable("id") int userId, ModelMap modelMap) {
        User user = userService.getUserById(userId);
        List<Movie> movieList = movieService.getMovieList(user);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("movieList", movieList);
        return "userProfile";
    }
}