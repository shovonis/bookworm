package net.therap.domain;

import net.therap.domain.enums.BookQuality;

import java.util.List;

/**
 * @author shakhawat.hossain
 * @since 8/4/14 4:19 PM
 */

public class BookInfo {
    private int bookId;
    private String isbn;
    private String publisher;
    private String category;
    private String edition;
    private BookQuality bookQuality;
    private String bookDetails;
    private int price;
    private List<Book> exchangeList;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public BookQuality getBookQuality() {
        return bookQuality;
    }

    public void setBookQuality(BookQuality bookQuality) {
        this.bookQuality = bookQuality;
    }

    public String getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(String bookDetails) {
        this.bookDetails = bookDetails;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Book> getExchangeList() {
        return exchangeList;
    }

    public void setExchangeList(List<Book> exchangeList) {
        this.exchangeList = exchangeList;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", edition='" + edition + '\'' +
                ", bookQuality=" + bookQuality +
                ", bookDetails='" + bookDetails + '\'' +
                ", price=" + price +
                ", exchangeList=" + exchangeList +
                '}';
    }
}
