package net.therap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shakhawat.hossain on 8/3/14.
 */
@Controller
public class RegistrationController {

    @RequestMapping (value = "/registration", method = RequestMethod.GET)
    public String getRegistrationForm(ModelMap modelMap) {
        return "user/registration";
    }
}
