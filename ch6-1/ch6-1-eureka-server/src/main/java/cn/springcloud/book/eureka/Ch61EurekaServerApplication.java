package cn.springcloud.book.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 */
@SpringBootApplication
@EnableEurekaServer
public class Ch61EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch61EurekaServerApplication.class, args);
    }
}