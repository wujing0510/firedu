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
    String subject; //分类
    Date date; //日期
    String publisher; //出版商
    String asin; //出版商
    String coverPath; //封面
    String copyrightPath; //封面


    public Book() {
    }

    public Book(Long id, String title, String author, String translator,
                String description, String language, String subject, Date date,
                String publisher, String asin, String coverPath, String copyrightPath) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.translator = translator;
        this.description = description;
        this.language = language;
        this.subject = subject;
        this.date = date;
        this.publisher = publisher;
        this.asin = asin;
        this.coverPath = coverPath;
        this.copyrightPath = copyrightPath;
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

    @Column(name = "SUBJECT", length = 100)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "PUBLISHER", length = 100)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "ASIN", length = 200)
    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    @Column(name = "COVER_PATH", length = 200)
    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    @Column(name = "COPYRIGHT_PATH", length = 200)
    public String getCopyrightPath() {
        return copyrightPath;
    }

    public void setCopyrightPath(String copyrightPath) {
        this.copyrightPath = copyrightPath;
    }

}