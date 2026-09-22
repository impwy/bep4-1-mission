package com.back.boundedContext.payout.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.shared.market.dto.OrderDto;
import com.back.shared.market.dto.OrderItemDto;
import com.back.shared.market.out.MarketApiClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayoutAddPayoutCandidateItemUseCase {
    private final MarketApiClient marketApiClient;

    public void addPayoutCandidateItems(OrderDto order) {
        List<OrderItemDto> items = marketApiClient.getOrderItems(order.id());

        items.forEach(item -> {
            log.debug("orderItem.id : {}", item.getId());
        });
    }
}
