package net.therap.dao.jpa;

import net.therap.dao.NotificationDao;
import net.therap.domain.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author rifatul.islam
 * @since 8/12/14.
 */

@Repository
public class NotificationDaoImpl implements NotificationDao {
    private static final Logger log = LoggerFactory.getLogger(NotificationDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Notification> getAllNotification(int receiverId) {
        Query query = entityManager.createQuery("SELECT notifications from Notification notifications " +
                "WHERE notifications.receiver.userId =:receiverId " +
                "AND notifications.isSeen = false ORDER BY notifications.dateTime DESC ", Notification.class);

        query.setParameter("receiverId", receiverId);
        return query.getResultList();
    }

    @Override
    public void addNewNotification(Notification notification) {
        entityManager.persist(notification);
    }

    @Override
    public void updateNotificationStatus(int notificationId) {

        Notification notification = entityManager.find(Notification.class, notificationId);
        notification.setIsSeen(true);
        entityManager.merge(notification);
        entityManager.flush();
        log.info("NOTIFICATION STATUS UPDATED SUCCESSFULLY");
    }

    @Override
    public long getUnseenNotification(int userId) {

        Query query = entityManager.createQuery("SELECT COUNT(notification.id) FROM Notification  notification " +
                " WHERE notification.receiver.userId =:userId AND notification.isSeen = false", Long.class);

        query.setParameter("userId", userId);
        long count = (Long) query.getSingleResult();

        log.info("NOTIFICATION COUNT QUERY EXECUTED {} ", count);
        return count;
    }
}
