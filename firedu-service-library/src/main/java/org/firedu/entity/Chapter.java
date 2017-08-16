package org.firedu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author wujing
 * @date 2017-3-30
 * 章节
 */

@Entity
@Table(name = "LIB_CHAPTER")
public class Chapter extends BaseModel {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "BOOK_ID")
    Book book; //图书主键

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "VOLUME_ID")
    Volume volume;

    @Column(name = "TITLE", length = 512)
    String title; //章节名

    @Column(name = "DESCRIPTION", length = 1024)
    String description; //描述

    @Column(name = "ORDER_NUM", length = 3)
    Integer order_num;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    List<Article> articles;

    public Chapter() {
    }

    public Chapter(Long id, String title, String description, Integer order_num) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.order_num = order_num;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
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

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
