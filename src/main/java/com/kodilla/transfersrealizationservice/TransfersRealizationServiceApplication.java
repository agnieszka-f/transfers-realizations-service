package com.kodilla.transfersrealizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableFeignClients
@EnableDiscoveryClient
@EnableKafka
@SpringBootApplication
public class TransfersRealizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransfersRealizationServiceApplication.class, args);
    }

}
