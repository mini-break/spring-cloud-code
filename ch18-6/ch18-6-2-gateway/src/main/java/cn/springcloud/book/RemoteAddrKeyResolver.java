package cn.springcloud.book;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class RemoteAddrKeyResolver implements KeyResolver {

    public static final String BEAN_NAME = "remoteAddrKeyResolver";

    /**
     * 1.IP限流
     * @Bean
     * public KeyResolver ipKeyResolver() {
     *  return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
     * }
     * 通过exchange对象可以获取到请求信息，这边用了HostName，如果你想根据用户来做限流的话这边可以获取当前请求的用户ID或者用户名就可以了
     * 2.用户限流
     * 使用这种方式限流，请求路径中必须携带userId参数
     * @Bean
     * KeyResolver userKeyResolver() {
     *  return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
     * }
     * 3.接口限流
     * 获取请求地址的uri作为限流key
     * @Bean
     * KeyResolver apiKeyResolver() {
     *  return exchange -> Mono.just(exchange.getRequest().getPath().value());
     * }
     */
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

}

