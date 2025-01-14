package main.java.com.jonah.vttp5_paf_day5lpm.service;

public class SubscriberService implements MessageListener{
    @Override
    public void onMessage(Message message, byte[] pattern){
        String data = new String(message.getBody());
        System.out.println("data received :" + data);
    }
}
