package org.firedu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author wujing0510@gmail.com
 * @date 2017-3-30.
 */

@Entity
@Table(name = "LIB_SECTION")
public class Section extends BaseModel {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "ARTICLE_ID")
    Article article;

    @Column(name = "CONTENT", length = 1024)
    String content;

    @Column(name = "ORDER_NUM", length = 3)
    Integer order_num;

    @Column(name = "DESCRIPTION", length = 1024)
    String description; //描述

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
