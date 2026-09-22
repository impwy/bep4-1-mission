package com.back.shared.cash.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(
        onConstructor_ = @JsonCreator(mode = Mode.PROPERTIES)
)
@Getter
public class WalletDto {
    private final int id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final int holderId;
    private final String holderName;
    private final long balance;
}
