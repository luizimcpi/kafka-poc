package com.devlhse.kafkapoc.adapters.broker.kafka.consumer;

import com.devlhse.kafkapoc.adapters.broker.kafka.dto.TransactionInputDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionConsumer {

    @Value("${topic.name.consumer")
    private String topicName;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload) throws JsonProcessingException {
        var transactionInputDto = objectMapper.readValue(payload.value(), TransactionInputDto.class);
        log.info("===========================================================");
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partition: {}", payload.partition());
        log.info("Transaction Received: {}", transactionInputDto);
    }
}
