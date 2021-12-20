package com.example.demo;

import com.github.rholder.retry.BlockStrategy;

import java.time.Duration;
import java.time.LocalDateTime;


public class SpinBlockStrategy implements BlockStrategy {

    public SpinBlockStrategy() {
    }

    @Override
    public void block(long sleepTime) throws InterruptedException {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("[SpinBlockStrategy]...begin wait.");
        long start = System.currentTimeMillis();
        long end = start;
        while (end - start <= sleepTime) {
            end = System.currentTimeMillis();
        }

        System.out.println("[SpinBlockStrategy]...end wait.duration="
                + Duration.between(startTime, LocalDateTime.now()).toMillis());
    }
}
