package com.example.demo.tasks;

import java.util.concurrent.TimeUnit;

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

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void fixedRate_withTimeUnit() {
        logger.info("fixedRate_withTimeUnit");
    }

    @Scheduled(cron = "*/5 * * * * *", zone = "Asia/Tokyo")
    public void cron() {
        logger.info("cron");
    }
}
