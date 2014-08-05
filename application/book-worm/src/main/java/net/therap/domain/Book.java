package net.therap.domain;

import java.util.Arrays;

/**
 * @author shakhawat.hossain
 * @since 8/4/14 4:14 PM
 */

public class Book {
    private int bookId;
    private String title;
    private String author;
    private byte[] bookImage;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public byte[] getBookImage() {
        return bookImage;
    }

    public void setBookImage(byte[] bookImage) {
        this.bookImage = bookImage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookImage=" + Arrays.toString(bookImage) +
                '}';
    }
}
