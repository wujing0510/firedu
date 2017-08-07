package org.firedu.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * @author wujing
 * @date 2017-3-26
 * 图书类
 */

@Entity
@Table(name = "LIB_BOOK")
public class Book {

    Long id;
    String title; //书名
    String author; //作者
    String translator; //翻译者
    String description; //描述
    String language; //语言
    String subject1; //分类1
    String subject2; //分类2
    Date datetime; //日期
    String publisher; //出版商

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TITLE", length = 500)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "AUTHOR", length = 100)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "TRANSLATOR", length = 100)
    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    @Column(name = "DESCRIPTION", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "LANGUAGE", length = 3)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name = "SUBJECT1", length = 100)
    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    @Column(name = "SUBJECT2", length = 100)
    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    @Column(name = "DATE")
    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Column(name = "PUBLISHER", length = 100)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}