package com.carlosli.sudoker.user.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author lijiancheng
 * @date 2021/7/20
 */

@Service
public class PassListener {

    @RabbitListener(queues = "queue")
    public void pass(String message) {
        System.out.println(message);
    }

}
