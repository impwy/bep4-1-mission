package com.back.boundedContext.market.app;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.boundedContext.market.domain.MarketMember;
import com.back.boundedContext.market.domain.Product;
import com.back.shared.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MarketFacade {
    private final MarketMemberSyncUseCase marketMemberSyncUseCase;
    private final MarketCreateProductUseCase marketCreateProductUseCase;
    private final MarketSupport marketSupport;

    public void syncMember(MemberDto memberDto) {
        marketMemberSyncUseCase.syncMember(memberDto);
    }

    public Product createProduct(
            MarketMember seller,
            String sourceTypeCode,
            int sourceId,
            String name,
            String description,
            long price,
            long salePrice) {
        return marketCreateProductUseCase.createProduct(seller, sourceTypeCode, sourceId, name,
                                                        description, price, salePrice);
    }

    @Transactional(readOnly = true)
    public long productsCount() {
        return marketSupport.countProducts();
    }

    @Transactional(readOnly = true)
    public Optional<MarketMember> findMemberByUsername(String username) {
        return marketSupport.findMemberByUsername(username);
    }
}
