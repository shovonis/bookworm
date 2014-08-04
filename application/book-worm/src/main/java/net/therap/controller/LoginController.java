package net.therap.controller;

import net.therap.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shakhawat.hossain on 8/3/14.
 */

@Controller
public class LoginController {

    @RequestMapping (value = {"/login", "/"}, method = RequestMethod.GET)
    public String getLoginForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "test";
    }
}
