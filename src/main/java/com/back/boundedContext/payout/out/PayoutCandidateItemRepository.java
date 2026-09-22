package com.back.boundedContext.payout.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.boundedContext.payout.domain.PayoutCandidateItem;

public interface PayoutCandidateItemRepository extends JpaRepository<PayoutCandidateItem, Integer> {
}