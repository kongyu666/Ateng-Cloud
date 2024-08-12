package io.github.kongyu666.example.snailjob;

import cn.dev33.satoken.annotation.SaIgnore;
import com.aizuda.snailjob.client.common.event.SnailClientClosedEvent;
import com.aizuda.snailjob.client.common.event.SnailClientClosingEvent;
import com.aizuda.snailjob.client.common.rpc.server.SnailNettyHttpServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/job")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JobController {

    @GetMapping("/close")
    @SaIgnore
    public void close() {
        SnailJobClosingListener listener = new SnailJobClosingListener();
        SnailJobClosedListener listener2 = new SnailJobClosedListener();
        listener.onApplicationEvent(new SnailClientClosingEvent());
        listener2.onApplicationEvent(new SnailClientClosedEvent());

        new SnailNettyHttpServer(null, null).close();
    }

}
