package com.back.boundedContext.payout.app;

import org.springframework.stereotype.Service;

import com.back.shared.payout.dto.PayoutMemberDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayoutCreatePayoutUseCase {
    public void createPayOut(PayoutMemberDto payee) {
        log.debug("createPayout.payee: {}", payee.getId());
    }
}
