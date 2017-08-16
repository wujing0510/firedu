package org.firedu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author wujing
 * @date 2017-3-30
 * 卷
 */

@Entity
@Table(name = "LIB_VOLUME")
public class Volume extends BaseModel {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "BOOK_ID")
    Book book;

    @Column(name = "TITLE", length = 512)
    String title;

    @Column(name = "DESCRIPTION", length = 1024)
    String description; //描述

    @Column(name = "ORDER_NUM", length = 3)
    Integer order_num;

    @OneToMany(mappedBy = "volume", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    List<Chapter> chapters;

    @OneToMany(mappedBy = "volume", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    List<Article> articles;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
