package com.back.boundedContext.market.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketFacade {
    private final MarketMemberSyncUseCase marketMemberSyncUseCase;

    public void syncMember(MemberDto memberDto) {
        marketMemberSyncUseCase.syncMember(memberDto);
    }
}
