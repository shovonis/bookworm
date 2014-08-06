package net.therap.service;

import net.therap.domain.User;

/**
 * @author rifatul.islam
 * @since 8/6/14.
 */


public interface UserService {
    public User getAuthenticatedUser(String email, String password);

}
