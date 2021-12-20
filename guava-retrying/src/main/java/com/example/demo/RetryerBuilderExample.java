package com.example.demo;


import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class RetryerBuilderExample {
    public static void main(String[] args) {

        // 返回值是Boolean
        Retryer<Boolean> retryer = RetryerBuilder
                // 构建
                .<Boolean>newBuilder()
                // retryIf 重试条件
                .retryIfException()
                .retryIfException(Predicates.equalTo(new Exception()))
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfResult(Predicates.equalTo(false))
                // 等待策略
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))
                // 停止策略
                .withStopStrategy(StopStrategies.stopAfterAttempt(6))
                // 请求 RT 限制
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(2, TimeUnit.SECONDS))
                // 自定义重试监听器
                .withRetryListener(new RetryLogListener())
                // 默认的阻塞策略：线程睡眠
                .withBlockStrategy(BlockStrategies.threadSleepStrategy())
                // 自定义阻塞策略：自旋锁
                .withBlockStrategy(new SpinBlockStrategy())
                // 构建
                .build();


    }
}
