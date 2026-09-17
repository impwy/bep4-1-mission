package com.back.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
// 모든 엔티티들의 조상
public abstract class BaseEntity {
    public abstract int getId();

    public abstract LocalDateTime getCreateDate();

    public abstract LocalDateTime getModifyDate();

    public String getModelTypeCode() {
        return this.getClass().getSimpleName();
    }
}