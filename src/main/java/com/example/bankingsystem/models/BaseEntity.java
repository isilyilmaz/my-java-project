package com.example.bankingsystem.models;

import java.sql.Timestamp;

public abstract class BaseEntity {
    protected int id;
    protected Timestamp createdAt;
    protected Timestamp updatedAt;

    public BaseEntity(int id, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
}
