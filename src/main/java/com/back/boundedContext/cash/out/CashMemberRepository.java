package com.back.boundedContext.cash.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.boundedContext.cash.domain.CashMember;

public interface CashMemberRepository extends JpaRepository<CashMember, Integer> {
}
