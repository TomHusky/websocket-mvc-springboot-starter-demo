package io.github.tomhusky.demo.websocketmvc.job;

import io.github.tomhusky.demo.websocketmvc.intercepts.OnlineUserManage;
import io.github.tomhusky.websocket.SocketSessionManager;
import io.github.tomhusky.websocket.bean.SocketResult;
import io.github.tomhusky.websocket.enumerate.SocketResponseType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

/**
 * <p>
 * 测试服务端主动下发消息
 * <p/>
 *
 * @author lwj
 * @version 1.0
 * @since 2021/10/19 18:09
 */
@Component
@Slf4j
public class TestActiveMsgJob {

    @Scheduled(cron = "*/30 * * * * ?")
    public void test() {
        log.info("*************定时任务执行**************");
        Collection<String> collection = OnlineUserManage.getAll();
        for (String id : collection) {
            SocketResult socketResult = SocketResult.build("/test/sendText");
            socketResult.setType(SocketResponseType.INITIATIVE.getCode());
            socketResult.setBody("定时消息："+UUID.randomUUID());
            SocketSessionManager.sendMessages(id, socketResult);
        }
    }
}
