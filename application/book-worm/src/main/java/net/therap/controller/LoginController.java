package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14
 */

@Controller
@SessionAttributes({"user", "isLoggedIn"})
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getLoginForm(ModelMap modelMap) {
        modelMap.addAttribute("userForm", new User());
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
