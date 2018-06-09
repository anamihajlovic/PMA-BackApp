package com.showbook.pma.controller.dto;

public class MailDto {

    private String to;
    private String subject;
    private String text;
    private String commentUser;

    public MailDto() {}

    public MailDto(String to, String subject, String text, String commentUser) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.commentUser = commentUser;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }
}
