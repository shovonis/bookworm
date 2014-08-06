package net.therap.controller;

import net.therap.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14
 */

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping (value = {"/login", "/"}, method = RequestMethod.GET)
    public String getLoginForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "user/login";
    }

    @RequestMapping (value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid User user, BindingResult bindingResult, ModelMap modelMap) {
        if(bindingResult.hasErrors()){
            return "user/login";
        }
        logger.debug("authentication request using email : {} password : {}", user.getEmail(), user.getPassword());
        return "home";
    }
}
