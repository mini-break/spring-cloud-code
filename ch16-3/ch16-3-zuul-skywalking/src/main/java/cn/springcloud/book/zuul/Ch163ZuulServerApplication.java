package cn.springcloud.book.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Ch163ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch163ZuulServerApplication.class, args);
    }
}