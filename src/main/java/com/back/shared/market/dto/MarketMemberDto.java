package com.back.shared.market.dto;

import java.time.LocalDateTime;

import com.back.boundedContext.market.domain.MarketMember;

public record MarketMemberDto(int id, String username, String nickname, String password, int activityScore,
                              LocalDateTime createDate, LocalDateTime modifyDate) {
    public MarketMemberDto(MarketMember marketMember) {
        this(marketMember.getId(), marketMember.getUsername(), marketMember.getNickname(),
             marketMember.getPassword(), marketMember.getActivityScore(), marketMember.getCreateDate(),
             marketMember.getModifyDate());
    }
}
