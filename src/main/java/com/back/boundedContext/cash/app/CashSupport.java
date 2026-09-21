package com.back.boundedContext.cash.app;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.boundedContext.cash.out.WalletRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CashSupport {
    private final CashMemberRepository cashMemberRepository;
    private final WalletRepository walletRepository;

    public Optional<CashMember> findMemberByUserName(String username) {
        return cashMemberRepository.findByUsername(username);
    }

    public Optional<Wallet> findWalletByHolder(CashMember holder) {
        return walletRepository.findByHolder(holder);
    }

    public boolean isNew(int id) {
        return !cashMemberRepository.existsById(id);
    }
}
