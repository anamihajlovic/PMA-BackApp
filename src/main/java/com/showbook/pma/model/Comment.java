package com.showbook.pma.model;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private Show show;

    public Comment() {}

    public Comment(Long id, String text, Show show) {
        this.id = id;
        this.text = text;
        this.show = show;
    }

    public Show getShow() {
        return show;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
