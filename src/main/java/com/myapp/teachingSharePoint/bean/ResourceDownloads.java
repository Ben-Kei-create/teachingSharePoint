package com.myapp.teachingSharePoint.bean;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resource_downloads")
public class ResourceDownloads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "download_id")
    private Integer downloadId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "resource_id")
    private Integer resourceId;

    @Column(name = "download_datetime", insertable = false, updatable = false)
    private Timestamp downloadDatetime;

    // ゲッターとセッター
    public Integer getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(Integer downloadId) {
        this.downloadId = downloadId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Timestamp getDownloadDatetime() {
        return downloadDatetime;
    }

    public void setDownloadDatetime(Timestamp downloadDatetime) {
        this.downloadDatetime = downloadDatetime;
    }
}