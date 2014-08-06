package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rifatul.islam
 * @since 8/6/14.
 */

@Service
@Transactional(value = "transactionManager")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getAuthenticatedUser(String email, String password) {
        return userDao.getAuthenticatedUser(email, password);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
