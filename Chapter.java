package com.example.test.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Field
    private String title;
    @Field
    @Column(columnDefinition = "TEXT")
    private String text;
    @ManyToOne
    @JoinColumn(name = "funfic_id")
    private Funfic funfic;

    public Chapter() {
    }

    public Chapter(String title, String text, Funfic funfic) {
        this.title = title;
        this.text = text;
        this.funfic = funfic;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Funfic getFunfic() {
        return funfic;
    }

    public void setFunfic(Funfic funfic) {
        this.funfic = funfic;
    }
}
