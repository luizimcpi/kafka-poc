package com.devlhse.kafkapoc.adapters.broker.kafka.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionInputDto {

    private String id;

    @JsonAlias("account_id")
    private String accountId;

    @JsonAlias("credit_card_number")
    private String creditCardNumber;

    @JsonAlias("credit_card_name")
    private String creditCardName;

    private BigDecimal amount;
}
