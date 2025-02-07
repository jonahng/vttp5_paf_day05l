package com.jonah.vttp5_paf_day05lproducer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day05lproducer.model.Order;
import com.jonah.vttp5_paf_day05lproducer.model.Todo;



@Service
public class ProducerService {
    @Autowired @Qualifier("todo")
    RedisTemplate<String, Todo> redisTemplate;

    @Value("${redis.topic1}")
    private String topic1;

    @Autowired @Qualifier("order")
    RedisTemplate<String, Order> redisTemplate2;

    @Autowired
    ChannelTopic channelTopic;

    public ProducerService(){
        redisTemplate = new RedisTemplate<>();
    }

    public void sendMessage(Todo todo){
        redisTemplate.convertAndSend(topic1, todo);
    }
    
    public Long publish(Order order){
        return redisTemplate2.convertAndSend(channelTopic.getTopic(), order);
    }
}
