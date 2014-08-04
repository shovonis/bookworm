package net.therap.controller;

import net.therap.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14
 */

@Controller
public class LoginController {

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String getLoginForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "user/login";
    }
}
