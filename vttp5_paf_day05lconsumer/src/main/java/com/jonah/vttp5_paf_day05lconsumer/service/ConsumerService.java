package com.jonah.vttp5_paf_day05lconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day05lconsumer.model.Order;
import com.jonah.vttp5_paf_day05lconsumer.model.Todo;

@Service
public class ConsumerService implements MessageListener {
    @Autowired
    @Qualifier("order")
    private RedisTemplate<String, Order> template;
    
    public void handleMessage(Todo todo){
        //YOu can save the message received to database or perform actions.
        System.out.println("todo message received" + todo);

    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        
        // TODO Auto-generated method stub
        try {
            String orderData= new String(message.getBody());
            System.out.println("ORDER DATA" + orderData);

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }
    
}
