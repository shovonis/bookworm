package net.therap.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

/**
 * @author shakhawat.hossain
 * @author rifatul.islam
 * @since 8/4/14 4:19 PM
 */

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "Title Cannot Be Empty")
    private String title;

    @Column(name = "author")
    @NotEmpty(message = "Author name cannot be empty")
    private String author;

    @Column(name = "edition")
    private String edition;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "quality")
    private int quality;

    @Column(name = "price")
    private double price;

    @Column(name = "details")
    private String details;

    @Column(name = "photo")
    @Lob
    private byte[] photo;

    @Column(name = "post_timestamp")
    private Timestamp postDateTime = new java.sql.Timestamp(new Date().getTime());

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ExchangeBook> exchangeBooks;

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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ExchangeBook> getExchangeBooks() {
        return exchangeBooks;
    }

    public void setExchangeBooks(Set<ExchangeBook> exchangeBooks) {
        this.exchangeBooks = exchangeBooks;
    }

    public Timestamp getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(Timestamp postDateTime) {
        this.postDateTime = postDateTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", publisher='" + publisher + '\'' +
                ", categoryId=" + categoryId +
                ", quality=" + quality +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", postDateTime=" + postDateTime +
                '}';
    }

}
