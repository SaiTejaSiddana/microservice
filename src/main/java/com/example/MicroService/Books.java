package com.example.MicroService;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(1)
    private int bookId;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 20)
    private String bookName;


    @OneToOne(targetEntity = Authors.class)
    Authors authors;

    protected Books(){}

    public Books(String bookName, Authors authors){
        this.bookName = bookName;
        this.authors = authors;

    }

    public long getId() { return bookId; }
    public String getBookName() { return bookName; }
    //public int getAuthorId() { return authorId; }
    public Authors getAuthors() { return authors; }

    public void setId(int id) { this.bookId = id; }
    //public void setAuthorId(int authorId) { this.authorId = authorId; }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public void setAuthors(Authors authors) { this.authors = authors; }

    @Override
    public String toString(){
        return "Books{" +
                "id=" + bookId +
                ", bookName='" + bookName +   '\'' +
                ", authorId='" + authors.getAuthorId() +   '\'' +
                ", authorName='" + authors.getAuthorName() +   '\'' +
                '}';
    }

}
