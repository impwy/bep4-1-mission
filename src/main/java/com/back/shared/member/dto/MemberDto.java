package com.back.shared.member.dto;

import java.time.LocalDateTime;

import com.back.boundedContext.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDto {
    private final int id;
    private final String username;
    private final String nickname;
    private final int activityScore;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.nickname = member.getNickname();
        this.activityScore = member.getActivityScore();
        this.createDate = member.getCreateDate();
        this.modifyDate = member.getModifyDate();
    }
}
