package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void send(String data){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic1", "something");
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println(result.toString());
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }

        });
    }
}
