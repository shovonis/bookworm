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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public WishedBook() {
    }

    public WishedBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String bookAuthor) {
        this.author = bookAuthor;
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
                "id=" + id +
                ", bookTitle='" + title + '\'' +
                ", bookAuthor='" + author + '\'' +
                ", user=" + user +
                '}';
    }
}
