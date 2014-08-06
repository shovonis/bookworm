package net.therap.domain;

import javax.persistence.*;

/**
 * @author shakhawat.hossain
 * @since 8/6/14 10:15 AM
 */

@Entity
@Table(name = "book_exchange")
public class ExchangeBook {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String bookTitle;

    @Column(name = "author")
    private String bookAuthor;

    @ManyToOne
    private Book book;

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

    public Book getBook() {
        return book;
    }

    public void setUser(User user) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "WishedBook{" +
                "bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", book=" + book +
                '}';
    }
}
