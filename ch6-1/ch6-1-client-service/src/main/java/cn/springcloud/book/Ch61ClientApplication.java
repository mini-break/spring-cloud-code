package cn.springcloud.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author www.springcloud.cn
 *
 */
@SpringBootApplication
// 开启断路器
@EnableHystrix
@EnableDiscoveryClient
public class Ch61ClientApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(Ch61ClientApplication.class, args);
    }
}
