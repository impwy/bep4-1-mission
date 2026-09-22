package com.back.boundedContext.payout.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.payout.domain.Payout;
import com.back.shared.market.dto.OrderDto;
import com.back.shared.member.dto.MemberDto;
import com.back.shared.payout.dto.PayoutMemberDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PayoutFacade {
    private final PaymentSyncMemberUseCase paymentSyncMemberUseCase;
    private final PayoutCreatePayoutUseCase payoutCreatePayoutUseCase;
    private final PayoutAddPayoutCandidateItemUseCase payoutAddPayoutCandidateItemUseCase;

    public void syncMember(MemberDto member) {
        paymentSyncMemberUseCase.syncMember(member);
    }

    public Payout createPayout(PayoutMemberDto payee) {
        return payoutCreatePayoutUseCase.createPayOut(payee);
    }

    public void addPayoutCandidateItems(OrderDto order) {
        payoutAddPayoutCandidateItemUseCase.addPayoutCandidateItems(order);
    }
}
