package cn.springcloud.book.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Lovnx
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class Ch71EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch71EurekaServerApplication.class, args);
    }
}