package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14
 */

@Controller
@SessionAttributes({"user", "isLoggedIn"})
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getLoginForm(ModelMap modelMap,
                               @RequestParam(value = "registrationSuccess", required = false) String message) {
        modelMap.addAttribute("userForm", new User());
        modelMap.addAttribute("registrationSuccess", message);
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("userForm") User user, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();

        User authenticatedUser = userService.getAuthenticatedUser(user);

        if (authenticatedUser != null) {
            modelAndView.addObject("user", authenticatedUser);
            modelAndView.addObject("isLoggedIn", true);
            modelAndView.setViewName("redirect:/home");
        } else {
            modelMap.addAttribute("loginFailedMsg", "Incorrect email / password");
            modelAndView.setViewName("user/login");
        }

        return modelAndView;
    }
}
