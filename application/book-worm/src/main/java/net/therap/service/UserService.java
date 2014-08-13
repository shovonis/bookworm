package net.therap.service;

import net.therap.domain.Area;
import net.therap.domain.Book;
import net.therap.domain.User;
import net.therap.domain.WishedBook;

import java.util.Collection;

/**
 * @author rifatul.islam
 * @since 8/6/14.
 */


public interface UserService {
    public User getAuthenticatedUser(User user);

    public void addUser(User user);

    public java.util.Collection<Book> getPostedBooksByUserId(int userId);

    public Collection<WishedBook> getWishedBooksByUserId(int userId);

    public Collection<Area> getAreas();

    public User getUserById(int userId);

    void updateUser(User updatedUser, int userId);

    void updateProfilePicture(int userId, byte[] imageBytes);
}
