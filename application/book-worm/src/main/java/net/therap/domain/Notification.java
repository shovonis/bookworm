package net.therap.domain;

import net.therap.domain.enums.NotificationType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14 4:27 PM
 */

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private NotificationType type = NotificationType.EXCHANGE;

    @Column(name = "date_time")
    private Timestamp dateTime = new java.sql.Timestamp(new Date().getTime());

    @Column(name = "is_seen")
    private boolean isSeen = false;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
