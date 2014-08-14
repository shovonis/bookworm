package net.therap.controller;

import net.therap.domain.Book;
import net.therap.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/5/14 9:17 AM
 */
@Controller
public class HomeController {

    @Autowired
    private BookService bookService;
    private List<Book> recentlyPostedBooks;

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String getHomePage(ModelMap modelMap) {
        recentlyPostedBooks = bookService.getRecentlyPostedBooks();
        modelMap.addAttribute("recentBookPosts", recentlyPostedBooks);
        modelMap.addAttribute("bookForm", new Book());
        return "home";
    }

    @RequestMapping("/getBookPhoto/{index}")
    @ResponseBody
    public byte[] getBookPhoto(@PathVariable("index") int index) {
        return recentlyPostedBooks.get(index).getPhoto();
    }

}
