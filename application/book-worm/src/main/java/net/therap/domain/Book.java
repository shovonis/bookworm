package net.therap.domain;

import net.therap.domain.enums.BookQuality;

import javax.persistence.*;
import java.util.Arrays;

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
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "edition")
    private String edition;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "quality")
    private BookQuality quality;

    @Column(name = "price")
    private double price;

    @Column(name = "details")
    private String details;

    @Column(name = "photo")
    @Lob
    private byte[] photo;

    @Column(name = "exchange_list")
    private String exchangeList;

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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BookQuality getQuality() {
        return quality;
    }

    public void setQuality(BookQuality quality) {
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

    public String getExchangeList() {
        return exchangeList;
    }

    public void setExchangeList(String exchangeList) {
        this.exchangeList = exchangeList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", categoryId=" + categoryId +
                ", quality=" + quality +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", exchangeList='" + exchangeList + '\'' +
                '}';
    }
}
