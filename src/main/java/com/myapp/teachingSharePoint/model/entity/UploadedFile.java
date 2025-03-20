package com.myapp.teachingSharePoint.model.entity;

import java.time.LocalDateTime;

public class UploadedFile {
    private Long id;
    private String name;
    private LocalDateTime uploadDate;

    public UploadedFile(Long id, String name, LocalDateTime uploadDate) {
        this.id = id;
        this.name = name;
        this.uploadDate = uploadDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }
}
