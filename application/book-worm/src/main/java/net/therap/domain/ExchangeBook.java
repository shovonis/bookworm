package net.therap.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author shakhawat.hossain
 * @since 8/6/14 10:15 AM
 */

@Entity
@Table(name = "book_exchange")
public class ExchangeBook implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public String getTitle() {
        return title;
    }

    public void setTitle(String bookTitle) {
        this.title = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String bookAuthor) {
        this.author = bookAuthor;
    }

    public void setUser(User user) {
        this.book = book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WishedBook{" +
                "bookTitle='" + title + '\'' +
                ", bookAuthor='" + author + '\'' +
                ", book=" + book +
                '}';
    }
}
