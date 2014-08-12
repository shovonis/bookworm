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
                "WHERE notifications.receiver.userId =:receiverId", Notification.class);
        query.setParameter("receiverId", receiverId);
        return query.getResultList();
    }
}
