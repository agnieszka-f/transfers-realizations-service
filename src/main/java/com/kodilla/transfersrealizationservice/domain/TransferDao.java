package com.kodilla.transfersrealizationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferDao {
    private String senderAccount;
    private String recipientAccount;
    private String title;
    private BigDecimal amount;
}
