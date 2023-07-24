package com.leonardo.strconsumer.listeners;

import com.leonardo.strconsumer.custom.StrConsumerCustomListner;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {
//    @KafkaListener(
//            groupId = "group-1",
//            topicPartitions = {
//                    @TopicPartition(topic = "str-topic", partitions = {"0"})
//            },
//            topics = "str-topic",
//            containerFactory = "strContainerFactory")

    @StrConsumerCustomListner(groupId = "group-1") //Anotação criada para evitar retrabalho
    public void create(String message) {
        log.info("CREATE ::: Receive message {}", message);
    }

    @StrConsumerCustomListner(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Receive message {}", message);
    }
}
