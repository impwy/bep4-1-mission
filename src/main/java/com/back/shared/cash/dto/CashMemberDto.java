package com.back.shared.cash.dto;

import java.time.LocalDateTime;

import com.back.boundedContext.cash.domain.CashMember;

public record CashMemberDto(int id, String nickname, String username, String password, int activityScore,
                            LocalDateTime createDate, LocalDateTime modifyDate) {
    public CashMemberDto(CashMember cashMember) {
        this(cashMember.getId(), cashMember.getNickname(), cashMember.getUsername(), cashMember.getPassword(),
             cashMember.getActivityScore(), cashMember.getCreateDate(), cashMember.getModifyDate());
    }
}
