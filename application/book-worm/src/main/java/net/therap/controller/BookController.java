package net.therap.controller;

import net.therap.domain.Book;
import net.therap.domain.Category;
import net.therap.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/7/14.
 */

@Controller
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public ModelAndView getBookForm() {
        List<Category> categories = bookService.getAllCategory();

        ModelAndView modelAndView = new ModelAndView("book/book_form");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("book", new Book());

        return modelAndView;
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book, BindingResult result,
                          @RequestParam(value = "bookImage") MultipartFile bookImage) {
        if (result.hasErrors()) {
            return "redirect:/addbook";
        }
        try {
            byte[] imageByte = bookImage.getBytes();
            book.setPhoto(imageByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookService.addBook(book);
        return "home";
    }
}
