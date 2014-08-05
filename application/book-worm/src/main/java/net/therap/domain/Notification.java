package net.therap.domain;

import net.therap.domain.enums.NotificationType;

import java.util.Date;

/**
 * @author shakhawat.hossain
 * @since 8/4/14 4:27 PM
 */

public class Notification {
    private int notificationId;
    private User sender;
    private User receiver;
    private NotificationType notificationType;
    private Date notificationDate;
    private boolean isSeen;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", notificationType=" + notificationType +
                ", notificationDate=" + notificationDate +
                ", isSeen=" + isSeen +
                '}';
    }
}
