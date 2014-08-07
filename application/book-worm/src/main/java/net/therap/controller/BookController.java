package net.therap.controller;

import net.therap.domain.WishedBook;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author rifatul.islam
 * @author shakhawat.hossain
 * @since 8/7/14.
 */

@Controller
public class BookController {

    @Autowired
    private UserService userService;

    @RequestMapping (value = "/addbook", method = RequestMethod.GET)
    public ModelAndView getBookForm() {

        return new ModelAndView("book/book_form");
    }

    @RequestMapping (value = "/addWishedBook", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addWishedBook(@RequestBody WishedBook wishedBook) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("request received with " + wishedBook.toString());
    }

    @RequestMapping(value = "/removeWishedBook", method = RequestMethod.POST)
    @ResponseBody
    public void removeWishedBook(@RequestParam("wishedBookId") int wishedBookId){
       System.out.println("wishedBook id = "+wishedBookId);
    }
}
