package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=100)
    private String title;

    @NotNull
    @Size(min=2, max=100)
    private String author;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    @Size(max=100)
    private String studentname;

    // @ManyToOne
    // private Genre genre;


    public Book(String name, String description, String studentname) {
        this.title = name;
        this.description = description;
        this.studentname = studentname;
    }

    public Book() { }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    // public Genre getGenre() { return genre; }

    // public void setGenre(Genre genre) { this.genre = genre; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudentname() { return studentname; }

    public void setStudentname(String studentname) { this.studentname = studentname; }

}
