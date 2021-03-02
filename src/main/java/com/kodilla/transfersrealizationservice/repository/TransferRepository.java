package com.kodilla.transfersrealizationservice.repository;

import com.kodilla.transfersrealizationservice.domain.TransferDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Slf4j
public class TransferRepository {
    //symulacja zapisu do bd
    public void save(TransferDao transferDao){

        log.info("Saving the transfer");
    }
}
