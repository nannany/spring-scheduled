package com.example.demo.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StandardOutputTask {

    Logger logger = LoggerFactory.getLogger(StandardOutputTask.class);

    @Scheduled(fixedRate = 5000)
    public void fixedRate() throws InterruptedException {
        Thread.sleep(1000);
        logger.info("fixedRate");
    }

    @Scheduled(fixedDelay = 5000)
    public void fixedDelay() throws InterruptedException {
        Thread.sleep(1000);
        logger.info("fixedDelay");
    }

}
