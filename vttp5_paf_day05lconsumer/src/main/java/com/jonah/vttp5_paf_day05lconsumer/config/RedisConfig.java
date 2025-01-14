package com.jonah.vttp5_paf_day05lconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.jonah.vttp5_paf_day05lconsumer.model.Todo;
import com.jonah.vttp5_paf_day05lconsumer.service.ConsumerService;

@Configuration
public class RedisConfig {
    
    @Value("${redis.topic1}")
    private String redisTopic;

    @Bean
    RedisTemplate<String, Todo> redisTemplate(RedisConnectionFactory connFac,
    Jackson2JsonRedisSerializer<Todo> serializer){
        RedisTemplate<String, Todo> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connFac);
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public Jackson2JsonRedisSerializer<Todo> jackson2JsonRedisSerializer(){
        return new Jackson2JsonRedisSerializer<>(Todo.class);
    }


    @Bean
    public RedisMessageListenerContainer listenerContainer(MessageListenerAdapter messageListenerAdapter,
    RedisConnectionFactory redisConnectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListenerAdapter, new PatternTopic(redisTopic));
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(ConsumerService redisConsumerService){
        MessageListenerAdapter adapter = new MessageListenerAdapter(redisConsumerService);
        adapter.setSerializer(new Jackson2JsonRedisSerializer<>(Todo.class));
        return null;
    }
}
