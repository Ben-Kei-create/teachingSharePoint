package com.myapp.teachingSharePoint.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "category")
    private String category;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "create_datetime", insertable = false, updatable = false)
    private java.sql.Timestamp createDatetime;

    @Column(name = "update_datetime", insertable = false)
    private java.sql.Timestamp updateDatetime;

    private String userName; // userNameフィールドを追加

    // ゲッターとセッター

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public java.sql.Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(java.sql.Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    public java.sql.Timestamp getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(java.sql.Timestamp updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}