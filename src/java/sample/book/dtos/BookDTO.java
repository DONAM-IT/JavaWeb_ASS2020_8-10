package sample.book.dtos;

import java.util.Date;

public class BookDTO {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int total;
    private int available;
    private Date publishYear;

    public BookDTO() {
    }

    public BookDTO(int id, String name, String author, String publisher, int total, int available, Date publishYear) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.total = total;
        this.available = available;
        this.publishYear = publishYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvailable() {
        return available;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isAvailable() {
        boolean result = false;

        return result;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
