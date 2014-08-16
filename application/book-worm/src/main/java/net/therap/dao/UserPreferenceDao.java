package net.therap.dao;

import net.therap.domain.Book;

import java.util.List;

/**
 * @author shovon
 * @since 8/16/14.
 */
public interface UserPreferenceDao {
    public List<Book> getUserPreferredBookList();
}
