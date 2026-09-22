package com.back.boundedContext.payout.app;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.payout.domain.PayoutMember;
import com.back.boundedContext.payout.out.PayoutMemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PayoutSupport {
    private final PayoutMemberRepository payoutMemberRepository;

    public Optional<PayoutMember> findSystemMember() {
        return payoutMemberRepository.findByUsername("system");
    }

    public Optional<PayoutMember> findPayoutMember(int id) {
        return payoutMemberRepository.findById(id);
    }
}
