package org.firedu.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author wujing
 * @date 2017-3-26
 * 图书类
 */

@Entity
@Table(name = "LIB_BOOK")
public class Book extends BaseModel {

    @Column(name = "TITLE", length = 500)
    String title; //书名

    @Column(name = "AUTHOR", length = 100)
    String author; //作者

    @Column(name = "TRANSLATOR", length = 100)
    String translator; //翻译者

    @Column(name = "DESCRIPTION", length = 500)
    String description; //描述

    @Column(name = "LANGUAGE", length = 3)
    String language; //语言

    @Column(name = "SUBJECT1", length = 100)
    String subject1; //分类1

    @Column(name = "SUBJECT2", length = 100)
    String subject2; //分类2

    @Column(name = "DATETIME", length = 100)
    String datetime; //日期

    @Column(name = "PUBLISHER", length = 100)
    String publisher; //出版商

    @Column(name = "ASIN", length = 100)
    String asin; //MOBI-ASIN

    @Column(name = "UUID", length = 100)
    String uuid; //uuid

    @Column(name = "COVER", length = 100)
    String cover; //cover

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    List<Volume> volumes;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    List<Chapter> chapters;

    public Book() {
    }

    public Book(Long id, String title, String author, String translator, String description,
                String language, String subject1, String subject2, String datetime,
                String publisher, String asin, String uuid, String cover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.translator = translator;
        this.description = description;
        this.language = language;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.datetime = datetime;
        this.publisher = publisher;
        this.asin = asin;
        this.uuid = uuid;
        this.cover = cover;
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

    @Column(name = "datetime", length = 100)
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Column(name = "PUBLISHER", length = 100)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "ASIN", length = 100)
    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    @Column(name = "UUID", length = 100)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Column(name = "COVER", length = 100)
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }


    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }


    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

}