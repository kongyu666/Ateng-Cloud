package io.github.kongyu666.example.snailjob;

import com.aizuda.snailjob.client.common.event.SnailClientClosedEvent;
import com.aizuda.snailjob.common.log.SnailJobLog;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaowoniu
 * @date 2024-03-14 22:00:58
 * @since 3.1.0
 */
@Component
public class SnailJobClosedListener implements ApplicationListener<SnailClientClosedEvent> {
    @Override
    public void onApplicationEvent(SnailClientClosedEvent event) {
        SnailJobLog.LOCAL.info("这是一个SnailJob关闭完成事件");
    }
}
