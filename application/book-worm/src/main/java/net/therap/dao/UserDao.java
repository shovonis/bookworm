package net.therap.dao;

import net.therap.domain.User;

/**
 * @author rifatul.islam
 * @since 8/4/14.
 */

public interface UserDao {
    public User getAuthenticatedUser(String email, String password);

    public void addUser(User user);

    public void deleteUser(String userId);
}
