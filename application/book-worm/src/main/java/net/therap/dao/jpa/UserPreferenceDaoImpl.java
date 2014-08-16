package net.therap.dao.jpa;

import net.therap.dao.UserPreferenceDao;
import net.therap.domain.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author shovon
 * @since 8/16/14.
 */

@Repository
public class UserPreferenceDaoImpl implements UserPreferenceDao {
    public static final int MINIMUM_PREFERRED_BOOK = 5;

    @PersistenceContext
    private EntityManager entityManager;


    @Cacheable(value = "PreferredBook")
    @Override
    public List<Book> getUserPreferredBookList() {
        String queryStringByAuthor = "SELECT resultBook  FROM Book resultBook " +
                "WHERE resultBook.author IN (SELECT exchangeBook.author FROM ExchangeBook  exchangeBook) OR " +
                " resultBook.title IN (SELECT exchangeBook.title FROM ExchangeBook  exchangeBook)";

        Query query = entityManager.createQuery(queryStringByAuthor);
        List<Book> results = query.getResultList();

        if (!isMinimumPreferredResultMatched(results)) {
            queryStringByAuthor = "SELECT resultBook  FROM Book resultBook ORDER BY resultBook.postDateTime DESC ";
            query = entityManager.createQuery(queryStringByAuthor);
            query.setMaxResults(MINIMUM_PREFERRED_BOOK);
            results = query.getResultList();
        }

        return results;
    }

    private boolean isMinimumPreferredResultMatched(List<Book> resultList) {
        if (resultList.size() == MINIMUM_PREFERRED_BOOK) {
            return true;
        }
        return false;
    }
}
