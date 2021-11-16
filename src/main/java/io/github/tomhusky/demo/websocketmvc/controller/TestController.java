package io.github.tomhusky.demo.websocketmvc.controller;

import io.github.tomhusky.demo.websocketmvc.common.JsonResult;
import io.github.tomhusky.demo.websocketmvc.vo.TestVo;
import io.github.tomhusky.websocket.annotation.SocketController;
import io.github.tomhusky.websocket.annotation.SocketRequestMapping;
import org.springframework.web.socket.WebSocketSession;

import javax.validation.Valid;

/**
 * <p>
 * 测试接口
 * <p/>
 *
 * @author lwj
 * @version 1.0
 * @since 2021/11/11 17:12
 */
@SocketController
@SocketRequestMapping("/test")
public class TestController {

    @SocketRequestMapping("/sendText")
    public JsonResult<String> sendText(String name) {
        System.out.println(name);
        return JsonResult.success("ok");
    }

    @SocketRequestMapping("/getAge")
    public JsonResult<String> getValue(TestVo testVo) {
        System.out.println(testVo);
        return JsonResult.success("ok");
    }

    @SocketRequestMapping("/getInfo")
    public JsonResult<String> getValue(TestVo testVo, WebSocketSession webSocketSession) {
        System.out.println(testVo);
        return JsonResult.success("ok");
    }

    @SocketRequestMapping("/getInfo")
    public JsonResult<String> getInfo2(@Valid TestVo testVo, WebSocketSession webSocketSession) {
        System.out.println(testVo);
        return JsonResult.success("ok");
    }
}
