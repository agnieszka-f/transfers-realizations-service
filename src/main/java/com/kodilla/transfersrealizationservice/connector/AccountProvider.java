package com.kodilla.transfersrealizationservice.connector;

import com.kodilla.transfersrealizationservice.connector.request.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountProvider {
    private final AccountConnector accountConnector;

    public void update(final AccountDto accountDto){
        accountConnector.updateBalance(accountDto);
    }
}
