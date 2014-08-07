package net.therap.controller;

import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author rifatul.islam
 * @since 8/7/14.
 */

@Controller
public class BookController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public ModelAndView getBookForm() {
        
        return new ModelAndView("book/book_form");
    }
}
