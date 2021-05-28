package com.example.MicroService;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Authors {

    @Id
    @Min(1)
    private int authorId;

    //@OneToMany(targetEntity = Books.class)
    @NotBlank(message = "Name is mandatory")
    @Size(max = 20)
    private String authorName;


    protected Authors(){};

    public Authors(int authorId, String authorName){
        this.authorId = authorId;
        this.authorName = authorName;
    }


    public int getAuthorId() { return authorId; }
    public String getAuthorName() { return authorName; }

    public void setAuthorId(int authorId) { this.authorId = authorId; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

}