package cn.springcloud.book.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Ch64ProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch64ProviderServiceApplication.class, args);
    }
    
}
