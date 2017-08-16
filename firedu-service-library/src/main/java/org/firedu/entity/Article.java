package org.firedu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author wujing
 * @date 2017-3-30
 * 文章类
 */

@Entity
@Table(name = "LIB_ARTICLE")
public class Article extends BaseModel {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "BOOK_ID")
    Book book;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "VOLUME_ID")
    Volume volume;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "CHAPTER_ID")
    Chapter chapter;

    @Column(name = "TITLE", length = 512)
    String title;

    @Column(name = "DESCRIPTION", length = 1024)
    String description;

    @Column(name = "ORDER_NUM", length = 3)
    Integer order_num;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    List<Section> sections;

    public Article() {
    }

    public Article(Long id, String title, String description, Integer order_num) {
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

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
