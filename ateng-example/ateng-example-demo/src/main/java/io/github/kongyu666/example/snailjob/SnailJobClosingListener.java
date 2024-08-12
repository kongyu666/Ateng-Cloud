package io.github.kongyu666.example.snailjob;

import com.aizuda.snailjob.client.common.event.SnailClientClosingEvent;
import com.aizuda.snailjob.common.log.SnailJobLog;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaowoniu
 * @date 2024-03-14 22:00:58
 * @since 3.1.0
 */
@Component
public class SnailJobClosingListener implements ApplicationListener<SnailClientClosingEvent> {
    @Override
    public void onApplicationEvent(SnailClientClosingEvent event) {
        SnailJobLog.LOCAL.info("这是一个SnailJob开始关闭事件");
    }
}
