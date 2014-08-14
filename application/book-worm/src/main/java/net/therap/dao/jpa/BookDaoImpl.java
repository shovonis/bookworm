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
        entityManager.flush();
    }

    @Override
    public Book getBookById(int bookId) {
        return entityManager.find(Book.class, bookId);
    }

    @Cacheable(value = "BookCategory")
    @Override
    public List<Category> getAllCategory() {
        List<Category> categoryList = null;
        String queryString = "SELECT category FROM Category category";
        TypedQuery<Category> query = entityManager.createQuery(queryString, Category.class);

        try {
            categoryList = query.getResultList();
            log.info("Book Category Query Executed");
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

    @Override
    public List<Book> getRecentlyPostedBooks() {
        Query query = entityManager.createQuery("SELECT book FROM Book book ORDER BY book.postDateTime DESC");
        return query.getResultList();
    }

    @Override
    public List<Book> getBooksBySearchKey(String searchKey) {
        Query query = entityManager.createQuery("SELECT book FROM Book book WHERE book.isActive = true " +
                "AND ( book.title LIKE :title OR book.author LIKE :author )");
        query.setParameter("title",  "%" + searchKey + "%");
        query.setParameter("author", "%" + searchKey + "%");

        return query.getResultList();
    }
}
