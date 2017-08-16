package org.firedu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author wujing
 * @date 2017-3-30
 * 章节
 */

@Entity
@Table(name = "LIB_CHAPTER")
public class Chapter implements Serializable {

    Long id;
    Book book; //图书主键
    Volume volume;
    String title; //章节名
    String description; //描述
    Integer order_num;

    List<Article> articles;

    @Id
    @Column(name = "ID", length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "VOLUME_ID")
    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    @Column(name = "TITLE", length = 512)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "DESCRIPTION", length = 1024)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "ORDER_NUM", length = 3)
    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    @JsonIgnoreProperties(value={"hibernateLazyInitializer"})
    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", book=" + book +
                ", volume=" + volume +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", order_num=" + order_num +
                ", articles=" + articles +
                '}';
    }
}
