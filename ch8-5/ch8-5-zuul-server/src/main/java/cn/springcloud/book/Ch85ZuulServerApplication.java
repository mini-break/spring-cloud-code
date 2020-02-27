package cn.springcloud.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import cn.springcloud.book.filter.GrayFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Ch85ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch85ZuulServerApplication.class, args);
    }
    
    @Bean
    public GrayFilter grayFilter(){
    	return new GrayFilter();
    }
}
