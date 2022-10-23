package com.example.demo;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.example.demo.tasks")
public class EnableSchedulingConfig implements SchedulingConfigurer {

    Logger logger = LoggerFactory.getLogger(EnableSchedulingConfig.class);

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());

        taskRegistrar.addTriggerTask(
                () -> logger.info("custom scheduler"),
                triggerContext -> {
                    Date date = new Date();
                    return Date.from(date.toInstant().plusSeconds(5));
                }
        );

    }
}
