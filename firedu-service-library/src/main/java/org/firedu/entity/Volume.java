package org.firedu.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author wujing
 * @date 2017-3-30
 * 卷
 */

@Entity
@Table(name = "LIB_VOLUME")
@BatchSize(size = 20)
public class Volume implements Serializable {

    Long id;
    Book book;
    String title;
    String description; //描述
    Integer order_num;

    List<Chapter> chapters;
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
    @OneToMany(mappedBy = "volume", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @JsonIgnoreProperties(value={"hibernateLazyInitializer"})
    @OneToMany(mappedBy = "volume", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
