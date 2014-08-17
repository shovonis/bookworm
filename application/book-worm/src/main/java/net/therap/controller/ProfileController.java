package net.therap.controller;

import net.therap.domain.Area;
import net.therap.domain.Book;
import net.therap.domain.User;
import net.therap.domain.WishedBook;
import net.therap.service.BookService;
import net.therap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/5/14 10:56 AM
 */

@Controller
public class ProfileController {
    private static final Logger log = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    private User user;
    private List<Book> preferredBookList;

    @RequestMapping (value = "/profile", method = RequestMethod.GET)
    public ModelAndView getProfilePage(ModelMap modelMap, HttpSession httpSession) {
        user = (User) httpSession.getAttribute("user");
        int userId = user.getUserId();

        Collection<Book> postedBooks = userService.getPostedBooksByUserId(userId);
        Collection<WishedBook> wishedBooks = userService.getWishedBooksByUserId(userId);
        Collection<Area> areas = userService.getAreas();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("postedBooks", postedBooks);
        modelAndView.addObject("wishedBooks", wishedBooks);
        modelAndView.addObject("wishedBook", new WishedBook());
        modelAndView.addObject("areas", areas);
        modelAndView.addObject("user", user);

        modelAndView.setViewName("user/profile");
        return modelAndView;
    }

    @RequestMapping ("/getProfilePicture")
    @ResponseBody
    public byte[] getProfilePicture(HttpSession httpSession) {
        user = (User) httpSession.getAttribute("user");
        return user.getProfilePicture();
    }

    @RequestMapping (value = "/getUser/{userId}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable int userId) {
        user = userService.getUserById(userId);
        preferredBookList = bookService.getUserPreferredBookList();

        ModelAndView modelAndView = new ModelAndView("user/user_summary");
        modelAndView.addObject("user", user);
        modelAndView.addObject("bookForm", new Book());
        modelAndView.addObject("preferredList", preferredBookList);
        return modelAndView;
    }


    @RequestMapping (value = "/profile/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updateProfileInfo(@RequestBody User updatedUser, HttpSession httpSession) {
        user = (User) httpSession.getAttribute("user");
        userService.updateUserInfo(updatedUser, user.getUserId());
    }

    @RequestMapping (value = "/profile/updatePhoto", method = RequestMethod.POST)
    @ResponseBody
    public void updateProfilePicture(@RequestParam (value = "fileToUpload") MultipartFile profilePicture,
                                     HttpSession httpSession) {
        try {

            byte[] imageBytes = profilePicture.getBytes();

            user = (User) httpSession.getAttribute("user");
            userService.updateProfilePicture(user.getUserId(), imageBytes);
            user.setProfilePicture(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping (value = "/reputation", method = RequestMethod.POST)
    @ResponseBody
    public void rateUserReputation(@RequestParam ("reputationPoint") int reputationPoint) {

        log.info("REPUTATION POINT {}", reputationPoint);
        log.info("User ID {}", user.getUserId());

        int reviewCount = user.getReviewerCount();
        double currentReputation = (reputationPoint + user.getReputationPoint() * reviewCount) / (reviewCount + 1);

        user.setReputationPoint(currentReputation);
        user.setReviewerCount(reviewCount + 1);
        userService.updateUser(user);

    }
}
