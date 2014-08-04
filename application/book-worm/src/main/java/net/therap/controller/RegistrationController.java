package net.therap.controller;

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
public class RegistrationController {

    @RequestMapping (value = "/registration", method = RequestMethod.GET)
    public String getRegistrationForm(ModelMap modelMap) {
        return "user/registration";
    }
}
