package xyz.bolitao.tgumi.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author bolitao
 */
@Configuration
public class ExecutorServiceConfig {
    @Bean(name = "mailExecutorService")
    public ExecutorService mailExecutorService() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("mail-pool-%d").build();
        return new ThreadPoolExecutor(
                5,
                30,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024 * 1000),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
