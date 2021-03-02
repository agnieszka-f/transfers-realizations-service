package com.kodilla.transfersrealizationservice.connector.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private String nrb;
    private BigDecimal availableFunds;
}
