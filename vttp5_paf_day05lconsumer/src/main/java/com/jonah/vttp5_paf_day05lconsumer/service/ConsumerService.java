package com.jonah.vttp5_paf_day05lconsumer.service;

import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day05lconsumer.model.Todo;

@Service
public class ConsumerService {
    
    public void handleMessage(Todo todo){
        //YOu can save the message received to database or perform actions.
        System.out.println("todo message received" + todo);
        
    }
    
}
