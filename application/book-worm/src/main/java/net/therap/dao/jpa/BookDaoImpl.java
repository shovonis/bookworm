package net.therap.dao.jpa;

import net.therap.dao.BookDao;
import net.therap.domain.Book;
import net.therap.domain.Category;
import net.therap.domain.WishedBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/7/14.
 */

@Repository
@Qualifier("bookDaoJpa")
public class BookDaoImpl implements BookDao {
    private static final Logger log = LoggerFactory.getLogger(BookDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = entityManager.find(Book.class, bookId);
        return book;
    }

    @Cacheable(value = "BookCategory")
    @Override
    public List<Category> getAllCategory() {
        List<Category> categoryList = null;
        String queryString = "SELECT category FROM Category category";

        log.info("Executing first time");

        TypedQuery<Category> query = entityManager.createQuery(queryString, Category.class);
        try {
            categoryList = query.getResultList();
        } catch (NoResultException | NonUniqueResultException exp) {
            log.error("Error in Executing Query" + exp);
        }
        return categoryList;
    }

    @Override
    public int addWishedBookAndGetId(WishedBook wishedBook) {
         entityManager.persist(wishedBook);
         entityManager.flush();
         return wishedBook.getId();
    }

    @Override
    public void removePostedBookById(int postedBookId) {
        Book bookToBeRemoved = entityManager.find(Book.class, postedBookId);
        entityManager.remove(bookToBeRemoved);

        log.debug("removed book of id ", postedBookId);
    }

    @Override
    public void removeWishedBookById(int wishedBookId) {
        WishedBook wishedBookToBeRemoved = entityManager.find(WishedBook.class, wishedBookId);
        entityManager.remove(wishedBookToBeRemoved);
    }
}
