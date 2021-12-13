package com.devlhse.kafkapoc.controller;

import com.devlhse.kafkapoc.adapters.broker.kafka.dto.TransactionInputDto;
import com.devlhse.kafkapoc.adapters.broker.kafka.producer.TransactionProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    private final TransactionProducer transactionProducer;

    @PostMapping
    public void create(@RequestBody TransactionInputDto dto) throws JsonProcessingException {
        transactionProducer.send(dto);
    }
}
