package net.therap.moviem.controller;

import net.therap.moviem.dao.DirectorDaoImpl;
import net.therap.moviem.domain.User;
import net.therap.moviem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/8/13
 * Time: 9:06 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
//@RequestMapping("/")
@SessionAttributes(value = "user")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(DirectorDaoImpl.class);

    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(ModelMap modelMap) {
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String loginSuccess(@RequestParam("username") String username,
                               @RequestParam("password") String password, ModelMap modelMap) {
        logger.debug("username: " + username + "password: " + password);

        User user = userService.checkLogin(username, password);
        if (user == null) {
            modelMap.addAttribute("error", true);
            return "login";
        }
        modelMap.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = "/logout/{id}", method = RequestMethod.GET)
    public String logout(@PathVariable("id") int id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);
        return "redirect:/";
    }
}
