package com.example.demo;

import com.github.rholder.retry.*;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Example {

    private static int bar = 0;

    public static boolean foo() {
        bar++;
        System.out.println(LocalTime.now().toString() + " foo()");
        if (bar <= 2) {
            throw new RuntimeException("throw err");
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws ExecutionException, RetryException {
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfException()
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
        Boolean result = retryer.call(() ->  foo());
        System.out.println(result);
        System.out.println("end");
    }
}
