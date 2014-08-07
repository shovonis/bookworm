package net.therap.controller;

import net.therap.domain.WishedBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/5/14 10:56 AM
 */

@Controller
public class ProfileController {

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public ModelAndView getProfilePage(@PathVariable int userId, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/profile");
        modelAndView.addObject("wishedBook", new WishedBook());
        return modelAndView;
    }
}
