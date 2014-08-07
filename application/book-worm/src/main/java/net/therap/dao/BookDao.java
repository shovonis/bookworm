package net.therap.dao;

import net.therap.domain.Book;
import net.therap.domain.Category;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/7/14.
 */

public interface BookDao {

    public void addBook(Book book);

    public List<Category> getAllCategory();
}
