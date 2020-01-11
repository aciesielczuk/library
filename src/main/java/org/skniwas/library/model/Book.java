package org.skniwas.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 100)
    private String author;

    @NotNull
    @Size(min = 2, max = 100)
    private String title;

    @NotNull
    private boolean availability;

    public Book() {
    }

    public Book(String author, String title, boolean availability) {
        this.author = author;
        this.title = title;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book{" +
               // "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", availability=" + availability +
                '}';
    }
}
