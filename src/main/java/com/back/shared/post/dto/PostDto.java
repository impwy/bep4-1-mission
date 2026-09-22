package com.back.shared.post.dto;

import java.time.LocalDateTime;

import com.back.standard.modelType.HashModelTypeCode;

import lombok.AllArgsConstructor;

public record PostDto(int id, LocalDateTime createDate, LocalDateTime modifyDate, int authorId,
                      String authorName, String title, String content) implements HashModelTypeCode {
    @Override
    public String getModelTypeCode() {
        return "Post";
    }
}
