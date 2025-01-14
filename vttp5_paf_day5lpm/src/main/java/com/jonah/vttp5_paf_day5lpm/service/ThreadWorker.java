package main.java.com.jonah.vttp5_paf_day5lpm.service;

import java.time.Duration;
import java.util.Optional;

public class ThreadWorker implements Runnable {

    @Autowired
    RedisTemplate<String, String> template;

    private String name;
    



    public ThreadWorker(RedisTemplate<String, String> template, String name) {
        this.template = template;
        this.name = name;
    }




    @Override
    public void run(){
        //day25 ppt slide no 10
        ListOperations<String, String> listOps = template.opsForList();
        while (true){
            try {
                Optional<String> option = Optional.ofNullable(listOps.rightPop("myqueue", Duration.ofSeconds(30)));
                if(option.isEmpty()){
                    continue;
                }
                String payload = option.get();
                System.out.println("the payload is" + payload);
                
            } catch (Exception e) {
                System.err.println(ex.getMessage());
                // TODO: handle exception
            }
        }

    }
    
}
