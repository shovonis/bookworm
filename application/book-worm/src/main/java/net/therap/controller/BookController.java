package net.therap.controller;


import net.therap.domain.*;
import net.therap.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author rifatul.islam
 * @author shakhawat.hossain
 * @since 8/7/14.
 */

@Controller
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    private Book book;
    private List<Book> matchedBooks;
    private List<Book> preferredBookList;

    @RequestMapping(value = "/bookDetails/{bookId}", method = RequestMethod.GET)
    public ModelAndView showBookDetails(@PathVariable int bookId) {
        book = bookService.getBookById(bookId);
        preferredBookList = bookService.getUserPreferredBookList();

        ModelAndView modelAndView = new ModelAndView("book/book_details");
        modelAndView.addObject("bookDetails", book);
        modelAndView.addObject("bookForm", new Book());
        modelAndView.addObject("preferredList", preferredBookList);

        return modelAndView;
    }

    @RequestMapping("/getBookImage")
    @ResponseBody
    public byte[] getBookImage() {
        return book.getPhoto();
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public ModelAndView getBookForm(@ModelAttribute("bookForm") Book book) {
        List<Category> categories = bookService.getAllCategory();

        ModelAndView modelAndView = new ModelAndView("book/book_form");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("book", book);

        return modelAndView;
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
                          @RequestParam(value = "bookImage") MultipartFile bookImage, HttpSession session) {

        if (result.hasErrors()) {
            return "book/book_form";
        }

        try {
            byte[] imageBytes = bookImage.getBytes();

            User user = (User) session.getAttribute("user");
            book.setUser(user);
            book.setPhoto(imageBytes);

            if (book.getExchangeBooks() != null) {
                for (ExchangeBook exchangeBook : book.getExchangeBooks()) {
                    exchangeBook.setBook(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookService.addBook(book);
        return "redirect:/home";
    }

    @RequestMapping(value = "/profile/addWishedBook", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int addWishedBook(@RequestBody WishedBook wishedBook, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        wishedBook.setUser(user);

        return bookService.addWishedBookAndGetId(wishedBook);
    }

    @RequestMapping(value = "/removeWishedBook", method = RequestMethod.POST)
    @ResponseBody
    public void removeWishedBook(@RequestParam("wishedBookId") int wishedBookId) {
        log.debug("wishedBook id = {}", wishedBookId);

        bookService.removeWishedBookById(wishedBookId);
    }


    @RequestMapping(value = "/removePostedBook", method = RequestMethod.POST)
    @ResponseBody
    public void removePostedBook(@RequestParam("postedBookId") int postedBookId) {
        log.debug("remove request for posted book {}", postedBookId);

        bookService.removePostedBookById(postedBookId);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchBook(ModelAndView modelAndView, @RequestParam("query") String searchKey) {

        matchedBooks = bookService.getBooksBySearchKey(searchKey);

        modelAndView.addObject("bookForm", new Book());
        modelAndView.setViewName("book/book_search");
        modelAndView.addObject("matchedBooks", matchedBooks);
        return modelAndView;
    }

    @RequestMapping("/search/getPhoto/{index}")
    @ResponseBody
    public byte[] getBookPhoto(@PathVariable("index") int index) {
        return matchedBooks.get(index).getPhoto();
    }
}
