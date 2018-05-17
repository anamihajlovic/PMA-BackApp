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
    private Happening happening;

    public Comment() {}

    public Comment(Long id, String text, Happening happening) {
        this.id = id;
        this.text = text;
        this.happening = happening;
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

    public void setHappening(Happening happening) {
        this.happening = happening;
    }

    public Happening getHappening() {
        return happening;
    }
}
