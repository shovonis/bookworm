package net.therap.service;

import net.therap.domain.Notification;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/12/14.
 */


public interface NotificationService {
    public List<Notification> getAllNotification(int receiverId);

    public void addNewNotification(int senderId, int receiverId, int bookId, int notificationType,
                                   boolean isSeen);

    public void updateAndInsertNotification(int notificationId, int senderId, int receiverId, int bookId,
                                            int notificationType, boolean isSeen);

    public long getUnseenNotification(int userId);
}
