package net.therap.dao;

import net.therap.domain.Area;
import net.therap.domain.Book;
import net.therap.domain.User;
import net.therap.domain.WishedBook;

import java.util.Collection;

/**
 * @author rifatul.islam
 * @since 8/4/14.
 */

public interface UserDao {
    public User getAuthenticatedUser(String email, String password);

    public void addUser(User user);

    public void deleteUser(String userId);

    java.util.Collection<Book> getPostedBooksByUserId(int userId);

    Collection<WishedBook> getWishedBooksByUserId(int userId);

    Collection<Area> getAreas();


    public User getUserById(int userId);


    void updateUserInfo(User updatedUser, int userId);

    void updateUser(User updatedUser);

    void updateProfilePicture(int userId, byte[] imageBytes);
}
