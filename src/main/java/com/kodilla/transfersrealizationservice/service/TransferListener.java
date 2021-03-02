package com.kodilla.transfersrealizationservice.service;

import com.kodilla.commons.TransferMessage;
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

    public TransferListener(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
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

}