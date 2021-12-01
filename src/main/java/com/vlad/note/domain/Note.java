package com.vlad.note.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer note_id;
    @Column(nullable = false)
    private String header;
    @Lob
    @Column(nullable = false, columnDefinition = "text",length=512)
    private String text;
    @Column(nullable = false)
    private String user_id;
    private LocalDateTime date;
    public Integer getNote_id() {
        return note_id;
    }

    public void setNote_id(Integer note_id) {
        this.note_id = note_id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
