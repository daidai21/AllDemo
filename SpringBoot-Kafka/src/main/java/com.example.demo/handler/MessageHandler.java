package com.example.demo.handler;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.example.constants.KafkaConsts;


@Component
@Slf4j
public class MessageHandler {

	@KafkaListener(topics = KafkaConsts.TOPIC_TEST, containerFactory = "ackContainerFactory")
	public void handlerMessage(ConsumerRecord record, Acknowledgment acknowledgment) {
		try {
			String message = (String) record.value();
			log.info("Receive message: {}", message);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			acknowledgment.acknowledge();
		}
	}
}
