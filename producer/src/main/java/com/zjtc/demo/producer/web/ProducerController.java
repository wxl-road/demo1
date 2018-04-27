package com.zjtc.demo.producer.web;

import com.zjtc.demo.producer.kafka.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private ProduceService produceService;

    @RequestMapping("/sendA")
    public void sendToProA(String data,String operate){
        produceService.send("topic_a",data);
        produceService.send("topic_c",operate+"+"+data);
    }
    @RequestMapping("/sendB")
    public void sendToProB(String data,String operate){
        produceService.send("topic_b",data);
        produceService.send("topic_c",operate+"+"+data);
    }
}
