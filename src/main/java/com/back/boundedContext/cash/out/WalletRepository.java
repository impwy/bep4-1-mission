package com.back.boundedContext.cash.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.boundedContext.cash.domain.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
