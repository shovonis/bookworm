package net.therap.controller;

import net.therap.domain.Area;
import net.therap.domain.User;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14
 */

@Controller
public class RegistrationController {
    private static final String REG_SUCCESS_MSG = "Congratulation! Your Registration is Complete. Please Login.";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistrationForm() {
        return new ModelAndView("user/registration", "user", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("redirect:login");

        if (result.hasErrors()) {
            modelAndView.setViewName("user/registration");
            return modelAndView;
        }

        Area area = new Area();
        area.setAreaCode(Area.DEFAULT_AREA_CODE);
        user.setArea(area);

        userService.addUser(user);
        modelAndView.addObject("registrationSuccess", REG_SUCCESS_MSG);
        return modelAndView;
    }
}
