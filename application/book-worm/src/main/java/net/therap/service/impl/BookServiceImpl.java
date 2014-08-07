package net.therap.service.impl;

import net.therap.dao.BookDao;
import net.therap.domain.Book;
import net.therap.domain.Category;
import net.therap.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/7/14.
 */

@Service
@Transactional("transactionManager")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {

    }

    @Override
    public List<Category> getAllCategory() {
        return bookDao.getAllCategory();
    }
}
