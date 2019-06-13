package com.example.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Funfic")
@Indexed
public class Funfic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Field
    private String title;
    @Field
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
//    @IndexedEmbedded(depth = 1)
    private User author;
//    @IndexedEmbedded(depth = 1)
    @OneToMany(mappedBy = "funfic", cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Comment> comments;
//    @IndexedEmbedded(depth = 1)
    @OneToMany(mappedBy = "funfic", cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Chapter> chapters;

    public Funfic() {
    }

    public Funfic(String title, String description, User author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @JsonIgnore
    @JsonProperty(value = "comments")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonIgnore
    @JsonProperty(value = "chapters")
    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}