package com.kodilla.transfersrealizationservice.connector;

import com.kodilla.transfersrealizationservice.connector.request.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "accounts")
public interface AccountConnector {
    @PutMapping("/v1/accounts/update")
    void updateBalance(@RequestBody AccountDto accountDto);
}
