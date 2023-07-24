package com.leonardo.strproducer.services;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Send message {}", message);
        kafkaTemplate.send("str-topic", message)
                .addCallback(
                        success -> {
                            if(success != null) {
                                log.info("Send message with success {}", message);
                                log.info("Partition {}, Offset {}",
                                        success.getRecordMetadata().partition(),
                                        success.getRecordMetadata().offset());
                            }
                        },
                        error -> log.error("")
                );
    }
}
