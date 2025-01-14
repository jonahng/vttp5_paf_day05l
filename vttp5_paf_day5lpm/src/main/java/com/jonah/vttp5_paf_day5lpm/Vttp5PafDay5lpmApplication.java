package com.jonah.vttp5_paf_day5lpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.java.com.jonah.vttp5_paf_day5lpm.service.MessagePoller;

@SpringBootApplication
public class Vttp5PafDay5lpmApplication implements CommandLineRunner{

	@Autowired
	private MessagePoller messagePoller;

	public static void main(String[] args) {
		SpringApplication.run(Vttp5PafDay5lpmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		
		messagePoller.start();
	}

}
