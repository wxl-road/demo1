package com.zjtc.demo.consumer_a.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjtc.demo.consumer_a.websocket.MessageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@RestController
@Slf4j
@ServerEndpoint("/consumerA")
public class FirstConsumerController {
    private Session session;
    private static CopyOnWriteArraySet<FirstConsumerController> webSockets = new CopyOnWriteArraySet<>();
    private MessageVO messageVO = new MessageVO();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
    }
    @OnClose
    public void onClose(){
        webSockets.remove(this);
    }

    @KafkaListener(topics = {"topic_a"})
    public void sendMsg(String message){
        System.out.println(message);
        this.sendMessage(message);
    }
    public void sendMessage(String message) {
        for (FirstConsumerController webSocket : webSockets) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
