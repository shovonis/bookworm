package net.therap.service.impl;

import net.therap.dao.NotificationDao;
import net.therap.domain.Notification;
import net.therap.service.NotificationService;
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

    @Override
    public List<Notification> getAllNotification(int receiverId) {
        return notificationDao.getAllNotification(receiverId);
    }
}
