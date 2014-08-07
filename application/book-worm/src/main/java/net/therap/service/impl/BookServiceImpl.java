package net.therap.service.impl;

import net.therap.domain.Book;
import net.therap.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rifatul.islam
 * @since 8/7/14.
 */

@Service
@Transactional("transactionManager")
public class BookServiceImpl implements BookService {
    @Override
    public void addBook(Book book) {

    }
}
