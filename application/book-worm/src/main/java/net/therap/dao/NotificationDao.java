package net.therap.dao;

import net.therap.domain.Notification;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/12/14.
 */

public interface NotificationDao {
    public List getAllNotification(int receiverId);

    public void addNewNotification(Notification notification);

    public void updateNotificationStatus(int notificationId);

    public long getUnseenNotification(int userId);
}
