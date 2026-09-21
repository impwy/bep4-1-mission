package com.back.boundedContext.cash.app;

import org.springframework.stereotype.Service;

import com.back.boundedContext.cash.domain.CashLog.EventType;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.global.eventPublisher.EventPublisher;
import com.back.shared.cash.event.CashOrderPaymentFailedEvent;
import com.back.shared.cash.event.CashOrderPaymentSucceededEvent;
import com.back.shared.market.event.MarketOrderPaymentRequestedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CashCompleteOrderPaymentUserCase {
    private final CashSupport cashSupport;
    private final EventPublisher publisher;

    public void handle(MarketOrderPaymentRequestedEvent event) {
        Wallet customerWallet = cashSupport.findWalletByHolderId(event.orderDto().customerId()).get();
        Wallet holdingWallet = cashSupport.findHoldingWallet().get();

        if (event.pgPaymentAmount() > 0) {
            customerWallet.credit(
                    event.pgPaymentAmount(),
                    EventType.충전__PG결제_토스페이먼츠,
                    "Order",
                    event.orderDto().id());
        }

        boolean canPay = customerWallet.getBalance() >= event.orderDto().salePrice();

        if (canPay) {
            customerWallet.debit(
                    event.orderDto().salePrice(),
                    EventType.사용__주문결제,
                    "Order",
                    event.orderDto().id());

            holdingWallet.credit(
                    event.orderDto().salePrice(),
                    EventType.임시보관__주문결제,
                    "Order",
                    event.orderDto().id());

            publisher.publish(new CashOrderPaymentSucceededEvent(event.orderDto(), event.pgPaymentAmount()));

        } else {
            publisher.publish(
                    new CashOrderPaymentFailedEvent("400-1",
                                                    "충전은 완료했지만 %d번 주문을 결제완료처리를 하기에는 예치금이 부족합니다."
                                                            .formatted(event.orderDto().id()),
                                                    event.orderDto(),
                                                    event.pgPaymentAmount(),
                                                    event.pgPaymentAmount() - customerWallet.getBalance()));
        }
    }
}
