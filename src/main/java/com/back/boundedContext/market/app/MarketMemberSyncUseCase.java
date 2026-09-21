package com.back.boundedContext.market.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.market.domain.MarketMember;
import com.back.boundedContext.market.out.MarketMemberRepository;
import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketMemberSyncUseCase {
    private final MarketMemberRepository marketMemberRepository;

    public MarketMember syncMember(MemberDto memberDto) {
        MarketMember marketMember = new MarketMember(memberDto.getId(),
                         memberDto.getUsername(),
                         memberDto.getNickname(),
                         "",
                         memberDto.getActivityScore(),
                         memberDto.getCreateDate(),
                         memberDto.getModifyDate());

        return marketMemberRepository.save(marketMember);
    }
}
