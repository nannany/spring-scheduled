package com.example.demo.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StandardOutputTask {

    @Scheduled(fixedRate = 5000)
    public void hello() {
        System.out.println("hello world");
    }

}
