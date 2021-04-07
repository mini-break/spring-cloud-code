package cn.springcloud.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Ch163BServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(Ch163BServiceApplication.class, args);
    }
}
