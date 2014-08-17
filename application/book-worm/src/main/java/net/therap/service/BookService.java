package net.therap.service;

import net.therap.domain.Book;
import net.therap.domain.Category;
import net.therap.domain.WishedBook;

import java.util.List;

/**
 * @author rifatul.islam
 * @author shakhawat.hossain
 * @since 8/7/14.
 */

public interface BookService {

    public void addBook(Book book);

    public int addWishedBookAndGetId(WishedBook wishedBook);

    public Book getBookById(int bookId);

    public List<Category> getAllCategory();

    void removePostedBookById(int postedBookId);

    void removeWishedBookById(int wishedBookId);

    public List<Book> getRecentlyPostedBooks();

    public List<Book> getBooksBySearchKey(String searchKey);

    public List<Book> getBooksByAuthorOrTitle(String title, String author);

    public List<Book> getUserPreferredBookList();

}
