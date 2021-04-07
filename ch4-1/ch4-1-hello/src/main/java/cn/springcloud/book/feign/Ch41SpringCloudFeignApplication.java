package cn.springcloud.book.feign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 扫描所有带@FeignClient注解的类
@EnableFeignClients
public class Ch41SpringCloudFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ch41SpringCloudFeignApplication.class, args);
	}
}