package org.firedu.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wujing0510@gmail.com
 * @date 2017-3-30.
 */

@Entity
@Table(name = "LIB_SECTION")
public class Section implements Serializable {

    Long id;
    Article article;
    String content;
    Integer order_num;
    String description; //描述

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
    @JoinColumn(name = "ARTICLE_ID")
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Column(name = "CONTENT", length = 1024)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "ORDER_NUM", length = 3)
    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    @Column(name = "DESCRIPTION", length = 1024)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
