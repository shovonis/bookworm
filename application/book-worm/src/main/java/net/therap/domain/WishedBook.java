package net.therap.domain;

import javax.persistence.*;

/**
 * @author shakhawat.hossain
 * @since 8/5/14 4:25 PM
 */

@Entity
@Table(name = "wished_book")
public class WishedBook {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String bookTitle;

    @Column(name = "author")
    private String bookAuthor;

    @ManyToOne
    private User user;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "WishedBook{" +
                "bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", user=" + user +
                '}';
    }
}
