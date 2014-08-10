package net.therap.controller;

import net.therap.domain.Book;
import net.therap.domain.User;
import net.therap.domain.WishedBook;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/5/14 10:56 AM
 */

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView getProfilePage(ModelMap modelMap, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        int userId = user.getUserId();

        Collection<Book> postedBooks  = userService.getPostedBooksByUserId(userId);
        Collection<WishedBook> wishedBooks = userService.getWishedBooksByUserId(userId);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("postedBooks", postedBooks);
        modelAndView.addObject("wishedBooks", wishedBooks);
        modelAndView.addObject("wishedBook", new WishedBook());
        modelAndView.addObject("user", user);

        modelAndView.setViewName("user/profile");
        return modelAndView;
    }
}
