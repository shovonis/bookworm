package net.therap.service.impl;

import net.therap.dao.UserDao;
import net.therap.domain.Area;
import net.therap.domain.Book;
import net.therap.domain.User;
import net.therap.domain.WishedBook;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author rifatul.islam
 * @author shakhawat.hossain
 * @since 8/6/14.
 */

@Service
@Transactional(value = "transactionManager")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getAuthenticatedUser(User user) {
        return userDao.getAuthenticatedUser(user.getEmail(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        //TODO: Complete encryption
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode("123");
//        System.out.println(passwordEncoder.matches(hashedPassword, "123"));
//        System.out.println(hashedPassword);
        userDao.addUser(user);
    }

    @Override
    public Collection<Book> getPostedBooksByUserId(int userId) {
      return userDao.getPostedBooksByUserId(userId);
    }

    @Override
    public Collection<WishedBook> getWishedBooksByUserId(int userId) {
        return userDao.getWishedBooksByUserId(userId);
    }

    @Override
    public Collection<Area> getAreas() {
        return userDao.getAreas();
    }
}
