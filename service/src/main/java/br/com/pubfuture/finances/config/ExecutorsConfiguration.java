package br.com.pubfuture.finances.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorsConfiguration {

    @Bean
    public Executor controllersExecutor(
        @Value("${finances.taskExecutor.pool.coreSize:10}") int corePoolSize,
        @Value("${finances.taskExecutor.pool.maxSize:20}") int maxPoolSize,
        @Value("${finances.taskExecutor.pool.queueCapacity:50}") int queueCapacity,
        @Value("${finances.taskExecutor.pool.keepAliveSeconds:60}") int keepAliveSeconds
    ) {
        return new ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize,
            keepAliveSeconds,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(queueCapacity, true)
        );
    }
}
