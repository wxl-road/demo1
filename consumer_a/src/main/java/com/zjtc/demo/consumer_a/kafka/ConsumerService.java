package com.zjtc.demo.consumer_a.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

   /* @KafkaListener(topics = {"topic1"})
    public void consumerMessage(String message) {
        logger.info("on topic1 message:{}", message);
    }*/
}

