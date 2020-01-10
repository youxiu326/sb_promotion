package com.youxiu326.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.stereotype.Component;

/**
 * 设置 @Async  线程池数量
 */
@Component
public class MyAsyncConfigurer implements AsyncConfigurer{
    
    @Override
    public Executor getAsyncExecutor() {
        ExecutorService service = Executors.newFixedThreadPool(6);
        return service;
    }

}
