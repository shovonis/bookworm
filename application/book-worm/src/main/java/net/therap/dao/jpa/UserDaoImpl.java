package net.therap.dao.jpa;

import net.therap.dao.UserDao;
import net.therap.domain.Area;
import net.therap.domain.Book;
import net.therap.domain.User;
import net.therap.domain.WishedBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/6/14 12:15 PM
 */
@Repository
@Qualifier ("userDaoJpa")
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

    @Override
    public Collection<Book> getPostedBooksByUserId(int userId) {
        Query query = entityManager
                .createQuery("SELECT  user FROM User user " +
                        "LEFT JOIN FETCH user.postedBooks " +
                        "WHERE user.userId = :userId");

        query.setParameter("userId", userId);
        User user = (User) query.getSingleResult();
        return user.getPostedBooks();
    }

    @Override
    public Collection<WishedBook> getWishedBooksByUserId(int userId) {
        Query query = entityManager
                .createQuery("SELECT  user FROM User user " +
                        "LEFT JOIN FETCH user.wishedBooks " +
                        "WHERE user.userId = :userId");

        query.setParameter("userId", userId);
        User user = (User) query.getSingleResult();
        return user.getWishedBooks();
    }

    @Override
    public Collection<Area> getAreas() {
        Query query = entityManager.createQuery("SELECT area from Area area", Area.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(int userId) {
        Query query = entityManager
                .createQuery("SELECT  user FROM User user " +
                        "LEFT JOIN FETCH user.wishedBooks " + "LEFT JOIN FETCH user.postedBooks  " +
                        " LEFT JOIN FETCH user.area " +
                        "WHERE user.userId = :userId");

        query.setParameter("userId", userId);
        User user = (User) query.getSingleResult();
        return user;
    }

    public void updateUserInfo(User updatedUser, int userId) {
        Query query = entityManager.createQuery("UPDATE User user SET user.firstName = :firstName," +
                " user.lastName = :lastName, user.email = :email, user.phoneNumber = :phoneNumber," +
                " user.area.areaCode = :areaCode" +
                " WHERE user.userId = :userId");

        query.setParameter("userId", userId);
        query.setParameter("firstName", updatedUser.getFirstName());
        query.setParameter("lastName", updatedUser.getLastName());
        query.setParameter("email", updatedUser.getEmail());
        query.setParameter("phoneNumber", updatedUser.getPhoneNumber());
        query.setParameter("areaCode", updatedUser.getArea().getAreaCode());

        query.executeUpdate();
    }

    @Override
    public void updateProfilePicture(int userId, byte[] imageBytes) {
        Query query = entityManager.createQuery("UPDATE User user SET user.profilePicture = :profilePicture " +
                "WHERE user.userId = :userId");

        query.setParameter("profilePicture", imageBytes);
        query.setParameter("userId", userId);

        query.executeUpdate();
    }
}
