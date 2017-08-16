package org.firedu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * BaseModel
 *
 * @author Wu Jing
 * @date 2017-08-16 15:20:11
 */
@MappedSuperclass
public abstract class BaseModel implements Comparable<BaseModel>, Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "CREATE_TIME", nullable = false)
    private Date create_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "LAST_MODIFY_TIME", nullable = false)
    private Date last_modify_time;

    @PrePersist
    public void prePersist() {
        create_time = last_modify_time = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        last_modify_time = new Date();
    }

    @Override
    public int compareTo(BaseModel o) {
        return this.getId().compareTo(o.getId());
    }

    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass())
            return false;

        return this.getId().equals(((BaseModel) other).getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_modify_time() {
        return last_modify_time;
    }

    public void setLast_modify_time(Date last_modify_time) {
        this.last_modify_time = last_modify_time;
    }
}
