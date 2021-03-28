package taskexecutor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TaskExecutor {

    @Value("${thread.count:10}")
    private int threadCount;
    @Value("worker.thread.name")
    private String threadNameTemplate;
    private AtomicInteger counter = new AtomicInteger();
    private ExecutorService executorService;

    @PostConstruct
    public void init() {
        ThreadFactory threadFactory = (runnable) -> new Thread(threadNameTemplate + counter.incrementAndGet());
        executorService = Executors.newFixedThreadPool(threadCount, threadFactory);
    }
}
