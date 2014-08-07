package net.therap.service;

import net.therap.domain.Book;
import net.therap.domain.WishedBook;

/**
 * @author rifatul.islam
 * @author shakhawat.hossain
 * @since 8/7/14.
 */

public interface BookService {

    public void addBook(Book book);

    public void addWishedBook(WishedBook wishedBook);

}
