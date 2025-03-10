package com.empik.empik_backend.infrastructure.entity;

import org.springframework.data.annotation.Id;

public abstract class AbstractEntity {

    @Id
    Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}