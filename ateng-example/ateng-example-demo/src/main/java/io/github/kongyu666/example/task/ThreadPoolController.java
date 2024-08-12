package io.github.kongyu666.example.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的模板注释
 *
 * @author 孔余
 * @since 2024-05-30 15:54
 */
@RestController
@Slf4j
@RequestMapping("/task")
public class ThreadPoolController {

    /*@Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @GetMapping("/threadpool/status")
    public String getThreadPoolStatus() {
        return String.format("Core Pool Size: %d, Max Pool Size: %d, Active Threads: %d, Pool Size: %d, Queue Size: %d",
                taskExecutor.getCorePoolSize(),
                taskExecutor.getMaxPoolSize(),
                taskExecutor.getActiveCount(),
                taskExecutor.getPoolSize(),
                taskExecutor.getThreadPoolExecutor().getQueue().size());
    }*/

    @GetMapping("/async1")
    public void async1() {
        asyncMethod1();
    }

    @Async
    public void asyncMethod1() {
        // 模拟耗时操作
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
        log.info("执行异步任务 - " + Thread.currentThread().getName());
    }

}
