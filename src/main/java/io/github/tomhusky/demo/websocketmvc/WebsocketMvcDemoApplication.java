package io.github.tomhusky.demo.websocketmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebsocketMvcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketMvcDemoApplication.class, args);
    }

}
