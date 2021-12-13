package com.devlhse.kafkapoc.adapters.broker.kafka.producer;

import com.devlhse.kafkapoc.adapters.broker.kafka.dto.TransactionInputDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(TransactionInputDto transactionInputDto) throws JsonProcessingException {
        var message = objectMapper.writeValueAsString(transactionInputDto);
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
