package io.github.tomhusky.demo.websocketmvc.intercepts;

import io.github.tomhusky.websocket.interceptor.LoginValidIntercept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author luowj
 * @className: LoginValidIntercept
 * @date 2021/8/27 15:01
 * @version：1.0
 * @description: 登陆校验接口
 */
@Slf4j
@Component
public class TokenValidIntercept extends LoginValidIntercept {

    public static final String TOKEN_HEAD = "Authorization";

    @Override
    public boolean attemptAuthentication(ServerHttpRequest request, ServerHttpResponse response) {
        String token = request.getHeaders().getFirst(TOKEN_HEAD);
        if (token == null || StringUtils.isEmpty(token)) {
            return false;
        }
        // 进行逻辑判断
        if("b6j7s1b1w2d9w6p9m2x8n9k3i0j3p8s9".equals(token)){
            return true;
        }
        return false;
    }

    @Override
    public void successfulAuthentication(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("握手成功");
    }
}
