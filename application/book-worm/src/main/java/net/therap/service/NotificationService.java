package net.therap.service;

import net.therap.domain.Notification;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/12/14.
 */


public interface NotificationService {
    public List<Notification> getAllNotification(int receiverId);
}
