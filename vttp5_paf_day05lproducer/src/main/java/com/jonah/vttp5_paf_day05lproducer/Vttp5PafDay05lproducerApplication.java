package com.jonah.vttp5_paf_day05lproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jonah.vttp5_paf_day05lproducer.model.Todo;
import com.jonah.vttp5_paf_day05lproducer.service.ProducerService;

@SpringBootApplication
public class Vttp5PafDay05lproducerApplication {
	@Autowired
	static ProducerService producerService;

	public static void main(String[] args) {
		SpringApplication.run(Vttp5PafDay05lproducerApplication.class, args);

/* 		for(int i=0;i<1000;i++){
			Todo todo = new Todo();
			todo.setId(i);
			todo.setTaskName("task " + i);
			producerService.sendMessage(todo);
		} */
	}

}
