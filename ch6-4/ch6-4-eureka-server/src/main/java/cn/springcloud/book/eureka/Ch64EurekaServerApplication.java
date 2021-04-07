package cn.springcloud.book.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 */
@SpringBootApplication
@EnableEurekaServer
public class Ch64EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch64EurekaServerApplication.class, args);
    }
	
}