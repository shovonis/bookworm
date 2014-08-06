package net.therap.service;

import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/6/14 12:13 PM
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;

    public User verifyAndGetUser(User user) {
       return userDao.getAuthenticatedUser(user.getEmail(), user.getPassword());
    }
}
