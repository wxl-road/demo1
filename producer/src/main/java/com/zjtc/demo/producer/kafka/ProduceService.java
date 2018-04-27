package com.zjtc.demo.producer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProduceService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private KafkaTemplate<String,String> template;

    public void send(String topic,String msg){
        logger.info("on message:{}", msg);
        template.send(topic,msg);
    }
}
