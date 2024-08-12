package io.github.kongyu666.example.snailjob;

import com.aizuda.snailjob.client.job.core.annotation.JobExecutor;
import com.aizuda.snailjob.client.job.core.dto.JobArgs;
import com.aizuda.snailjob.client.model.ExecuteResult;
import org.springframework.stereotype.Component;

/**
 * SnailJob任务测试
 *
 * @author 孔余
 * @since 2024-05-27 16:00
 */
@Component
public class SnailJobTask {

    // 通过使用注解的模式执行任务
    @JobExecutor(name = "testJobExecutor")
    public ExecuteResult jobExecute(JobArgs jobArgs) {
        return ExecuteResult.success("测试成功" + jobArgs);
    }
}
