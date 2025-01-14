package main.java.com.jonah.vttp5_paf_day5lpm.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessagePoller {
    
    @Autowired
    @Qualifier("myredis")
    public RedisTemplate<String, String> template;

    @Async
    public void start(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new ThreadWorker(template, "task 1"));
        executorService.submit(new ThreadWorker(template, "tast 2222"));
    }
    
}
