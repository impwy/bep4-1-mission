package com.back.boundedContext.payout.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.boundedContext.payout.domain.Payout;

public interface PayoutRepository extends JpaRepository<Payout, Integer> {
}
