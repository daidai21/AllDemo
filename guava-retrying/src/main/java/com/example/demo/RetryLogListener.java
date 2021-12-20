package com.example.demo;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;

public class RetryLogListener implements RetryListener {
    @Override
    public <V> void onRetry(Attempt<V> attempt) {
        // 日志 是异常终止
        System.out.println(attempt.hasException());
        // 日志 还是正常返回
        System.out.println(attempt.getResult());
    }
}
