package com.kodilla.transfersrealizationservice.service;

import com.kodilla.commons.TransferMessage;
import com.kodilla.commons.UpdateBalancesMessage;
import com.kodilla.transfersrealizationservice.connector.AccountProvider;
import com.kodilla.transfersrealizationservice.connector.request.AccountDto;
import com.kodilla.transfersrealizationservice.domain.TransferDao;
import com.kodilla.transfersrealizationservice.repository.TransferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class TransferListener {

    private final TransferRepository transferRepository;
    private final AccountProvider accountProvider;

    public TransferListener(TransferRepository transferRepository, AccountProvider accountProvider) {
        this.transferRepository = transferRepository;
        this.accountProvider = accountProvider;
    }


    @KafkaListener(topics = "transfers")
    public void consume(@Payload TransferMessage transferMessage) throws IOException {
        log.info("Consumed transferMessage: {}", transferMessage);

        TransferDao transferDao = new TransferDao();
        transferDao.setSenderAccount(transferMessage.getTransfer().getSenderAccount());
        transferDao.setRecipientAccount(transferMessage.getTransfer().getRecipientAccount());
        transferDao.setTitle(transferMessage.getTransfer().getTitle());
        transferDao.setAmount(transferMessage.getTransfer().getAmount());

        transferRepository.save(transferDao);

    }
    @KafkaListener(topics = "updateBalance")
    public void consumeUpdateBalance(@Payload UpdateBalancesMessage updateBalance) throws IOException {
        log.info("Consumed updateBalanceMessage: {}", updateBalance);

        AccountDto accountDto = new AccountDto();
        accountDto.setNrb(updateBalance.getUpdateBalances().getNrb());
        accountDto.setAvailableFunds(updateBalance.getUpdateBalances().getBalance());

        accountProvider.update(accountDto);
    }

}