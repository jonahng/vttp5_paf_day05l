package com.jonah.vttp5_paf_day05lproducer.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day05lproducer.model.Todo;
import com.jonah.vttp5_paf_day05lproducer.service.ProducerService;

@RestController
@RequestMapping("/api/messages")
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @PostMapping("")
    public ResponseEntity<String> sendMessage(@RequestBody Todo todo){
        producerService.sendMessage(todo);
        return new ResponseEntity<>("Message Sent", HttpStatus.OK);
    }
    
}
