package cn.springcloud.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import cn.springcloud.book.config.AvoidScan;
import cn.springcloud.book.config.TestConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
// 对client-a服务使用策略是经过TestConfiguration所配置的
@RibbonClient(name = "client-a", configuration = TestConfiguration.class)
//@RibbonClients(value = {
//		@RibbonClient(name = "client-a", configuration = TestConfiguration.class),
//		@RibbonClient(name = "client-b", configuration = TestConfiguration.class)
//})

// 让Spring不去扫描被@AvoidScan注解标记的配置类,因为我们配置的是对单个源服务生效的，所以不能应用于全局，如果不排除，启动会报错。
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidScan.class})})
public class RibbonLoadbalancerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonLoadbalancerApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}