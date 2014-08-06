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
@Qualifier ("userDaoJpa")
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;
    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User getAuthenticatedUser(String email, String password) {
        String queryStr = "SELECT user FROM User user " +
                "WHERE user.email = :email AND user.password = :password";

        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        User user;
        try {
            user = query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException exp) {
            System.out.println("query failed...");
            return null;
        }
        return user;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(String userId) {

    }
}
