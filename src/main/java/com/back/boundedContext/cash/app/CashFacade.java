package com.back.boundedContext.cash.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CashFacade {
    private final CashMemberRepository cashMemberRepository;

    @Transactional
    public CashMember syncMember(MemberDto memberDto) {
        CashMember cashMember = new CashMember(memberDto.getId(), memberDto.getNickname(),
                                               memberDto.getUsername(), "",
                                               memberDto.getActivityScore(), memberDto.getCreateDate(),
                                               memberDto.getModifyDate());

        return cashMemberRepository.save(cashMember);
    }
}
