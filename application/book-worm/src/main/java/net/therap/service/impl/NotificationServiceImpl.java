package net.therap.service.impl;

import net.therap.dao.NotificationDao;
import net.therap.domain.Book;
import net.therap.domain.Notification;
import net.therap.domain.User;
import net.therap.domain.enums.NotificationType;
import net.therap.service.BookService;
import net.therap.service.NotificationService;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/12/14.
 */

@Service
@Transactional("transactionManager")
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Override
    public List<Notification> getAllNotification(int receiverId) {
        return notificationDao.getAllNotification(receiverId);
    }

    @Override
    public void addNewNotification(int senderId, int receiverId, int bookId, int type, boolean isSeen) {

        User sender = userService.getUserById(senderId);
        User receiver = userService.getUserById(receiverId);
        Book book = bookService.getBookById(bookId);
        Notification notification = new Notification();
        notification.setBook(book);
        notification.setSender(sender);
        notification.setReceiver(receiver);
        NotificationType notificationType = NotificationType.values[type];
        notification.setType(notificationType);
//        notification.setIsSeen(isSeen);

        notificationDao.addNewNotification(notification);
    }
}
