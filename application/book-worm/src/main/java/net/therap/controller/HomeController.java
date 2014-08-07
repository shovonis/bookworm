package net.therap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/5/14 9:17 AM
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String getHomePage(ModelMap modelMap) {
        return "home";
    }
}
