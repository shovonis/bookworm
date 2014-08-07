package net.therap.dao.jpa;

import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/6/14 12:15 PM
 */
@Repository
@Qualifier("userDaoJpa")
public class UserDaoImpl implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User getAuthenticatedUser(String email, String password) {
        User authenticatedUser = null;
        String queryStr = "SELECT user FROM User user " +
                "WHERE user.email = :email AND user.password = :password";

        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        try {
            authenticatedUser = query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException exp) {
            log.error("Error in Executing Query");
        }
        return authenticatedUser;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(String userId) {

    }
}
